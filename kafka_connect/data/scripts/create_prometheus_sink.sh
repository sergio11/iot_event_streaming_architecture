#!/bin/sh

# ---- Sink to Prometheus
# Execute CURL command to create Prometheus Sink
#

## Create Prometheus Sink
curl -X POST http://kafka-connect:8083/connectors -H "Content-Type: application/json; charset=UTF-8"  --data-binary "@/data/scripts/config/connect-prometheus-sink.json"

  

