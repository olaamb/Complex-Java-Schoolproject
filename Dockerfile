FROM openjdk:11
COPY ./target/jms-demo-0.0.1-SNAPSHOT.jar /usr/src/jms-211206/ <---RENAME
WORKDIR /usr/src/spring-boot-project-20211201 <---RENAME?
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "jms-demo-0.0.1-SNAPSHOT.jar"] <---RENAME
