We can check swagger configuration:
>http://localhost:8082/swagger-ui/index.html

Add new endpoint to use with cache:
>http://localhost:8082/translations?msg=%22Hola
 

We can start multiple instances in the same machine with different port:
(It should not be in the same machine, just for example.)

> java -jar jp-config-client-0.0.1-SNAPSHOT.jar --server.port=8081