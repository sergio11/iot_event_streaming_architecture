#!/bin/sh

# Create IoT Frames Topic

curl -X POST -H "Content-Type: application/vnd.api+json" -H "Accept: application/vnd.api+json" \
          --data-binary "@/data/scripts/config/iot_frames_topic.json"  \
          "http://kafka-rest-proxy:8082/v3/clusters/F5NNZsLKQGWBGCj1oVu7hg/topics"