# debezium-outbox-pgkafka

## Prerequisites

This project assumes you have the following installed on your machine:
* Gradle
* Docker
* Docker-compose
* Postman

## About the project

Trying transactional outbox pattern using:

* **Spring boot** -- app framework
* **Postgresql 11** -- database
* **Debezium Kafka Connect & Postgresql connector** -- debezium wrapped kafka connect
* **Zookeeper**
* **Kafka** -- event store

*This app uses `pgoutput` as the logical decoding output plugin*

## How to run

1. Set up a static ip on local machine  

``` 
sudo ifconfig lo0 alias 192.168.99.3
```

2. Change directory to todo-service and run `./gradlew clean build`
3. In root directory, run `docker-compose up`
4. Import the postman collection
5. Hit the `Connector Registration` POST endpoint
6. Start doing transactions by inserting / deleting todos