Spring аннотации: 
	@SpringBootApplication - указывается для класса запускающего spring boot приложение. Обычно оно находится на самом верхнем уровне, и по умолчанию spring сканирует все классы на этом же уровне и все дочерние пакеты. Поэтому можно не указывать @ComponentScan. Аннотация в числе прочих наследуется от аннотаций @Configuration,@ComponentScan, @EnableAutoConfiguration.
	@ComponentScan("package.name") - указывается для класса с @Configuration или @SpringBootApplication какие пакеты нужно сканировать
	@PostConstruct - вызов для бина после вызова конструктора
	
	
	@Controller - указывает что класс Java является контроллером, т.е. является спринг-бином и значит что будет принимать вызовы веб-методов GET, POST и т.д. Так же если не указывать аннотацию @RequestBody, то автоматом подключается Thymeleaf и ищет страницу для ответа на запрос, если указать @RequestBody то, в ответ будет отправлен объект.
	@RestController - тоже самое что @Controller, но на каждом метода автоматически будет учтена аннотация @ResponseBody, и ее не надо каждый раз писать.
	@RequestParam - указываем что это параметр запроса, в нем можно указать назавние параметра отлично от самой переменной java, начальное значение, обязательность.
	@PathVariable - указываем что в пути-ссылке на данный REST-метод будет переменная и она будет считана в данную переменную.
	@RequestBody - указываем для Post, Put, Delete, это объект который придет на вход.
	@ResponseBody - ставится над методом REST, говорит спрингу, что ответ будет объектом и отменяет применение Thymeleaf
	
Spring Boot зависимости (Starters):	
	● spring-boot-starter-parent — это специальный стартер, предоставляющий настройки Maven по умолчанию и раздел управления зависимостями, чтобы вы могли опустить теги версии для Spring-зависимостей.
	● spring-boot-starter-web — используется для создания веб-служб RESTful с использованием Spring MVC и Tomcat в качестве встроенного контейнера приложений;
	● spring-boot-starter-thymeleaf — подключение шаблонизатора Thymeleaf
	● spring-boot-starter-data-jpa — подключает модуль Spring Data JPA
	● spring-boot-starter-security — подключает модуль Spring Security для обеспечения безопасности веб-приложения
	● spring-boot-starter-jersey — альтернатива Spring-boot-starter-web, в которой используется встроенный сервер приложений Jersey, а не Tomcat;
	● spring-boot-starter-jdbc — реализует пул соединений JDBC, основан на реализации пула JDBC Tomcat.

Настройки Java:
	<properties>
		<java.version>11</java.version>
	</properties>
	
Spring Boot Maven plugin:
	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>


Настройки (application.properties):
	server.port=8189
	spring.datasource.url=jdbc:h2:~/spring.h2
	spring.datasource.driver-class-name=org.h2.Driver

Настройки application.yaml (тоже самое что и application.properties, только возможна иерархия, что бы не повторять свойства):
	server:
		port: 8189
		servlet:
		  context-path: /app - для главное сервлета spring - DispatcherServlet задаем ключевую ссылку - /app, т.е. адресс для локального ПК будет http://localhost:8189/app
		  
Spring Boot отладка:
	java -jar my-app.jar --debug - трассировка бинов при запуске Spring Boot
		  
Lombok:
	@Data - generate setters and getters when compile, if you use it in IDEA, you should use Lombok plugin, to use generated setters and getters
	@AllArgsConstructor
	@NoArgsConstructor
	@RequiredArgsConstructor - makes constructor and fill non-initialized fields with final and fill fields with @NonNull, make check for NullPointerException