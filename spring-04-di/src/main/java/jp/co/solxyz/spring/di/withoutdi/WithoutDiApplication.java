package jp.co.solxyz.spring.di.withoutdi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WithoutDiApplication implements CommandLineRunner {

    private final Company company = new Company();

    public static void main(String[] args) {
        // Spring Bootの起動
        SpringApplication.run(WithoutDiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        company.run();
    }
}
