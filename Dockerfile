FROM openjdk:11
COPY target/*.jar banco-v1.jar
ENTRYPOINT ["java","-jar","/banco-v1.jar"]