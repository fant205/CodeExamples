# Описание

Пример конфигурируемого приложения, которое может быть упаковано в docker-образ.

## Запускаем приложение с профилем local
Без указания профиля приложение запустится, используя конфигурацию `application.yml`.
В нем прописан адрес h2 in-memory базы данных.

## Переключаем профиль
Запускаем в докере базу данных postgres:
```
docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:11.1
```

Подключаемся через psql в серверу:
```
docker exec -it postgres psql -U postgres
```

Создаем базу данных:
```
create database resource;
\q
```
Запускаем приложение с профилем `dev`.

## Упаковываем приложение в docker-образ
### Вариант 2: создание собственного образа
Запускаем команду maven: 
```
mvn spring-boot:build-image
```

Запускаем приложение: 
```
docker run --name sbd -p 8080:8080 -d spring-boot-docker:0.0.1-SNAPSHOT
```

Запускаем приложение с конкретным профилем:
```
docker run --name sbd -p 8080:8080 -d -e "SPRING_PROFILES_ACTIVE=dev" spring-boot-docker:0.0.1-SNAPSHOT
```

Получаем ошибку. 
Потому что контейнер с postgres работает в другой сети.
Чтобы их объединить, нужно запускать их в одной сети.

Создаем сеть:
```
docker network create my-network
```

Запускаем контейнеры в указанной сети
```
docker run --name postgres -p 5432:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -d --network my-network postgres:11.1
docker run --name sbd -p 8080:8080 -d -e "SPRING_PROFILES_ACTIVE=dev" -e spring.datasource.url=jdbc:postgresql://postgres:5432/resource --network my-network spring-boot-docker:0.0.1-SNAPSHOT
```


## Поднятие нескольких контейнеров сразу
Для поднятия нескольких контейнеров сразу можно описать `docker-compose.yml` файл и запустить его с помощью docker-compose up.