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
