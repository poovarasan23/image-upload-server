FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y git maven curl netcat

WORKDIR /app

RUN git clone

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java","-jar","image-upload-1.0.jar"]