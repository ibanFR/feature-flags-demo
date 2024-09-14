# FEATURE FLAGS DEMO PROJECT
//write an intro for the project 
//what is the project about
//what is the project for
//what is the project's purpose
//what is the project's goal


This is a demo project to showcase integration with feature flag on a Java project.

Several tools will be researched and integrated into this project to showcase how to use feature flags in a Java project.

A simple JSF application will be created to showcase how to use feature flags in a web application.

## Tools

- [Docker](https://www.docker.com/) 

## Flipt
- [Flipt](https://docs.flipt.io/introduction)

## Getting Started
Run docker
```shell
docker run -d \
    -p 8080:8080 \
    -p 9000:9000 \
    -v $HOME/flipt:/var/opt/flipt \
    docker.flipt.io/flipt/flipt:latest

```

## Create a flag
See [Create a Flag](https://docs.flipt.io/introduction#create-a-flag)

## Server-Side Evaluation
Flipt comes equipped with a fully functional REST API. The Flipt UI is completely backed by this same API. 
This means that anything that can be done in the Flipt UI can also be done via the REST API.

```shell
mvn exec:java -Dexec.mainClass="ie.etu.Main"
```

## Concepts
- See [Concepts](https://docs.flipt.io/concepts)



