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

# Hibernate:
## API
	EntityManager – это интерфейс, который обеспечивает основные действия, такие, как: выборка, добавление и удаление записи, управление транзакциями т.д. В Hibernate используется наследник EntityManager - Session.
	Session - наследник EntityManager
	EntityManagerFactory – это фабричный класс, который создает и управляет несколькими экземплярами «EntityManager». В Hibernate используется наследник EntityManagerFactory - SessionFactory.
	SessionFactory - наследник EntityManagerFactory		
	Persistence – класс, который содержит статические методы для создания «EntityManagerFactory». Данный класс можно рассматривать как главную входную точку в функциональность JPA, но непосредственно он используется редко, т. существует множество более удобных методов работы с JPA.
	EntityTransaction – интерфейс, который используется для управления транзакциями. Для каждого «EntityManager» создается отдельный экземпляр «EntityTransaction» через метод «getTransaction».
	Entity – это объекты-сущности, которые соответствуют таблицам базы данных.
	Query - это интерфейс, который используется для получения записей из базы данных.	
	
## hibernate.cfg.xml

	<!DOCTYPE hibernate-configuration PUBLIC
	"-//Hibernate/Hibernate Configuration DTD 3.0//EN"
	"http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
	<hibernate-configuration>
	<session-factory>
	<property
	name="connection.driver_class">org.postgresql.Driver</property>
	<property
	name="connection.url">jdbc:postgresql://localhost:5432/postgres</property>
	<property name="connection.username">postgres</property>
	<property name="connection.password">admin</property>
	<property name="connection.pool_size">1</property>
	<property
	name="dialect">org.hibernate.dialect.PostgreSQL94Dialect</property>
	<property name="show_sql">true</property>
	<property name="hbm2ddl.auto">none</property>
	<property name="current_session_context_class">thread</property>
	<mapping class="com.geekbrains.hibernate.Person"/>
	</session-factory>
	</hibernate-configuration>
	
	● connection.driver_class - имя класса JDBC-драйвера для БД к которой мы должны
	подключиться. Данный драйвер должен быть подключен к проекту как maven-зависимость или
	каким-то другим способом добавлен в classpath проекта;
	● connection.url - url для подключения к серверу базы данных. В данном случае сервер базы
	данных развернут на локальной машине, на стандартном порту 5432, и имя базы данных -
	postgres;
	● connection.username, connection.password - логин/пароль пользователя;
	● connection.pool_size - размер пула соединений;
	● dialect - задает класс-описатель диалекта SQL для конкретной БД. Диалект нужен чтобы
	Hibernate корректно формировал запросы для используемой СУБД. Нужно указать класс,
	который соответствует типу и версии БД, которая у вас установлена;
	● show_sql - включает отображение в логах сервера SQL запросов, которые HIbernate
	выполняет в процессе работы. Очень полезна в учебных целях и для отладки, но может очень
	сильно снизить производительность приложения. Поэтому в рабочих версиях приложения ее
	обычно отключают;	
	● hibernate.hbm2ddl.auto - очень важная настройка, которая задает режим Hibernate для
	работы со структурой таблиц в БД. Разберем некоторые возможные значения этой настройки
		○ none - никаких действий при запуске приложения не выполняется. Если структура
		таблиц не соответствует структуре классов-сущностей приложения то в процессе
		работы могут возникнуть ошибки
		○ create - база данных будет создана при запуске приложения, причем все ранее
		находившиеся в ней таблицы будут удалены и все данные из них потеряны.
		○ update - структура БД будет обновляться в соответствии со структурой
		классов-сущностей в приложении. Этот режим наиболее удобен на начальном этапе
		разработки и в учебных проектах.
		○ validate - при запуске приложения осуществляется проверка структуры таблиц БД на
		соответствие структуре классов сущностей в приложении. Если структуры не
		соответствуют, то приложение завершится с ошибкой. Данный режим чаще всего
		используется в реальных приложениях.
	● current_session_context_class - указание области видимости сессии, в данном случае для
	каждого потока будет своя сессия;
	● mapping class - перечисление хранимых классов
	
	
## Сущность - Entity
	Условия чтобы класс был сущностью:
		● Наличие аннотации @Entity;
		● Наличие поля, помеченного аннотацией @Id, в котором будет храниться уникальный
		идентификатор сущности;
		● Наличие конструктора без аргументов (конструктора по-умолчанию) с модификатором доступа
		protected или public. Допускается объявление перегруженных конструкторов;
		● Отсутствие модификатора final в объявлении класса;
		● Отсутствие final в полях, ссылающихся на другие сущности, и в их геттерах;
		● Класс сущность должен быть верхнеуровневым классом. Перечисления и интерфейсы не
		могут быть сущностями;
		● Сущностями могут являться как обычные классы, так и абстрактные;
		● Доступ к полям сущности должен осуществляться через геттеры/сеттеры, сами поля не
		должны быть public;

	Пример:
	@Entity
	@Table(name = "persons")
	public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	// Геттеры и сеттеры
	// ...
	public Person() {
	}
	}


## Hibernate annotations
	@Entity - сущность, по умолчанию все его поля будут отображаться в БД
	@Transient - этой аннотацией помечается поле, если его не нужно отображать в БД
	@Column - имя колонки из БД
	@GeneratedValue - для того что бы в поле id после сохранение инжектировалось значение, нужно ставить эту аннотацию. Может принимать следующие значения из перечисления GenerationType:
		● GenerationType.SEQUENCE — говорит о том, что значение id будет генерироваться с
		помощью sequence-генератора, созданного разработчиком в базе данных. При использовании
		данной стратегии необходимо дополнительно указывать имя генератора в атрибуте name
		аннотации @GeneratedValue;
		● GenerationType.IDENTITY — указывает поставщику постоянства, что значение id необходимо
		получать непосредственно из столбца «id» таблицы, в которую мэппится данный
		объект-сущность;		
		● GenerationType.AUTO — предоставлялет Hibernate возможность самостоятельно выбрать
		стратегию для получения id, исходя из используемой СУБД;
		● GenerationType.TABLE — говорит о том, что для получения значения id необходимо
		использовать определенную таблицу в БД, содержащую набор чисел.
		
	Лучше всего использовать GenerationType.IDENTITY:
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		
## JPA Примеры запросов
	### JPQL:
		SELECT a FROM Article a
		SELECT a FROM Article a WHERE a.id = 2
		SELECT a.firstname, a.lastname FROM Author a
		SELECT a.firstname, a.lastname FROM Author a WHERE a.id = ?1
		SELECT a.firstname, a.lastname FROM Author a WHERE a.id = :id
		SELECT NEW com.geekbrains.Person(a.firstname, a.lastname) FROM Author a
	
	### In Java:
		List<Author> authors = em.createQuery("SELECT a FROM Author a", Author.class).getResultList();
		Author author = em.createQuery("SELECT a FROM Author a WHERE a.id = 1", Author.class).getSingleResult();
