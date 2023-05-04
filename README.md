# reviewAggregator
<p>Pet-проект на Spring + Vue. База данных - Postgres</p>
<h1 align="center">Demo<h1>
<a href="https://review-agregator-production.up.railway.app" target="_blank">Посмотреть</a>
<img src="\demo.png">
# Installation
`mvn clean install`
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
