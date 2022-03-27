FROM maven:3.8.4-jdk-11
EXPOSE 8081
COPY . .
#RUN mvn clean install && ls -R
ADD target/contact_service-0.0.1-SNAPSHOT.jar contactapp.jar
ENTRYPOINT ["java", "-jar", "contactapp.jar"]