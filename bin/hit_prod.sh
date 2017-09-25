#!/bin/bash
while true
do
  curl -i http://kaboom.cfapps.io/kaboom?size=10000
  echo
  sleep 15
done
