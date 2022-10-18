## Location Writer
* ### How To Run
    * To first start the User microservice run the [Server](https://github.com/mhdzaid/server) as well as the [Gateway](https://github.com/mhdzaid/gateway) so that the Eureka Discovery service can register it.
    * Run the `PostgreSQL` docker-compose file using the command
  ```
  docker-compose -f util/postgres.yml up -d

    ```
    * Run the `ApacheKafka` docker-compose file using the command
  ```
    docker-compose -f util/kafka.yml up -d
    ```
    * You would also need to start up the [Location-Reader](https://github.com/mhdzaid/location-reader) microservice as well.
    * Multiple instances of this application can be run by using the environment variables in `application.yaml` file which are `DATABASE_HOST` , `DATABASE_PORT` , `KAFKA_HOST`, `KAFKA_PORT`
