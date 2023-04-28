FROM maven:3.8.7-eclipse-temurin-17
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=dev","/app.jar"]

#docker run -d --name cc -p 8080:8080 -v $(pwd):/config cc - в папку конфиг положить application-dev.yml
#и java при запуске его увидит в папке и использует


### FROM astra_linux_ce_2.12
# FROM ubuntu:20.04
# RUN apt-get update
# RUN apt-get --assume-yes install wget
# RUN apt-get --assume-yes install gnupg
# RUN wget -q -O - https://download.bell-sw.com/pki/GPG-KEY-bellsoft | apt-key add -
# RUN echo "deb [arch=amd64] https://apt.bell-sw.com/ stable main" | tee /etc/apt/sources.list.d/bellsoft.list
# RUN apt-get update
# RUN apt-get --assume-yes install bellsoft-java17
# COPY --from=build target/*.jar app.jar
# ENTRYPOINT ["java","-jar","/app.jar"]