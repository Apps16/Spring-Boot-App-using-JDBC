package com.example;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

/**
 * This represents the start of spring boot application
 */

@SpringBootApplication
public class DemoApplication {

	// Start of a spring boot app
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	// Gets the sql statements from init.sql
	@Value("classpath:init.sql")
	private Resource initSqlScript;

	// Sql statements are executed
	@Bean
	public CommandLineRunner init(DataSource ds) {
		return args -> {
			ScriptUtils.executeSqlScript(ds.getConnection(), initSqlScript);
		};
	}
}
