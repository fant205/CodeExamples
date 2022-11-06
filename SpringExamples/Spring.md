Spring аннотации: 
	@PostConstruct - вызов для бина после вызова конструктора
	@SpringBootApplication - указывается для класса запускающего spring boot приложение. Обычно оно находится на самом верхнем уровне, и по умолчанию spring сканирует все классы на этом же уровне и все дочерние пакеты. Поэтому можно не указывать @ComponentScan.
	@ComponentScan("package.name") - указывается для класса с @Configuration или @SpringBootApplication какие пакеты нужно сканировать
	@RequiredArgsConstructor - makes constructor and fill non-initialized fields with final and fill fields with @NonNull, make check for NullPointerException


Найтройки application.yaml:
	server:
		port: 8189
		servlet:
		  context-path: /app - для главное сервлета spring - DispatcherServlet задаем ключевую ссылку - /app, т.е. адресс для локального ПК будет http://localhost:8189/app
		  
		  
		  
Lombok:
	@Data - generate setters and getters when compile, if you use it in IDEA, you should use Lombok plugin, to use generated setters and getters
	@AllArgsConstructor
	@NoArgsConstructor