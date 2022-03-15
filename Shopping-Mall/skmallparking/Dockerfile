FROM openjdk:11
#VOLUME /tmp
EXPOSE 8082
ADD ./target/parking-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
