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