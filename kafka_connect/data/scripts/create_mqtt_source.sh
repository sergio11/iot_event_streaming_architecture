#!/bin/sh

# ---- MQTT Source
# Execute CURL command to create MQTT Source
#
curl -X POST http://kafka-connect:8083/connectors -H "Content-Type: application/json; charset=UTF-8"  --data-binary "@/data/scripts/config/connect-mqtt-source.json"  
  

