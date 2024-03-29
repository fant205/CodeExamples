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

//date
    Date date = new Date();
    System.out.println(date.toString());
		
//Logging:
	log.debugT(method, "Xml for Import manager: {0}", new Object[] { importXmlName });
	
//Rest Controller

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

//Format date
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
	result = format.format(((DateTimeValue) value).getDate());
  
  

//nio
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
