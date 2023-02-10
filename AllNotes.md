Linux:	
	
	OS:
		Версия ОС
			lsb_release -dc

		Отключение по умолчанию сервера из списка автостарта
			sudo systemctl disable apache2 - 

		file operations:
			mv <source> <targer>
			mv dist1/* dist2 - все файлы из папки 1 переедут в папку 2		
			cp -r /home/alexey/Downloads/dump/dump . - скопировать папку 1 в текущую папку
			cp -r /home/alexey/Downloads/dump/dump/* . - скопировать все файлы из папки 1 в текущую папку
			readlink -f _countries.sql или realpath _countries.sql - путь до файла

		Список процессов:
			ps -eF - список процессов
			ps -efH - список деревом
			ps -efL - список с потоками

			
		Закрыть программу:
			pgrep <имя программы> - вернет PID
			kill <PID> - закрыть программу
			
		curl -X POST localhost:8080/actuator/shutdown - POST вызов
		curl localhost:8080/actuator/health - GET вызов


	Jenkins:
		sudo systemctl start jenkins
		sudo systemctl status jenkins
	
	Nexus:
		sudo systemctl stop nexus



		
	NGINX:
		sudo killall apache2
		sudo fuser -k 443/tcp
		sudo service nginx start
		

	Zip:
		unzip file.zip -d destination_folder
		unzip file.zip
		
		zip 1.zip * - зипуем все файлы в текущей папке в архив с именем 1.zip
		zip -r archivename.zip directory_name - зипуем все внутри папки
	
	Java:
		Запуск jar:
			java -cp allClasses.jar Class1
			
		Список установленных Java:
			sudo update-alternatives --config java
	
		Установка oracle Java:
			sudo apt install oracle-java11-installer-local
		Spring:
			Версии Spring - совместимость библиотек
				grep -A 1 hibernate- ~/.m2/repository/org/springframework/spring-orm/4.3.12.RELEASE/spring-orm-4.3.12.RELEASE.pom
			spring_profiles_active=dev - profile dev (application-dev.yaml)
	
	

Git:
	.gitignore
		Что бы игнорировать файл или папку, необходимо добавить его в файл .gitignore, лучше всего его разместить в корне репозитория.
		Папка **\<имя папки> будет игнорироваться, где бы она не была.
		Для игнорирования, файл или папка должы быть исключены из индекса. Если файл раньше коммитился, то надо его убрать из индекса 
			Пример:
				$ echo debug.log >> .gitignore  
				$ git rm --cached debug.log
				$ git commit -m "Start ignoring debug.log"
		Официальный мануал https://www.atlassian.com/git/tutorials/saving-changes/gitignore
		
	
	Команды:
		git push -u origin master - отправить закомиченные изменения на GitHub
		git pull origin master - скачать актуальную версию с GitHub
		git branch - список веток
		git branch newBranch - создать ветку newBranch		
		git checkout -b newBranch - создать ветку и переключиться на нее
		git status
		git add . - добавить все измененные файлы в индекс
		git commit -m "some message"
		git log - расширенный список логов
		git log --oneline - краткий список логов репозитория
		git diff - просмотр изменений в файлах
		git remote add origin <URL SSH> - настройка удаленного соединения
		git remote -v - проверка удаленного соединения, нужно что бы было два - fetch & push		
		git checkout . - o revert changes made to your working copy, do this:
		git restore . - Or equivalently, for git version >= 2.23:
		git reset - To revert changes made to the index (i.e., that you have added), do this. Warning this will reset all of your unpushed commits to master!:
		git revert <commit 1> <commit 2> - To revert a change that you have committed:
		git clean -f - To remove untracked files (e.g., new files, generated files):
		git clean -fd - Or untracked directories (e.g., new or automatically generated directories):


		
		
	


MongoDB:
	mongo - управляющая программа
	mongo -u <user> -p <pass> --authenticationDatabase admin
	mongoimport --db restaurants --collection MyCollection --file primer-dataset.json - 		импорт файла в бд (запросы надо делать через db.<collection>.<оператор>)
	show dbs - все бд
	use restaurants - переключение на бд
	show collections - показать коллекции в текущей бд
	db.<имя коллекии>.find() - вызов оператора find


SSL Certificates:
	keytool -list -v -keystore /path/to/cacerts  > java_cacerts.txt - получиться данные сертификатор и можно в результирующем файле поискать сертификат по Serial Number. Сертификаты обычно лежат:
		./jdk1.6.0_24/jre/lib/security/cacerts
		./jre1.6.0_24/lib/security/cacerts

	Enter keystore password:  changeit - по умолчанию пароль такой
	В браузере 

	keytool -import -alias example -keystore  /path/to/cacerts -file example.der - команда импорта сертификата в Java хранилище
	
	keytool - Утилита находится ...\jdk_folder\bin
	
	keytool -delete -alias sms01199.npr.nornick.ru -keystore  C:\Work\Soft\jdk1.8.0_171\jre\lib\security\cacerts - удалить сертификат из keystore
	
IDEA:
	debug from idea to SAP Portal:
		- go to Run -> Debug
		- Select Edit Configurations
		- Expand Template section
		- Select "Remote"
		- Make settings:
			Debugger mode: Attache to remote JVM
			Transport: Socket
			Host: <your host>
			Port: 50021
			Use module classpath: <select your java module>
		- Push button in right up "Create configuration"
		- You will see in debug dropdown list or in Debug settings section "Remote" and there your configuration
		- Now you can push "Debug"
		- Check that you turned on debug on SAP Portal



Chrome:
	сброк кэша: Shift + F5




Java:
		//fill collection
        {
            List<Integer> list = new ArrayList<Integer>();
            Collections.addAll(list, 0, -5, -7, -12, 5, 15);
        }

        //remove element from collection.
        {
            List<Integer> list = new ArrayList<Integer>();
            Collections.addAll(list, 0, -5, -7, -12, 5, 15);
            list.removeIf(x -> x < 0);
        }

        //print collection
        {
            List<Integer> list = new ArrayList<Integer>();
            Collections.addAll(list, 0, -5, -7, -12, 5, 15);
            list.forEach(System.out::println);
        }

        //switch
        {
            LocalDate date = LocalDate.now();
            DayOfWeek day = date.getDayOfWeek();
            switch (day) {
                case MONDAY:
                    System.out.println("Понедельник");
                case TUESDAY:
                    System.out.println("Вторник");
                case WEDNESDAY:
                    System.out.println("Среда");
                case THURSDAY:
                    System.out.println("Четверг");
                case FRIDAY:
                    System.out.println("Пятница");
                case SATURDAY:
                    System.out.println("Суббота");
                case SUNDAY:
                    System.out.println("Воскресенье");
            }
        }

        {
            //string format
            System.out.println(String.format("%-10s Hi", "Alex"));//10 это кол-во пустых мест в строке
//          Вывод:Alex       Hi
            System.out.println(String.format("%-10.5s Hi", "ABCDEFGHIK"));
//          Вывод:ABCDE      Hi
            System.out.println(String.format("%3d", 1));
//          Вывод:1
            System.out.println(String.format("%05d", 1));//заполнить нулями перецифрой
//          Вывод:00001
        }

Date:
    Date date = new Date();
    System.out.println(date.toString());
		
Logging:
	log.debugT(method, "Xml for Import manager: {0}", new Object[] { importXmlName });
	
Rest Controller:

	@RestController
	public class SupportController {

		public static final Location log = Location.getLocation(SupportController.class);
		private static final Location loc = Location.getLocation(Location.getLocation("MtrSyncLog.log"));

		@GetMapping("/changeLang")
		public ResponseEntity<?> changeLang(@RequestParam(defaultValue = "grigorevatv") String login, @RequestParam(defaultValue = "ru") String lang) {

			try{

				return new ResponseEntity<>("Hello!", HttpStatus.OK);

			} catch (Exception e) {
				ExceptionHelper.printStackTrace(e, log);
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	}

Format date
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	result = format.format(((DateTimeValue) value).getDate());
  
  

nio
    //rename file
    Path of = Path.of("storage/2.txt");
    Files.move(of, of.getParent().resolve("2.txt"));
=======
	
//Lambda
	//Объявляем интерфейс с 1 методом, аннотация @FunctionalInterface делает проверку что в интерейсе только 1 метод (можно создавать другие методы, но тогда они должны быть default)
	@FunctionalInterface
	public interface Operation {				
		int apply(int x, int y);				
	}
	
	public static void main(String[] args){
		//lambda
		Operation o1 = (x, y) -> x + y;
		
		//Method reference
			//1.
			Operation o2 = Integer::sum;
			//2.
			Operation o3 = Main::go;
		
		//Делаем вызов
		o1.apply(1,2);
		o2.apply(1,2);
		o3.apply(1,2);
		
		//Передача в функцию:
		calc(1, 2, o1);
		calc(1, 2, o2);
		calc(1, 2, o3);
		
		
	}
	
	//делаем метод который имеет такие же входные параметры и выходные и можно его использовать как method reference
	public static int go(int t, int z){
		return t / z;
	}
	
	//В жизни используется для передачи в функции
	public static int calc(int x, int y, Operation o){
		return o.apply(x, y);
	}	

//Stream API

	//Базовые интерфейсы
		//forEach, peek
		Consumer<String> printer = System.out::println;
		printer.accept("Hello");
		
		//filter, anyMatch, allMatch, noneMatch	
		Predicate<Integer> isOdd = x -> x % 2 != 0;
		
		//map, FlatMap
		Function<String, Integer> length = String::length;
		System.out.pringln("length.apply("123"));
		
		//collect
		Supplier<Integer> supplier = () -> 1;
		Supplier<Map<String, Map<Integer, Set<Long>>>> supplier = HashMap::new;
	
	
	
	//Пример использования
	
		//вытащить только поле из листа объектов и собрать в лист
		//1
			List<String> names = 
			personList.stream()
              .map(Person::getName)
              .collect(Collectors.toList());
		//2
			u.getRequestProcessor().stream().map(RequestProcessor::getUser_id).map(UerUser::getFio).collect(Collectors.toList()).toString(),
	
	
	
		//filter odd and print
		Stream.of(1,2,3,4,5,6,7,8,9)
		.filter(x -> x % 2 == 0)
		.forEach(System.out::println);
		
		//increment all values by 1 and collect to list
		List<Integer> list = Stream.of(1,2,3,4,5)
			.map(x -> x + 2)
			.toList();
			
		System.out.println(list.toString());
		
		//calculate sum
		Integer result = Stream.of(1,2,3)
			.reduce(0, Integer::sum);
		System.out.pringln(result);
		
		//words counter
		Map<String, Integer> words = Files.lines(Path.of("folder", "1.txt")) //вытащили текстовый файл по строчкам в Stream
			.flatMap(s -> Stream.of(s.split(" +"))) //разбили каждую строчку в Stream и с помощью flatMap собрали все в один Stream
			.map(String::toLowerCase) //каждый элемент привели в нижний регистр
			.map(s -> s.replaceAll("\\W\\d", "")) //каждый элемент - убрали не букву и не цифру
			.filter(StringUtils::isNoneBlank) //убрали пустые элементы
			//.forEach(System.out.println); //вывод каждого элемента
			.collect(Collectors.toMap( //собираем результат в map, что бы показать сколько раз какое слово попадается в тексте
				Function.identity(), // возвращаем саму себя, т.е. слово будет ключом map
				value -> 1, // говорим что со значением, говорим что когда клю попался первый раз, то кладем 1
				Integer::sum // говорим что делать со значением, если уже был такой ключ - говорим складывать старое и новое значение 
			));
			
		//counter rate
		words.entrySet().stream()
			.sorted((e1, e2) -> e2.getValue - e1.getValue) //передаем comparator, что бы показать как сортировать entrySet
			.forEach(entry -> System.out.println(entry.getKey() + " : " + entry.getValue()));
			
		//классическая задача flat 
		int[][] array = new int[][]{ {1,2}, {1,2,3}, {1,2,3,4}};
		Arrays.stream(array)
			.flatMap(Stream::of)
			.toList();
			
		System.out.println();




Spring: 
	Spring аннотации: 
		@SpringBootApplication - указывается для класса запускающего spring boot приложение. Обычно оно находится на самом верхнем уровне, и по умолчанию spring сканирует все классы на этом же уровне и все дочерние пакеты. Поэтому можно не указывать @ComponentScan. Аннотация в числе прочих наследуется от аннотаций @Configuration,@ComponentScan, @EnableAutoConfiguration.
		@ComponentScan("package.name") - указывается для класса с @Configuration или @SpringBootApplication какие пакеты нужно сканировать
		@PostConstruct - вызов для бина после вызова конструктора
		@RequiredArgsConstructor - makes constructor and fill non-initialized fields with final and fill fields with @NonNull, make check for NullPointerException
		
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

	Spring Boot Security:

		Есть два способа настройки security:
				1. Через WebSecurityConfigurerAdapter - объявлен устаревшим
				2. Через SecurityConfig, в котором надо создать бин SecurityFilterChain и сделать сразу его настройку.
						Пример с SecurityFilterChain (по новому):
						@Configuration
						public class SecurityConfig {
						    @Bean
						    public SecurityFilterChain mySecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
						        return httpSecurity.authorizeRequests()
						                .antMatchers("/app/admin-page").hasRole("ADMIN")
						                .antMatchers("/app/user-page").hasAnyRole("USER", "ADMIN")
						                .antMatchers("/app/home").authenticated()
						                .antMatchers("/app/guest").permitAll()
						                .and()
						                .formLogin()
						                .and()
						                .build();
						    }
						}
					В данном способе можно инициализиваровать правила для нужны ссылок через аннотации:
						- ставим над методом в RestController аннотацию @Secured("ROLE_ADMIN")
						- в файле конфигурации безопасности SecurityConfig аннотацию @EnableGlobalMethodSecurity(securedEnabled = true)

				Пример по старому (через WebSecurityConfigurerAdapter)
					Опередяем конфиг:
						@Configuration
						@EnableWebSecurity
						@EnableGlobalMethodSecurity(securedEnabled = true)
						public class SecurityConfig extends WebSecurityConfigurerAdapter {
							// ...
						}

					Аннотации:
						@EnableWebSecurity - отключает стандартные настройки безопасности Spring Security и начинает использовать правила, прописанные в SecurityConfig. 
						@EnableGlobalMethodSecurity - активирует возможность ставить защиту на уровне методов (для этого над методами ставятся аннотации @Secured и @PreAuthorized).

					Пример конфига когда мы сами определяем как будем искать юзера и полномочия, исползуется: DaoAuthenticationProvider и UserService, который будет искать юзера, его пароль, его роли и будет хешировать пароль с помощью BCryptPasswordEncoder:
						@Configuration
						@EnableWebSecurity
						@EnableGlobalMethodSecurity(securedEnabled = true)
						public class SecurityConfig extends WebSecurityConfigurerAdapter {
							private UserService userService;

							@Autowired
							public void setUserService(UserService userService) {
								this.userService = userService;
							}

							@Bean
							public BCryptPasswordEncoder passwordEncoder() {
								return new BCryptPasswordEncoder();
							}

							@Bean
							public DaoAuthenticationProvider authenticationProvider() {
								DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
								auth.setUserDetailsService(userService);
								auth.setPasswordEncoder(passwordEncoder());
								return auth;
							}

							@Override
							protected void configure(HttpSecurity http) throws Exception {
								http.authorizeRequests()				
								.antMatchers("/").hasAnyRole("USER")
								.antMatchers("/admin/**").hasRole("ADMIN")
								.and()
								.formLogin()
								.loginPage("/login")
								.loginProcessingUrl("/authenticateTheUser")
								.permitAll();
							}

							//пояснение:
							● Метод configure(HttpSecurity http) отвечает за настройку защиты на уровне запросов и конфигурирование процессов авторизации.
							● antMatchers — с помощью данного метода указывается http-метод и URL (или шаблон URL), доступ к которому необходимо ограничить.
							● hasRole(String role), hasAnyRole(String... roles) — в нем указывается одна роль или набор ролей, необходимых пользователю для доступа к данному ресурсу.
							● formLogin() — дает возможность настроить форму для авторизации.
							● loginPage — URL формы авторизации.
							● loginProcessingUrl — URL, на который будут отправляться данные формы (методом POST).
							● * logout() — позволяет настроить правила выхода из учетной записи.
							● * failureUrl — адрес для перенаправления пользователя в случае неудачной авторизации.
							● * logoutSuccessUrl — URL, на который будет перенаправлен пользователь при выходе из аккаунта автора.
							● * usernameParameter и passwordParameter — имена полей формы, содержащие логин и пароль, если не используются стандартные имена username и password;

						}

						Пример реализации UserService:
							@Service
							public class UserService implements UserDetailsService {
								private UserRepository userRepository;
								private RoleRepository roleRepository;

								@Autowired
								public void setUserRepository(UserRepository userRepository) {
									this.userRepository = userRepository;
								}

								@Autowired
								public void setRoleRepository(RoleRepository roleRepository) {
									this.roleRepository = roleRepository;
								}

								public User findByUsername(String username) {
									return userRepository.findOneByUsername(username);
								}

								@Override
								public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
									User user = userRepository.findOneByUsername(username);
									if (user == null) {
										throw new UsernameNotFoundException("Invalid username or password");
									}					
									return new org.springframework.security.core.userdetails.User(user.getPhone(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
								}

								private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
									return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
								}

							}


		Пример конфига для стандартной парs таблиц: users и authorities. Все что нужно, это заинжектить DataSource, создать таблицы в базе, и добавить туда пользователей. 
			@Configuration			
			@EnableWebSecurity
			@EnableGlobalMethodSecurity(prePostEnabled = true)
			public class SecurityConfig extends WebSecurityConfigurerAdapter {
				private DataSource dataSource;

				@Autowired
				public void setDataSource(DataSource dataSource) {
					this.dataSource = dataSource;
				}

				@Override
				protected void configure(AuthenticationManagerBuilder auth) throws Exception {
					auth.jdbcAuthentication().dataSource(dataSource);
				}

				@Override
				protected void configure(HttpSecurity http) throws Exception {
					http.authorizeRequests()
					.antMatchers("/").hasAnyRole("USER")
					.antMatchers("/admin/**").hasRole("ADMIN")
					.and()
					.formLogin()
					.loginPage("/login")
					.loginProcessingUrl("/authenticateTheUser")
					.permitAll();
				}
			}
			Конфиг для dataSource:
					spring.datasource.driver-class-name=org.postgresql.Driver
					spring.datasource.url=jdbc:postgresql://localhost:5231/postgres?currentSchema=spring
					spring.datasource.username=user
					spring.datasource.password=user

			Конфиг для inMemory:	
				@Override
				protected void configure(AuthenticationManagerBuilder auth) throws Exception {
					User.UserBuilder users = User.withDefaultPasswordEncoder();
					auth.inMemoryAuthentication()
					.withUser(users.username("user1").password("pass1").roles("USER",
					"ADMIN"))
					.withUser(users.username("user2").password("pass2").roles("USER"));
				}
			Скрипты SQL для таблиц по стандартной схеме:
				CREATE TABLE users (
					username varchar(50) NOT NULL,
					password varchar(100) NOT NULL,
					enabled tinyint(1) NOT NULL,
					PRIMARY KEY (username)
				) ENGINE=InnoDB DEFAULT CHARSET=latin1;

				INSERT INTO users
				VALUES
					('user1', 'user1', 1),
					('user2', 'user2', 1);

				CREATE TABLE authorities (
					username varchar(50) NOT NULL,
					authority varchar(50) NOT NULL,
					UNIQUE KEY authorities_idx_1 (username, authority),
					CONSTRAINT authorities_ibfk_1
					FOREIGN KEY (username)
					REFERENCES users (username)
				) ENGINE=InnoDB DEFAULT CHARSET=latin1;

				INSERT INTO authorities
				VALUES
					('user1', 'ROLE_ADMIN'),
					('user1', 'ROLE_USER'),
					('user2', 'ROLE_USER');

	Spring transactions:
		- Когда мы ставим аннотацию Transactional, то Spring делает прокси-классы для нашего класса, где делает старт транзацкии, ее коммит или роллбек при ошибке

	Spring Exception:
		Пример класса который объявляется перехватчиком всех исключений от всех контроллеров (класс срабатывает на исключения объявленные как входные параметры методов):
			@ControllerAdvice		
			@Slf4j
			public class GlobalExceptionHandler {
			    @ExceptionHandler
			    public ResponseEntity<AppError> catchResourceNotFoundException(ResourceNotFoundException e) {
			        log.error(e.getMessage(), e);
			        return new ResponseEntity<>(new AppError(HttpStatus.NOT_FOUND.value(), e.getMessage()), HttpStatus.NOT_FOUND);
			    }

			    @ExceptionHandler
			    public ResponseEntity<FieldsValidationError> catchValidationException(ValidationException e) {
			        log.error(e.getMessage(), e);
			        return new ResponseEntity<>(new FieldsValidationError(e.getErrorFieldsMessages()), HttpStatus.BAD_REQUEST);
			    }
			}

	Spring AOP (Aspects):
		- Если в дебаге видно что бин спринга является не самим классом, а прокси классом SJLib, то это значит используются аспекты, и надо смотреть какую логику добавили в них
		- Аспекты как теневые программы могут менять программу и данные, это приводит к усложнению поддержки программы

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
		@AllArgsConstructor------------       
		@NoArgsConstructor
		@RequiredArgsConstructor - делает конструктор с полями которые объявлены как final и какие то еще
		@Slf4j - дает логгер с реализацией Lombok, и можно сразу в коде обращаться к переменной log.debut("logging")



Maven:
	Команды:
		mvn clean - чистка в проекте всего что было сгенерировано
		mvn package - прогон билда, тестов, подтягивание зависимостей, если указал в pom.xml, паковка в jar файл
		mvn install - все что и package и еще копирование в локальный репозиторий сформированного jar, и можно будет в других проектах локально юзать этот jar как либу через dependencies
		mvn dependencies:tree - покажет в текущем проекте дерево зависимостей
		mvn spring-boot:build-image - сделать образ java приложения

	Репозитории:
		Local - локальный - на компе репозиторий, находится по адресу ${userhome}/.m2 (папка .m2 скрытая). Для винды это Documents/Users, для мак или убунту корневая папка юзера
		Central - Центральный (https://mvnrepository.com), если в локальном не нашли, ищем в центральном, если нашли, то копирование в локальный, если не нашли, то идем в remote
		Remote - Удаленный, это репозиторий в какой-либо компании, внутри нее, и там есть какие-то свои наработки. Можно в maven настроить как Remote какой то сервер компании, и maven будет работать с ним. Если нашли в remote, то копирование в локальный, если нет, то ошибка что такой библиотеки нет
	
	
	Полезные зависимости:
		//Дает готовые решения для частых простых задач
		<!-- https://mvnrepository.com/artifact/org.apache.commons/commons-lang3 -->
		<dependency>
			<groupId>org.apache.commons</groupId>
			<artifactId>commons-lang3</artifactId>
			<version>3.12.0</version>
		</dependency>

		//как и apache дает много решений для простых вещей (кеш, RateLimiter, если нужно сделать что бы был 5 запросов в секунду и не больше)
		<!-- https://mvnrepository.com/artifact/com.google.guava/guava -->
		<dependency>
			<groupId>com.google.guava</groupId>
			<artifactId>guava</artifactId>
			<version>31.0.1-jre</version>
		</dependency>

	settings.xml:
		${maven.home}/conf/settings.xml - maven home можно узнать командой mvn -v
		${user.home}/.m2/settings.xml




mvn package - сделать jar или war, в зависимости что указано в pom.xml
mvn tomcat:run -запуск встроенного tomcat
mvn dependency:tree - вывод дерева зависимостей
mvn dependency:analyze -DignoreNonCompile - вывод не используемых зависимостей
mvn clean package tomcat:run --пакетный запуск команд
	
mvn --version - вывод версии Maven:
	make current maven 3.8.4:
	xport M2_HOME=/usr/local/apache-maven/apache-maven-3.8.4
	export M2=$M2_HOME/bin
	export MAVEN_OPTS="-Xms256m -Xmx512m"
	export PATH=$M2:$PATH          
	source ~/.profile
	



Управелние зависимостями:
	Пример как указать конкретный jar библиотеки на своем ПК:
		Вариант 1:
		<dependency>
			<groupId>com.microsoft.sqlserver</groupId>
			<artifactId>sqljdbc</artifactId>
			<version>6.0</version>
			<scope>system</scope>
			<systemPath>${basedir}/lib/com.microsoft.sqlserver/sqljdbc/6.0/sqljdbc42.jar</systemPath>
			<optional>true</optional>
		</dependency>
		
		Вариант 2:
			Добавляем в свой локальный репозиторий Maven свой jar:
				mvn install:install-file -Dfile=/C/Work/JARs/tc~je~usermanagement~api.jar -DgroupId=sap.com -DartifactId=ume.api -Dversion=1.0 -Dpackaging=jar -DgeneratePom=true
			Добавляем в pom.xml зависимость как обычно:
				<dependency>
					<groupId>sap.com</groupId>
					<artifactId>ume.api</artifactId>
					<version>1.0</version>
				</dependency>


	Hibernate:
		# Relationships in JPA - Hibernate

## 1. OneToMany

### SQL:
    CREATE TABLE categories (
        id serial,
        title varchar(255),
    	PRIMARY KEY (id)
	);

    CREATE TABLE products (
		id serial,
		title varchar(255),
		category_id integer REFERENCES categories (id)
	);


### Java:
	@Entity
	@Table(name = "products")
	public class Product {
		@Id
		@GeneratedValue
		@Column(name = "id")
		private Long id;
		@Column(name = "title")
		private String title;
		@ManyToOne
		@JoinColumn(name = "category_id")
		private Category category;
		// ...
	}
	
	@Entity
	@Table(name = "categories")
	public class Category {
		@Id
		@Column(name = "id")
		@GeneratedValue
		Long id;
		@Column(name = "title")
		String title;
		@OneToMany(mappedBy = "category")
		List<Product> products;
		// ...
	}


## 2. OneToOne

### SQL:
	CREATE TABLE employees_details (
		id serial, 
		address varchar(255), 
		PRIMARY KEY (id)
	);
	
	CREATE TABLE employees (
		id serial, 
		first_name varchar(50), 
		last_name varchar(50), 
		details_id integer REFERENCES employees_details (id)
	);

### Java:
	@Entity
	@Table(name = "employees")
	public class Employee {
		@Id
		@GeneratedValue
		@Column(name = "id")
		private Long id;
		@Column(name = "first_name")
		private String firstname;
		@Column(name = "last_name")
		private String lastname;
		@OneToOne
		@JoinColumn(name = "details_id")
		private EmployeeDetails details;
		// ...
	}

	@Entity
	@Table(name = "employees_details")
	public class EmployeeDetails {
		@Id
		@GeneratedValue
		@Column(name = "id")
		Long id;
		@OneToOne(mappedBy = "details")
		Employee employee;
		// ...
	}

## 3. ManyToMany

### SQL:
	DROP TABLE IF EXISTS categories CASCADE;
	DROP TABLE IF EXISTS products CASCADE;
	
	CREATE TABLE categories (
		id serial, 
		title varchar(255), 
		PRIMARY KEY (id)
	);
	
	CREATE TABLE products (
		id serial, 
		title varchar(255), 
		PRIMARY KEY (id)
	);
	
	CREATE TABLE products_categories (
		product_id integer REFERENCES products (id),
		category_id integer REFERENCES categories (id)
	);

### Java:
	@Entity
	@Table(name = "products")
	public class Product {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;
		@Column(name = "title")
		private String title;
		@ManyToMany
		@JoinTable(
		name = "products_categories",
		joinColumns = @JoinColumn(name = "products_id"),
		inverseJoinColumns = @JoinColumn(name = "category_id")
		)
		private List<Category> categories;
		// ...
	}
	
	@Entity	
	@Table(name = "categories")
	public class Category {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private int id;
		@Column(name = "title")
		private String title;
		@ManyToMany
		@JoinTable(
		name = "products_categories",
		joinColumns = @JoinColumn(name = "category_id"),
		inverseJoinColumns = @JoinColumn(name = "products_id")
		)
		private List<Product> products;
		// ...
	}

## Cascade Types
    ● CascadeType.ALL — каскадирование будет применяться ко всем операциям;
    ● CascadeType.REMOVE — только к методу удаления;
    ● CascadeType.PERSIST — только к методу сохранения;
    ● CascadeType.MERGE — к методу обновления;
    ● CascadeType.REFRESH — к методу синхронизации с БД;
    ● CascadeType.DETACH — каскадирование применяется к методу удаления сущности из
    контекста постоянства (но не из БД).

## Annotations JPA
    @Entity - показывает что класс является сущностью

    Описание таблицы:
        @Table(name = "demo_annotated", indexes = {
            @Index(name = "name_idx", columnList = "name"),
            @Index(name = "id_name_idx", columnList = "id, name"),
            @Index(name = "unique_name_idx", columnList = "name", unique = true)
        })
 
    @OneToOne, @OneToMany, @ManyToOne, @ManyToMany - Виды связей
    @Column - описание колонки:
        @Column(name = "manual_def_str", columnDefinition = "VARCHAR(50) NOT NULL
        UNIQUE CHECK (NOT substring(lower(manual_def_str), 0, 5) = 'admin')")
        String manualDefinedString;
        @Column(name = "short_str", nullable = false, length = 10) // varchar(10)
        String shortString;
        @Column(name = "created_at", updatable = false)
        LocalDateTime createdAt;
    @CreationTimestamp и @UpdateTimestamp - Для автогенерации времени создания объекта 
    в базе данных и времени его обновления используются аннотации;

    @ManyToOne (описание таблицы меппинга для многие ко многим)
    @JoinColumn(
        name = "product_id",
        nullable = false,
        foreignKey = @ForeignKey(name = "FK_PRODUCT_ID")
    )
    Product product;

    @Id (Любая сущность должна иметь поле id с аннотацией @Id)
    @GeneratedValue(strategy = GenerationType.IDENTITY) (Указываем что значение будет генерироваться автоматически)
    @Column(name = "id")
    Long id;

    @Version поле используется для версионирования




SQL:
	PostgreSQL:	

		SQL глубинные смыслы:
			Процедуры используются для:
			- для реализации сложной серверной логики обработки данных, например в банковских системах.
			- для доступа к данным в виде отчетов
			- для трансформации, очистки, валидации данных на сервере
			Плохое использование:
			- для CRUD не стоит

			Триггеры обычно используются для:
			- Логирования изменений
			- Лучше ими не злоупотреблять и вынести эту логику типа автор изменения или дата изменения явно в код.

			Индексы:
			- Для задействования индекса необходимо искать по первой части строки, то есть заменить
				like '%Ny%'
				на
				like 'Ny%'


		psql:
			\c - connection
			\q - quit
			\? - help
			\dt - tables list
			\d tableName - table description
			\h - help
			\ create table - command description




		SQL:

			USE geodata;

			select * from _countries;

			--Таблица _coutries
				--удалить колонки
				ALTER TABLE _countries 
					DROP COLUMN title_en,
					


				--изменение поля title_ru
					--изменить тип колонки
						ALTER TABLE _countries ALTER COLUMN title_ru SET DATA TYPE VARCHAR(150);

					--сделать NOT NULL
						ALTER TABLE _countries ALTER COLUMN title_ru SET NOT NULL;

					--переименовать колонку
						ALTER TABLE _countries RENAME COLUMN title_ru TO title;
						
					--индекс 		
						create index idx_countries_title on _countries (title);

					--Для Postgres, что бы сделать автоинкремент пришлось поискать в интернете
						CREATE SEQUENCE _countries_seq;
						ALTER TABLE _countries ALTER COLUMN id SET DEFAULT nextval('_countries_seq');
						ALTER TABLE _countries ALTER COLUMN id SET NOT NULL;
						ALTER SEQUENCE _countries_seq OWNED BY _countries.id;
						SELECT setval('_countries_seq', (SELECT max(id) FROM _countries));

					-- PRIMARY KEY;
						alter table _countries add primary key (id);
						
					-- FOREIGN KEY;
						alter table _regions add foreign key (country_id) references _countries (id);			



			--Создание пользователя для geodata:
				CREATE ROLE user_group;
				CREATE ROLE user_db WITH LOGIN ENCRYPTED PASSWORD 'passdb';
				GRANT user_group TO user_db;
				GRANT CONNECT ON DATABASE geodata TO user_group;
				grant all privileges on database geodata to user_db;



			--Создание таблицы:
				--Main table:
					create table users (
						id serial primary key, --serial указывает автонумерацию
						login text NOT NULL UNIQUE,
						password text NOT NULL,
						nickname text NOT NULL UNIQUE	
					);
				--Зависимая:
					create table likes (
						id serial primary key,
						create_stamp timestamp,
						from_id integer,
						to_id integer,
						active smallint,
						foreign key (from_id) references users (id),
						foreign key (to_id) references users (id)
					);


			--Изменение таблицы
					alter table likes 
					add column obj_type integer, 	--Добавить колонку
					add foreign key (obj_type)		--Добавить внешний ключ
						references obj_types (id); 

			--Удаление элементов таблицы
				Alter table users
				drop constraint users_pkey;


			--Импорт данных:
				Insert into users (name) 
					values 	('Вася'),
							('Маша'),
							('Катя');
							
				--дочерняя таблицаы
				Insert into likes (create_stamp, from_id, to_id, active)
					values 
						(current_timestamp, 2, 1, 1),
						(current_timestamp, 3, 1, 1),
						(current_timestamp, 1, 2, 1),
						(current_timestamp, 4, 3, 1),
						(current_timestamp, 4, 5, 1);

			--Join

				--С помощью джоина вычитаю одну выборку из другой. в итоге остаеются 2 и 3)
					select users.id, users.name
					from (
						select distinct(from_id) from likes where to_id in (1,2)
					) as t1
					left join (
						select distinct(from_id) from likes where to_id = 3 order by from_id
					) as t2
					on t2.from_id = t1.from_id
					left join users
					on users.id = t1.from_id
					where t2.from_id is null; -- с помощью этого where делаем вычитание одного множества из другого


			--Функуция
				--есть входные и выходные параметры:
					CREATE OR REPLACE FUNCTION  getManagerName(in f1 text, in f2 text, out f3 text)
					AS $$ 
					
						select 'return result'
					
					$$
					LANGUAGE SQL;

					--test
						SELECT * FROM getManagerName('f1', 'f2');

				--функция ничего не возвращает:
					CREATE OR REPLACE FUNCTION  shareFile(in fileName text, in filePath text, in ownerUser text, in targerUser text) 
					RETURNS void
					AS $$ 

						select 'geg'

					$$
					LANGUAGE SQL;

					--test
						SELECT * FROM shareFile('fileName', 'filePath', 'ownerUser', 'targerUser');



			--Хранимая процедура
				CREATE OR REPLACE PROCEDURE shareFile2(
				"fileName" text,
				"filePath" text,
				"ownerName" text,
				"targetUserName" text)
				LANGUAGE 'plpgsql'
				AS $BODY$
				Declare  
					ownerId int;
					targetUserId int;
					fileId int;
				Begin


					--search owner id
					select id into ownerId from users where nickname = "ownerName";
					
					--search targerUser id
					select id into targetUserId from users where nickname = "targetUserName";

					--save file to table
					insert into files (file_name, file_path, owner_id)
						values ("fileName", "filePath", ownerId);
						
					--search file id
					select id into fileId from files where files.file_name = "fileName" and files.file_path = "filePath" and files.owner_id = ownerId;
						
					--save info to share table
					insert into files_share (file_id, target_user_id)
						values (fileId, targetUserId);
						
						
				end
				$BODY$;

				--полномочия на вызов
					ALTER PROCEDURE shareFile2(text, text, text, text) OWNER TO fnrtuqrj;
					   
				--пример вызова
					CALL shareFile2('file4', 'file1Path2', 'test', 'test2')

				--пример вызова в Java:
					public static void main(String[] args) throws SQLException {
					try (Connection connection1 = DriverManager.getConnection(
							"jdbc:postgresql://tyke.db.elephantsql.com:5432/fnrtuqrj",
							"fnrtuqrj",
							"NLpOUejgCpyCN9POcNC7XlDtSK3h4Hw6")) {

						String preparedSql = " call shareFile2(?,?,?,?)";
						try (CallableStatement cstmt = connection1.prepareCall(preparedSql)) {
							cstmt.setString(1, "fileName111");
							cstmt.setString(2, "filePath111");
							cstmt.setString(3, "test");
							cstmt.setString(4, "test2");
							cstmt.execute();
						}
					}
					
					
					
					
		Admin commands:
			sudo service postgresql status
			sudo service postgresql stop
			sudo service postgresql start

		Сonnect к PosrtgreSQL через программу терминал psql:
			sudo -u postgres psql - здесь -u это указание юзера, логин posrgres, и сама программа psql
			
		Получить структуру БД в SQL:
			sudo -u postgres pg_dump --schema-only --no-owner GeekBrainsDBLessons > create_the_tables.sql
			  --комменты
				пишем сначала sudo -u postgres - этим говорим, что запуск программы pg_dump будет из под УЗ postgres
				
		psql:
			\d - список таблиц
			\d <table name> - структура таблицы
			\h - список всех команд SQL
			\h CREATE TABLE - выводит описание команды CREATE TABLE
			\l - db list
			\c - к какой бд сейчас подключены
			\? - справка
			chcp 1251 - установка русской раскладки
			
		Загрузка файла sql:
			sudo cp <path to file.sql> </usr/lib/postgresql/9.3/bin/postgres> - копируем файл в папку Postgres что бы были полномочия на чтение
			realpath file.sql - узнаем реальный путь до файла
			psql -h localhost -U postgres -d employees -f <path_to_file.sql> - импорт файла

		Создание пользователя для geodata:
			CREATE ROLE user_group;
			CREATE ROLE user_db WITH LOGIN ENCRYPTED PASSWORD 'passdb';
			GRANT user_group TO user_db;
			GRANT CONNECT ON DATABASE geodata TO user_group;
			grant all privileges on database geodata to user_db;
				
				 





Пример задач по Java:
	Полноценное клиент-серверное приложение + второе приложение, которое общается с первым через брокер сообщений. Я использовала Spring MVC, Spring Security, Spring Data, для маппинга классов в бд и обратно Hibernate, базу данных MySQL, брокер сообщений RabbitMq, WebSocket, контейнер сервлетов Tomcat, Log4j для логирования, Java Mail для отправки сообщений на email из приложения. Для UI части использовала шаблонизатор страничек Thymeleaf. Для тестирования JUnit и Mockito. Получилось довольно сложное и интересное приложение - онлайн магазин с раздельным функционалом для клиентов и админа. С корзиной товаров, оформлением заказа, фильтрацией каталога товаров и прочим. Для админа - возможность добавления товаров, работа с заказами, изменения статусов оплаты, доставки и прочее, а также различные метрики, например - валовая выручка магаза за выбранный период времени. Вторым приложением был рекламный стенд с категориями-бестселлерами магазина, стенд обновлялся в режиме реального времени через брокер сообщений и вебсокеты, когда происходили покупки на основном сайте магазина. 


Reddis:
	Reddis - это бд в памяти NoSql, они предназначены для хранения в БД (в памяти) объекты какие-то количество времени. Хранят объекты в виде HashMap. 
	Плюс Reddis:
		- он заточен под хранение в HashMap, и по ключу будет искать значение максимально быстро. Он может настроить время жизни объекта, т.е. можно задать что к примеру корзина покупок юзера (ключ - логин, значение - json с описанием покупок) и задать время хранения этого объекта 2 недели
		- легко масштабируются
		- отказоустойчивы - т.е. если инстанс Reddis упадет, то он будет восстановлен без потерь данных


Docker:
	docker images - все образы
	
	docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:11.1 - запустит в контейнере postgresql если его нет, то скачает его.
	
	docker run --name postgres -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d --network resource postgres - запуск контейнера в сети rescource
	
	docker run --name <containerName> -p 8080:8080 -d <imageName>:<tag/version> - запуск java приложения
	
	docker run --name spr -p 8080:8080 -d -e "SPRING_PROFILES_ACTIVE=dev" -e spring.datasource.url=jdbc:postgresql://postgres:5432/resource --network resource  spring-boot-docker:0.0.1-SNAPSHOT - запуск java приложения с указанием профиля (для spring) и сети rescource

	docker container ls - вывод всех контейнеров
	docker ps - вывод активных контейнеров
	docker ps -a - вывод всех контейнеров
	docker exec -it postgres psql -U postgres - обращаемся в контейнер postgres к программе psql и входим в терминальную сессию 	
	docker stop <containerName> - остановка контейнера
	docker rm <containerName> - удалить контейнер
	docker network create <networkName> - создаем сеть
	docker network ls - список всех сетей
	docker system prune -af --volumes - очистка всех volumes
	docker-compose up - поднимаем образы файла docker-compose.yaml
	docker-compose rm - удаляем все образы
	docker-compose down -v
	
