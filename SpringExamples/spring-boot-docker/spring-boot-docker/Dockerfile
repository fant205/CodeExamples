FROM maven:3.8.7-eclipse-temurin-17 as build
COPY . .
RUN mvn clean package

### FROM astra_linux_ce_2.12
FROM ubuntu:20.04
RUN apt-get update
RUN apt-get --assume-yes install wget
RUN apt-get --assume-yes install gnupg
RUN wget -q -O - https://download.bell-sw.com/pki/GPG-KEY-bellsoft | apt-key add -
RUN echo "deb [arch=amd64] https://apt.bell-sw.com/ stable main" | tee /etc/apt/sources.list.d/bellsoft.list
RUN apt-get update
RUN apt-get --assume-yes install bellsoft-java17
COPY --from=build target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

### Links:
### http://localhost:8080/api/resource/1
### http://localhost:8080/api/resource?value=1212