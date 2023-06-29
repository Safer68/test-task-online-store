# test-task-online-store

# online-store
Задание:
1. Выбрать предметную область. На основе выбранной области, придумать композицию,
состоящей из не менее 2 объектов, отношения между которыми "один ко многим". Пример
композиций: город - достопримечательность, университет - факультет, студент - оценка
по предмету. Необходимо в произвольной форме сделать описание предметной области,
выбранной композиции и использумые в ней объекты. Для каждого объекта описать не
менее 5 свойств.
2. Создать Git репозиторий в котором будут хранится все файлы необходимые для сборки
и запуска будущего приложения.
3. Установить реляционную базу данных (БД) на выбор: MySQL или PostgreSQL. Создать
схему БД для хранения и управления данными для смоделированных объектов. Добавить
файлы инициализации схемы данных в Git репозиторий. Дополнительным, совсем
необязательным, плюсом будет использование Docker контейнера для БД.
4. Создать REST API приложение в архитектурном стиле MVC на основе фрэймворка
Spring Boot. Требования:
- Java, версия от 8+
- приложение содержит пул подключений к БД
- имплементированы классы-модели в Java для отображения смоделированных
объектов
- решена задача объектно-реляционного отображения
- создан интерфейс API (Application Programming Interface) на основе архитектурного
стиля REST для проведения CRUD (Create, Read, Update, Delete) операций над
объектами. Взаимодействие с API реализовано в формате JSON
- в корне проекта содержится README.md файл. README.md содержит описание всех
зависимостей подключенных в проект, а также пошаговые инструкции для сборки и
запуска приложения

- подготовлены по одному примеру запроса для каждого эндпоинта в одном из
следующих форматов: сURL, HTTP, wget. Примечание: можно сгенерировать результат с
использованием инструмента тестирования Postman или инструмента автоматической
генерации документации Swagger. При использовании Postman добавить файлы
коллекции Postman в структуру проекта
## Описание предметной области
Онлайн магазин. Есть база клиентов и у каждого клиента есть свой список заказов

Описание композиции: Клиент - основной класс который имеет:id,name,surname, country, phoneNumber, address, orders. У каждого клиента есть свой список заказов которые имеет:id,number, product, price, status, client.

## Зависимости

> spring-boot-starter-data-jpa (Зависимость для работы с JPA)

> spring-boot-starter-web (Зависимость для работы с RESTful)

> liquibase-core (Зависимость для работы с Liquibase)

> spring-boot-docker-compose (Зависимость для создает Docker контейнера)

> mysql-connector-j (Драйвер для подключения к бд mySQL)

> lombok (Lombok для автоматической генерации сетеров\гетеров и тд.)

> spring-boot-starter-test (Зависимость для тестирования)

> mapstruct (Библиотека, которая помогает маппить объекты одних сущностей в объекты других сущностей)

> lombok-mapstruct-binding (Зависимость для корректной работы lombok с mapstruct)

>springdoc-openapi-starter-webmvc-ui (служит для интеграции spring-boot и swagger-ui)

> spring-boot-starter-parent (Родительская зависимость для SpringBoot, определяет версию и настройки для проекта)

## Инструкция для запуска

1. Склонируйте репозиторий: git clone https://github.com/Safer68/test-task-online-store
2. Запустите склонированный код через IDE 
3. После запуска кода заходим  http://localhost:8080/swagger-ui/index.html
