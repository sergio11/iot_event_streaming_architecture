# Introduction

This project provides connectors for Kafka Connect to read and write data to a MQTT broker.

# Using with AWS IOT

```bash
sudo mkdir /opt/aws-iot/
sudo aws iot create-keys-and-certificate --set-as-active --certificate-pem-outfile /opt/aws-iot/cert.crt --private-key-outfile /opt/aws-iot/private.key --public-key-outfile /opt/aws-iot/public.key --region us-east-1
sudo openssl pkcs12 -export -in /opt/aws-iot/cert.crt -inkey /opt/aws-iot/private.key -out /opt/aws-iot/p12.keystore -name alias
(type in the export password)

$ keytool -importkeystore -srckeystore p12.keystore -srcstoretype PKCS12 -srcstorepass <export-password> -alias alias -deststorepass <keystore-password> -destkeypass <key-password> -destkeystore my.keystore 

$ openssl x509 -outform der -in certificate.pem -out certificate.der
$ keytool -import -alias your-alias -keystore cacerts -file certificate.der 
```

# Building

To build the plugin archive, ensure you have [Artifactory credentials](https://github.com/confluentinc/connect-plugins-common#artifactory-credentials-for-building-plugins) set up on the build machine and use the following mvn command: 

```
$ mvn clean package
...
output truncated
...
[INFO] Building zip: /Users/arjun/Sandbox/clones/kafka-connect-mqtt-wicknicks/target/components/packages/confluentinc-kafka-connect-mqtt-1.0.0-SNAPSHOT.zip
[INFO]
[INFO] --- maven-jar-plugin:3.0.2:test-jar (default) @ kafka-connect-mqtt ---
[INFO] Building jar: /Users/arjun/Sandbox/clones/kafka-connect-mqtt-wicknicks/target/kafka-connect-mqtt-1.0.0-SNAPSHOT-tests.jar
```

The location of the plugin archive is shown above in the `target/components/packages` directory.

## Integration Tests

To run integration tests from the terminal, start a Docker daemon locally, and run the following command: 

```
$ mvn clean integration-test

...
output truncated
...
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running io.confluent.connect.mqtt.integration.MqttSourceIntegrationTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 12.817 s - in io.confluent.connect.mqtt.integration.MqttSourceIntegrationTest
[INFO] Running io.confluent.connect.mqtt.integration.MqttSinkIntegrationTest
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 9.083 s - in io.confluent.connect.mqtt.integration.MqttSinkIntegrationTest
...
```

To **skip** running integration tests when running maven commands, enable the `skipIntegrationTests` flag. For example: 

```
mvn clean install -DskipIntegrationTests
```

# Documentation

## Location
Documentation on the connector is hosted on Confluent's
[docs site](https://docs.confluent.io/current/connect/kafka-connect-mqtt/).

Source code is located in Confluent's
[docs repo](https://github.com/confluentinc/docs/tree/master/connect/kafka-connect-mqtt). If changes
are made to configuration options for the connector, be sure to generate the RST docs (as described
below) and open a PR against the docs repo to publish those changes!

## Configs
Documentation on the configurations for each connector can be autotomatically generated via Maven.

To generate documentation for the sink connector:
```bash
mvn -Pdocs exec:java@sink-config-docs
```

To generate documentation for the source connector:
```bash
mvn -Pdocs exec:java@source-config-docs
```

# Compatibility Matrix:

This mqtt connector has been tested against the following versions of AK and Eclipse Mosquitto
Broker:

|                               | AK 1.0             | AK 1.1        | AK 2.0        |
| ----------------------------- | ------------------ | ------------- | ------------- |
| **Eclipse Mosquitto v1.4.12** | NOT COMPATIBLE (1) | OK            | OK            |

1. The connector needs header support in Connect.
