<h1 align="center"> Review Agregator </h1>

<p>Pet-проект на Spring + Vue. База данных - Postgres</p>

<h1 align="center">Demo<h1>
  
<a href="https://review-agregator-production.up.railway.app" target="_blank">First Demo version on railway</a>
  
<img src="https://github.com/Saver-Igt/reviewAggregator/blob/main/demo.png">

# Installation
  
`mvn clean install`
  
# Stack
  
## backend
  
 <ul>
    <li>Java 8</li>
    <li>Spring Boot</li>
    <li>Spring Boot Data Jpa</li>
    <li>Spring Boot Security</li>
    <li>Postgres DataBase</li>
</ul>
 
## frontend
   <ul>
    <li>Vue</li>
    <li>VueRouter</li>
    <li>VueStore</li>
    <li>JavaScript</li>
    <li>Bootstrap</li>
</ul>
  
# Postgres Data Base
  
## Tables:
  
### games
  
| Name         | Type   | Constraints                        |
| ----------   | ------ | ---------------------------------- |
| `id`         | bigint | NOT NULL, Primary key              |
| `name`       | varchar| NOT NULL                           |
| `description`| varchar|                                    |
| `avg_rate`   | integer|                                    |
| `icon_url`   | varchar|                                    |
  
### usr
  
| Name         | Type   | Constraints                        |
| ----------   | ------ | ---------------------------------- |
| `id`         | bigint | NOT NULL, Primary key              |
| `username`   | varchar| NOT NULL                           |
| `password`   | varchar| NOT NULL                           |
| `first_name` | varchar|                                    |
| `last_name`  | varchar|                                    |
| `role`       | varchar|                                    |
| `status`     | varchar|                                    |
| `age`        | integer|                                    |
| `gender`     | varchar|                                    |
  
### reviews
  
| Name         | Type    | Constraints                        |
| ----------   | ------  | ---------------------------------- |
| `user_id`    | integer | NOT NULL, Primary key              |
| `game_id`    | integer | NOT NULL, Primary key              |
| `score`      | integer | NOT NULL                           |
| `comment`    | text    |                                    |
