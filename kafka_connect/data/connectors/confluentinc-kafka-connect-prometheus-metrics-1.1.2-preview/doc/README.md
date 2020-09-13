# Introduction

This project provides a base for connectors to write Confluent metrics data to various services 
from Kafka Connect.

Includes:
* Appdynamics Metrics Sink Connector
* AWS CloudWatch Metrics Sink Connector
* Datadog Metrics Sink Connector
* Prometheus Metrics Sink Connector


# Kafka Connect Suite of Confluent Metrics Connectors

*kafka-connect-confluent-metrics* is a suite of [Kafka Connectors](http://kafka.apache
.org/documentation.html#connect)
designed to copy Confluent metrics messages from Kafka Connect and write them to various services.
This suite contains four modules:

* `kafka-connect-appdynamics-metrics` - A specialization of the sink connector that works with 
Appdynamics Metrics.
* `kafka-connect-aws-cloudwatch-metrics` - A specialization of the sink connector that works with 
AWS CloudWatch Metrics.
* `kafka-connect-datadog-metrics` - A specialization of the sink connector that works with 
Datadog Metrics.
* `kafka-connect-prometheus-metrics` - A specialization of the sink connector that works with 
Prometheus Metrics.

In the future we may choose to add other modules.

# Development

To build a development version you'll need a recent version of Kafka
as well as a set of upstream Confluent projects, which you'll have to build from their appropriate snapshot branch.

You can build *kafka-connect-confluent-metrics* with Maven using the standard lifecycle phases.


# Contribute

- Source Code: https://github.com/confluentinc/kafka-connect-confluent-metrics
- Issue Tracker: https://confluentinc.atlassian.net/projects/CC/issues