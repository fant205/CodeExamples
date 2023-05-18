package ru.gb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

//		System.setProperty("SPRING_PROFILES_ACTIVE", "dev");
		SpringApplication.run(Application.class, args);
	}


	// image [postgres] [redis] [java] [python]
	// [java] -> [OS + JRE + jar]
	// start image -> [OS container]
	// start image -p 9090:5432 5555:5432 [postgres]

	// {network [java] [postgres]} = resource
	// jdbc:postgresql://postgres:5432/resource

	// js html css docker
	// git clone
	// docker build -> docker image [java]
	// docker pull postgres
	// docker start postgres, docker start java
	// mvn package
	// java -jar app.jar
	// postgres

	// maven central repository -> /User/chestnovin/.m2
	// docker hub -> docker pull -> local docker registry


	// [linux] -> [openjdk [linux]] -> [java [openjdk [linux]]]


	// docker run spring-boot-docker 8080
	// (ryuk) -x> postgres

}
