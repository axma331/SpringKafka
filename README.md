# Реализация системы мониторинга с использованием Spring Kafka

Данное приложение реализует систему мониторинга метрик с использованием **Apache Kafka** для отправки и потребления данных. Система состоит из двух микросервисов: **Metrics Producer** и **Metrics Consumer**, которые отправляют и обрабатывают метрики приложения. Эти данные сохраняются в базу данных и доступны через REST API.

<details>
<summary>Полный текст задания</summary>

Цель:

Создать систему мониторинга, которая будет отслеживать работу различных компонентов вашего приложения с помощью Spring Kafka. Эта система будет включать в себя Producer для отправки метрик, Consumer для их обработки и анализа, а также REST API для просмотра метрик.

Общая архитектура системы:

Producer Service:

Создать микросервис "Metrics Producer", который будет отслеживать и собирать метрики работы приложения и отправлять их в Kafka топик "metrics-topic".

Реализовать следующие API для взаимодействия с микросервисом:

POST /metrics: Отправка метрик работы приложения в формате JSON. Метрики могут включать информацию о производительности, использовании ресурсов, ошибках и т. д.

Consumer Service:

Создать микросервис "Metrics Consumer", который будет принимать метрики из Kafka топика "metrics-topic" и анализировать их для выявления проблем и трендов.

Реализовать обработку метрик и вывод статистики в логи или базу данных для последующего анализа.

REST API:

Реализовать REST API в микросервисе "Metrics Consumer" для просмотра метрик.

GET /metrics: Получение списка всех метрик.

GET /metrics/{id}: Получение конкретной метрики по ее идентификатору.

Критерии успешного выполнения:

Микросервисы должны успешно обмениваться данными через Kafka и обеспечивать сбор и анализ метрик работы приложения.

API должно быть хорошо спроектировано, документировано и соответствовать принципам RESTful.

Система должна быть масштабируемой, надежной и обладать высокой производительностью.

Должна быть предоставлена документация, объясняющая архитектуру системы, конфигурацию Kafka, а также инструкции по запуску и использованию системы.
</details>

## Технологии

Проект использует следующие технологии и инструменты:

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white "Java")
![Maven](https://img.shields.io/badge/Maven-green.svg?style=for-the-badge&logo=mockito&logoColor=white "Maven")
![Spring](https://img.shields.io/badge/Spring-blueviolet.svg?style=for-the-badge&logo=spring&logoColor=white "Spring")
![Kafka](https://img.shields.io/badge/kafka-%2300ACBD.svg?style=for-the-badge&logo=apachekafka&logoColor=white "Kafka")
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white "PostgreSQL")
![Liquibase](https://img.shields.io/badge/Liquibase-%230073AF.svg?style=for-the-badge&logo=liquibase&logoColor=white "Liquibase")
![Swagger](https://img.shields.io/badge/swagger-%238DC745.svg?style=for-the-badge&logo=swagger&logoColor=white "Swagger")

- **Язык программирования**: Java 17
- **Автоматизация сборки**: Maven
- **Фреймворк**: Spring Boot
- **Сообщения**: Apache Kafka
- **База данных**: PostgreSQL
- **Миграция данных**: Liquibase
- **Документация API**: Swagger/OpenAPI

## Функционал системы

- **Metrics Producer** отправляет метрики приложения в Kafka.
- **Metrics Consumer** принимает сообщения из Kafka, сохраняет метрики в базу данных и предоставляет REST API для просмотра всех или отдельных метрик.

## Установка и запуск

### Шаги для локального запуска:

1. Клонируйте репозиторий:
    ```bash
    git clone https://github.com/axma331/SpringKafka.git
    cd SpringKafka
    ```

2. Настройте базу данных PostgreSQL в файле `application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/db_t1
    spring.datasource.username=postgres
    spring.datasource.password=postgre
    ```

3. Запустите Kafka и Zookeeper с помощью Docker:
    ```bash
    docker-compose up
    ```

4. Соберите и запустите оба микросервиса:
    - **Metrics Producer**:
      ```bash
      cd metrics-producer
      mvn spring-boot:run
      ```
    - **Metrics Consumer**:
      ```bash
      cd metrics-consumer
      mvn spring-boot:run
      ```

## Использование API

### Примеры запросов

- Получение всех метрик:
    ```bash
    GET /api/v1/metric
    ```

- Получение метрики по ID:
    ```bash
    GET /api/v1/metric/{id}
    ```

### Swagger UI

Для тестирования и просмотра API-документации используйте Swagger UI:

- **Metrics Producer**: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
- **Metrics Consumer**: [http://localhost:8081/swagger-ui.html](http://localhost:8081/swagger-ui.html)

## Пример работы с Kafka

Для отправки метрики в топик Kafka:
```bash
POST /api/v1/send-metric
```
### Миграции базы данных

Проект использует **Liquibase** для управления схемой базы данных. Все миграции описаны в файлах `db/changelog/`.

## Контакты

Разработчик: [Ismailov](mailto:example@email.com)
