# Spring-Boot-App-using-JDBC
Sample Application using H2 embedded database in spring boot

#Prerequisites

```
You should have the following installed 
 - Maven 
 - Tomcat
```

#Getting started

Create a sample Maven project with the following class DemoApplication

```
@SpringBootApplication
public class DemoApplication {

	// Start of a spring boot app
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}

```
The H2 database is taken as default (configuration file is not required in this case), so just we need to give its dependencies in the pom file

Add the following dependencies to your POM file

```
		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
		</dependency>
   
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
    
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
   
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-jdbc</artifactId>
		</dependency>
    
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
		</dependency>
```

Make a sample sql statements file and give the following in the main application to run the script
```
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
  ```

Add the model, controllers and Repositories to the code and do a maven build in eclipse or in the command prompt as follows:

```
mvn clean install

```
Run the application as spring-boot app using the following command

```
mvn spring-boot:run
```
