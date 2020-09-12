#!/bin/sh


curl -X POST -H "Content-Type: application/vnd.api+json" -H "Accept: application/vnd.api+json" \
          --data-binary "@/data/scripts/config/iot_frames_topic.json"  \
          "http://kafka-rest-proxy:8082/v3/clusters/F5NNZsLKQGWBGCj1oVu7hg/topics"

# ---- Sink to MongoDB
# Execute CURL command to create MongoDB Sink
#

## Create IoT Frames Sink
curl -X POST http://kafka-connect:8083/connectors -H "Content-Type: application/json; charset=UTF-8"  --data-binary "@/data/scripts/config/connect-mongodb-iot-frames-sink.json"
## Create IoT Aggregate Metrics Sensor Sink
curl -X POST http://kafka-connect:8083/connectors -H "Content-Type: application/json; charset=UTF-8"  --data-binary "@/data/scripts/config/connect-mongodb-iot-aggregate-metrics-sensor-sink.json"
## Create IoT Aggregate Metrics Place Sink
curl -X POST http://kafka-connect:8083/connectors -H "Content-Type: application/json; charset=UTF-8"  --data-binary "@/data/scripts/config/connect-mongodb-iot-aggregate-metrics-place-sink.json" 
  

