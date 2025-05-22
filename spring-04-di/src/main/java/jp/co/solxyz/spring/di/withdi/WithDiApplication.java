package jp.co.solxyz.spring.di.withdi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WithDiApplication implements CommandLineRunner {

	private final Company company;

	public WithDiApplication(Company company) {
		this.company = company;
	}

	public static void main(String[] args) {

		SpringApplication.run(WithDiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		company.run();
	}

}
