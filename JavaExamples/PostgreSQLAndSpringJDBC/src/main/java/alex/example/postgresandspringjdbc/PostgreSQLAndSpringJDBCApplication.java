package alex.example.postgresandspringjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class PostgreSQLAndSpringJDBCApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PostgreSQLAndSpringJDBCApplication.class, args);
	}


	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO persons (first_name, last_name) VALUES ("
				+ "'user', 'puser')";

		int rows = jdbcTemplate.update(sql);
		if (rows > 0) {
			System.out.println("A new row has been inserted.");
		}
	}



}
