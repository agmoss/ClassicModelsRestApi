# Restful CRUD API

A restful web service for the Classic Models sample database. A copy of the database can be found [here](http://www.mysqltutorial.org/mysql-sample-database.aspx).

### Endpoints

| Endpoint | Request Type | Description  |
| ------------- |:-------------:| :-----|
| {host}/api/orders| GET | Retuns all ordrers with order details |
| {host}/api/orders/{id} | GET | Returns one order with details by order number |
| {host}/api/orders/{ordernumber}/orderdetails| GET | Returns order details for one order |
| {host}/api/orders|POST |Creates a new order |
| {host}/api/orders/{id} | PUT | Updates an order |
| {host}/api/orders/{id} | DELETE | Deletes an order and its details by order number |


### Installing

Package the project into a single jar file. 

```
mvn package
```

Execute the jar file from the command line. 

```
java -jar ClassicModelsRestApi-0.0.1-SNAPSHOT.jar
```

You should now see the spring initialization take place.

The API can be accessed at

```
localhost:8080/api/...
```

## Deployment

This project is set up to be deployed as a docker container on Microsoft Azure. A docker file has been configured for a .jar based build. 

Build the Docker image 

```
docker build --tag=yourregistry.azurecr.io/classicmodelsapi:latest .
```
Run a container locally for testing

```
docker run -p 5000:8080 yourregistry.azurecr.io/classicmodelsapi:latest
```

Push the image to your Azure Container Registry

```
docker push yourregistry.azurecr.io/classicmodelsapi:latest
```

The azure portal can now be used to deploy the container into a web app!


## Built With

* [Spring Boot](https://spring.io/projects/spring-boot) - Micro Service framework 
* [Hibernate](http://hibernate.org/) - Object relational mapping
* [MySQL](https://www.mysql.com/) - Database
* [Maven](https://maven.apache.org/) - Dependency Management
* [Azure](https://azure.microsoft.com/en-ca/) - Cloud Services
* [Docker](https://www.docker.com/) - Container platform

## Author

* **Andrew Moss** - *Creator* - [agmoss](https://github.com/agmoss)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
