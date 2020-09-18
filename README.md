# IoT Event Streaming Architecture
Internet of Things (IoT) and Event Streaming at Scale with Apache Kafka and MQTT


## Used technology

* Spring Boot 2.3.3 / Apache Maven 3.6.3.
* Spring Boot Starter Actuator.
* Kafka Streams.
* Spring Kafka.
* Micrometer Registry Prometheus.
* Eclipse Paho MQTT Client.
* Kafka Connect.
* Kafka Rest Proxy
* lombok.
* Jackson.
* NodeExporter (Exporter for machine metrics).
* Prometheus.
* Grafana.
* Eclipse Mosquitto.
* MongoDB.
* Mongo DB Express (Web-based MongoDB admin interface, written with Node.js and express).
* Cadvisor (Analyzes resource usage and performance characteristics of running containers).
* kafka-exporter (Kafka exporter for Prometheus).


## Running Applications as Docker containers.

### Rake Tasks

The available tasks are detailed below (rake --task)


| Task | Description |
| ------ | ------ |
| check_deployment_file_task | Check Deployment File |
| check_docker_task | Check Docker and Docker Compose Task |
| cleaning_environment_task | Cleaning Evironment Task |
| deploy | Deploys the IoT Event Streaming Architecture and laun... |
| login | Authenticating with existing credentials |
| start | Start Containers |
| status | Status Containers |
| stop | Stop Containers |
| undeploy | UnDeploy IoT Event Streaming Architecture |


To start the platform make sure you have Ruby installed, go to the root directory of the project and run the `rake deploy` task, this task will carry out a series of preliminary checks, discard images and volumes that are no longer necessary and also proceed to download all the images and the initialization of the containers.

  ### Containers Ports

| Container | Port |
| ------ | ------ |
| kafka-topics-ui | localhost:8081 |
| kafka-connect-ui | localhost:8082 |
| zoonavigator-web | localhost:8083 |
| mongo-express | localhost:8084 |
| grafana | localhost:8085 |
| prometheus | localhost:8086 |
| kafka-rest-proxy | localhost:9999 |

## Some screenshots

### Deploy with Docker Compose.

<img width="auto" src="./screenshots/platform_containers.PNG" />

### Viewing topics through Landoop Kafka Topics UI

<img width="auto" src="./screenshots/kafka_topics_1.PNG" />
<img width="auto" src="./screenshots/kafka_topics_2.PNG" />
