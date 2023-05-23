# SAMPLE JDBC-CMDline APP to Demonstrate DAO, MVC, CRUD and JDBC Capabilities

| Note : This project makes use of Docker to get mysql instance configured. If you are opting out for other options, make sure to checkout database creation script in `scripts` folder and to configure database credentials in `src/main/resources/connection.properties` accordingly.

For Suggestions and Disscussions feel free to open issues and PR according to your liking.

To bring up the mysql instance:

```bash
docker compose up -d
```

To terminate the mysql instance:

```bash
docker compose down -v
```

| Note : Database will persist in your working directory inside `dbdata` folder.
