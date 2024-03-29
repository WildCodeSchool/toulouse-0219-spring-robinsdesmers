package fr.wildcodeschool.robinsdesmers;

import fr.wildcodeschool.robinsdesmers.repository.CollectPointRepository;
import fr.wildcodeschool.robinsdesmers.repository.RubbishRepository;
import fr.wildcodeschool.robinsdesmers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class RobinsdesmersApplication extends SpringBootServletInitializer {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RubbishRepository rubbishRepository;

	@Autowired
	CollectPointRepository collectPointRepository;

	public static void main(String[] args) {
		SpringApplication.run(RobinsdesmersApplication.class, args);
	}

}
