<h1 align="center"> Review Agregator </h1>

## Описание

<p>Агрегатор отзывов - система, которая собирает оценки и обзоры на на товары и услуги. В данном случае на игры.
В нем пользователь могут просмотреть оценки других пользователей или опубликовать свою оценку.
Возможность удаления или изменяя оценки также присутствует.
Для этого необходимо создать новую учетную запись или войти в существующую (для теста можно использовать логин - "u" и пароль - "u").
</p>

## Будущее

<p>
В будущем планируется закончить раздел поиска.
Интегрировать SteamAPI для добавления игр и возможности переносить оценки из Steam в агрегатор.
Разработать панель админа для добавления игр или сделать для этого Telegram-бота.
</p>

<h1 align="center">Demo<h1>

<img src="https://github.com/Saver-Igt/reviewAggregator/blob/main/demo.png">

# Установка
  
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
