package com.treasure.group.hiddentreasure;

import org.fusesource.jansi.AnsiConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author chirag
 * Spring boot Main class
 *
 */
@SpringBootApplication
@EnableJpaRepositories
@EnableAutoConfiguration
@ComponentScan(basePackages = { "com.treasure.group.hiddentreasure" })
public class HiddenTreasureApplication {

	public static void main(String[] args) {
		//enable ANSOI for console for colored texts
		AnsiConsole.systemInstall();
		SpringApplication.run(HiddenTreasureApplication.class, args);
	}
}
