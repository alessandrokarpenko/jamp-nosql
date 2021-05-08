Services:
* http://localhost:8080/api/v1/

Open-API-documentation:
* http://localhost:8080/swagger-ui.html

Create index for email: 
* CREATE INDEX users_email ON `users`(email)

Create index for `name` field of `sport` object for `user`
* CREATE INDEX users_sport_name ON `users`(ALL DISTINCT ARRAY a.name FOR a IN sports END)
