# Spring App KABOOM!

This is a toy application designed to test custom metrics emitted by spring boot
actuator on Cloud Foundry. It has an endpoint `/kaboom` that takes a size query parameter, which
will create `size` number of large objects and store them in memory. Make that number big enough and
you should overflow your heap.

## Pushing to CF

1. Target the correct cf org and space
1. `./gradlew push`
