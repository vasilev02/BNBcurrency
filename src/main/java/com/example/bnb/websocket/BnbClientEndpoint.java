package com.example.bnb.websocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;

import java.net.URL;
import java.util.concurrent.CountDownLatch;
import javax.websocket.*;

import org.glassfish.tyrus.client.ClientManager;


@ClientEndpoint
public class BnbClientEndpoint {
    private static CountDownLatch latch;

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Do you want to see currencies?\n" +
                "Type 'yes' or any other key will close the connection.");
        System.out.println("--- Connected " + session.getId());
        try {
            session.getBasicRemote().sendText("Test connection");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @OnMessage
    public String onMessage(String message, Session session) throws IOException {
        System.out.println("--- Received " + message);
        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
        String userInput = bufferRead.readLine();

        if (userInput.equals("yes")) {
            try {
                URL url = new URL("http://localhost:8080/download-currencies");

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                String result = response.toString();
                connection.disconnect();
                return result;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "quit";
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Session " + session.getId() +
                " closed because " + closeReason);
        latch.countDown();
    }

    public static void main(String[] args) {
        latch = new CountDownLatch(1);
        ClientManager client = ClientManager.createClient();
        try {
            client.connectToServer(BnbClientEndpoint.class, new URI("ws://localhost:8025/folder/app"));
            latch.await();
        } catch (DeploymentException | URISyntaxException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}