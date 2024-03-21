package com.example.bnb.websocket;

import okhttp3.*;

import java.io.IOException;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.CloseReason.CloseCodes;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/app")
public class BnbServerEndpoint {

    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Connected, sessionID = " + session.getId());
    }

    @OnMessage
    public String onMessage(String message, Session session) {
        if (message.equals("quit")) {
            try {
                session.close(new CloseReason(CloseCodes.NORMAL_CLOSURE, "Bye!"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {

            try {
                OkHttpClient httpClient = new OkHttpClient();

                RequestBody requestBody = RequestBody.create(message, MediaType.parse("application/json"));

                Request request = new Request.Builder()
                        .url("http://localhost:8080/add-currencies")
                        .post(requestBody)
                        .build();

                try (Response response = httpClient.newCall(request).execute()) {
                    if (response.isSuccessful()) {
                        System.out.println(response.body().string());
                    } else {
                        System.out.println("Request failed: " + response.code());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return message;
        }
        return "Server off";
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.println("Session " + session.getId() +
                " closed because " + closeReason);
    }
}