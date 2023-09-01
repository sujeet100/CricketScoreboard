## Cricket ScoreBoard

## Pre-Requisites
- Git
- OpenJDK 20
- PostgreSQL 15.0

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

