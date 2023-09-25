We can start multiple instances in the same machine with different port:
(It should not be in the same machine, just for example.)

> java -jar jp-config-client-0.0.1-SNAPSHOT.jar --server.port=8081


In order to dockerize the app we need to take in account the url inside docker to external host, so we need to
change from localhost network to the docker network. 
- Note: We need to make sure we have started config-server and eureka discovery server.


Method 1 (I prefer this one):
Using gradle plugin, we change the jdk image
> gradle bootBuildImage
> docker run -p 8082:8082 {id-container-image-generated}

Method 2:
Using the Docker file
We need to generate the .jar, it should be make building with bootJar task from gradle.
And finally, we build the image from
> docker build -t jp-config-client . 
> docker run -p 8082:8082 jp-config-client 