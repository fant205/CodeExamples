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