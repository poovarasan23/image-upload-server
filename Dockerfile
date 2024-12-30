FROM openjdk:17-jdk-slim

RUN apt-get update && apt-get install -y git maven curl netcat ca-certificates

RUN update-ca-certificates

WORKDIR /app

RUN git config --global http.sslverify false && git clone https://github.com/poovarasan23/image-upload-server.git

WORKDIR /app/image-upload-server

RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java","-jar","target/image-upload-1.0.jar"]