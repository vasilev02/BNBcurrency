# BNB currency

Microservice application to get all world currencies and make a connection between client and server websocket.

## Project summary <img align="left" alt="linkedin" width="30px" src="https://i.pinimg.com/originals/1b/37/a3/1b37a31607ae30bf0fd3cf73f6009447.png" />

Microservice with REST endpoint – “/download-currencies”. This endpoint can be hit numerous times everyday. When the endpoint being hit, we need to get the lastest information about all currencies from BNB in xml format. The data need to be saved in PostgreSql table and to send
this inforamtion through websocket in JSON format so this to happen wee need this to be also websocket server. The currencies need to be saved with the bulgarien and endlish names.
We need to create second service which reads the data and write it into another db table.

## Usage
First we start the main spring method - CurrencyServiceApplication.
<br/>
<img width="600" alt="Screenshot 2024-03-21 at 15 35 17" src="https://github.com/vasilev02/BNBcurrency/assets/59262958/4e348042-5a04-482f-9662-935c76131ed3">
<br/>
Go to postman and we can see the data in json format which we get it from a file from resources package.
<br/>
<img width="600" alt="Screenshot 2024-03-21 at 15 36 36" src="https://github.com/vasilev02/BNBcurrency/assets/59262958/7a25adfa-f7ed-4f0f-afd0-667f6995eac0">
<br/>
After that we start the BnbServer. Which will create our server - BnbServerEndopint. ServerEndPoint is a class-level annotation that declares that the class it decorates is a WebSocket endpoint deployed and made available in a WebSocket server.
<br/>
<img width="600" alt="Screenshot 2024-03-21 at 15 35 34" src="https://github.com/vasilev02/BNBcurrency/assets/59262958/f5b5a066-26d0-42cb-a474-954acded7388">
<br/>
We start our BnbClientEndpoint and we type yes if we want to get the info about currencies. Any other key will close the connection.
<br/>
<img width="600" alt="Screenshot 2024-03-21 at 15 35 39" src="https://github.com/vasilev02/BNBcurrency/assets/59262958/7704a188-6a66-4d23-8e39-311b4ef778d1">
<br/>
Then we go to see the database and the data in it. First for Currency.
<br/>
<img width="600" alt="Screenshot 2024-03-21 at 15 36 22" src="https://github.com/vasilev02/BNBcurrency/assets/59262958/3491293e-befd-421e-9799-b6fb1e56cfee">
<br/>
And after that for CurrencyFromServer.
<br/>
<img width="600" alt="Screenshot 2024-03-21 at 15 36 26" src="https://github.com/vasilev02/BNBcurrency/assets/59262958/fc8a7bcb-509a-422d-b2c7-df7c0aa97eff">


## Public part

The application's public part represents endpoint to see all world currencies in json format: `/download-currencies`.

## Error handling of ids

When we write the new currencies in the tables, firstly we delete the old ones and after that we rewrite the data with reset id starting again from 1.

## Languages and tools

[<img align="left" alt="linkedin" width="50px" src="https://logowik.com/content/uploads/images/731_java.jpg" />][java]
[<img align="left" alt="linkedin" width="50px" src="https://cdn.freebiesupply.com/logos/thumbs/2x/git-logo.png" />][git]
[<img align="left" alt="linkedin" width="35px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Octicons-mark-github.svg/2048px-Octicons-mark-github.svg.png" />][github]

<br/>


## Statistics

[![Valentin's GitHub stats](https://github-readme-stats.vercel.app/api?username=vasilev02&show_icons=true)](https://github.com/vasilev02/BNBcurrency)

<br/>

[![Most Used Languages](https://github-readme-stats.vercel.app/api/top-langs/?username=vasilev02)](https://github.com/vasilev02/BNBcurrency)


## Connect with me

[<img align="left" alt="linkedin" width="30px" src="https://cdn.icon-icons.com/icons2/2429/PNG/512/linkedin_logo_icon_147268.png" />][linkedin]

[linkedin]: https://www.linkedin.com/in/valentin-vasilev-849a8b1a6/
[java]: https://www.java.com/en/
[git]: https://git-scm.com/
[github]: https://github.com/
