## Cricket ScoreBoard
[![Cricket ScoreBoard Build](https://github.com/sujitkamthe/cricket-scorecard/actions/workflows/gradle.yml/badge.svg?branch=main)](https://github.com/sujitkamthe/cricket-scorecard/actions/workflows/gradle.yml)

## Pre-Requisites
- Git
- OpenJDK 20
- PostgreSQL 15.0
- Colima

## Install OpenJDK 20
https://adoptium.net/en-GB/temurin/releases/?version=20&package=jdk&arch=aarch64&os=mac

## Install Colima
Colima is a container runtime and is needed for running integration tests using testcontainers
```
    brew install colima
    brew install docker
```

### Create Database
Create a database with name `cricketboard`
```
    CREATE DATABASE cricketboard;
```

## Run Application in Intellij
Run the application from `CricketBoardApplication.java`

Edit run configuration and add following environment variables
```
    DB_USERNAME=<username>
    DB_PASSWORD=<password>
```

## Run Application from shell

```
    DB_USERNAME=<username> DB_PASSWORD=<password> ./gradlew bootRun 
```

## To add flyway DB migrations
Add file in db.migration folder with name `V1__<name>.sql`

## Run tests using gradle
```
    ./gradlew test
```
