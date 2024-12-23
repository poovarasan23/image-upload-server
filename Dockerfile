FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y git maven curl netcat

WORKDIR /app

RUN git clone https://github.com/poovarasan23/image-upload-server.git

WORKDIR /app/image-upload-server

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java","-jar","target/image-upload-1.0.jar"]