# BNB currency

Microservice application to get all world currencies and make a connection between client and server websocket.

## Project summary <img align="left" alt="linkedin" width="30px" src="https://i.pinimg.com/originals/1b/37/a3/1b37a31607ae30bf0fd3cf73f6009447.png" />

Microservice with REST endpoint – “/download-currencies”. This endpoint can be hit numerous times everyday. When the endpoint being hit, we need to get the lastest information about all currencies from BNB in xml format. The data need to be saved in PostgreSql table and to send
this inforamtion through websocket in JSON format so this to happen wee need this to be also websocket server. The currencies need to be saved with the bulgarien and endlish names.
We need to create second service which reads the data and write it into another db table.

## Public part

The application's public part represents endpoint to see all world currencies in json format: `/download-currencies`.

## Error handling of ids

When we write the new currencies in the tables, firstly we delete the old ones and after that we rewrite the data with reset id starting again from 1.

## Languages and tools

[<img align="left" alt="linkedin" width="50px" src="https://www.google.com/url?sa=i&url=https%3A%2F%2F1000logos.net%2Fjava-logo%2F&psig=AOvVaw08hEJFk-9vylEl73mn3Ig4&ust=1711116354625000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCMiyoqXDhYUDFQAAAAAdAAAAABAI" />][java]
[<img align="left" alt="linkedin" width="50px" src="https://cdn.freebiesupply.com/logos/thumbs/2x/git-logo.png" />][git]
[<img align="left" alt="linkedin" width="35px" src="https://upload.wikimedia.org/wikipedia/commons/thumb/9/91/Octicons-mark-github.svg/2048px-Octicons-mark-github.svg.png" />][github]

<br/>


## Statistics

[![Valentin's GitHub stats](https://github-readme-stats.vercel.app/api?username=vasilev02&show_icons=true)](https://github.com/vasilev02/BNBcurrency)

<br/>

[![Most Used Languages](https://github-readme-stats.vercel.app/api/top-langs/?username=vasilev02)](https://github.com/vasilev02/BNBcurrency)


## Connect with me

[<img align="left" alt="linkedin" width="30px" src="https://cdn.icon-icons.com/icons2/2429/PNG/512/linkedin_logo_icon_147268.png" />][linkedin]

[java]: https://www.java.com/en/
[git]: https://git-scm.com/
[github]: https://github.com/
