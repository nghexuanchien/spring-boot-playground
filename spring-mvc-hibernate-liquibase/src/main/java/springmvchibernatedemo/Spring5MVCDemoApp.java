package springmvchibernatedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

/**
 * @author chiennghe
 */
//https://stackoverflow.com/questions/38627491/spring-4-hibernate-5-org-springframework-orm-jpa-entitymanagerholder-cannot
@SpringBootApplication
@EnableAutoConfiguration(exclude = HibernateJpaAutoConfiguration.class)
public class Spring5MVCDemoApp {
	public static void main(String[] args) {
		SpringApplication.run(Spring5MVCDemoApp.class, args);
	}
}
