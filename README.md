# debezium-outbox-pgkafka

## Prerequisites

This project assumes you have the following installed on your machine:
* Gradle
* Docker
* Docker-compose
* Postman

## About the project

### Transactional outbox pattern
Using:
* **Spring boot & Flyway** -- app framework & DB migration
* **Postgresql 11** -- database
* **Debezium Kafka Connect & Postgresql connector** -- debezium wrapped kafka connect
* **Zookeeper**
* **Kafka** -- event store

*This project uses `pgoutput` as the logical decoding output plugin.*

### Content-Based Routing
This project also uses the `type` column in `outbox` table to route message into different topic.
```
E.g:
Type 'TodoCreatedEvent' will get published to 'sampleproject.todos.todo-created-event' 
Type 'TodoDeletedEvent' will get published to 'sampleproject.todos.todo-deleted-event' 
```

Routing is done with groovy expression. This project uses an image with *groovy-jsr223* added to classpath as the base image.   
https://hub.docker.com/r/fernandochristyanto/debezium-connect-base 

## How to run

1. Set up a static ip on local machine  

``` 
sudo ifconfig lo0 alias 192.168.99.3
```

2. Change directory to *todo-service* and run `./gradlew clean build`
3. In root directory, run `docker-compose up`
4. Import the postman collection
5. Hit the `Connector Registration` POST endpoint
6. Start doing transactions by inserting / deleting todos