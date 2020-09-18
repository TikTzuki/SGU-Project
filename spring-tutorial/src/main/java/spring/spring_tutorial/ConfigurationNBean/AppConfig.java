package spring.spring_tutorial.ConfigurationNBean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class AppConfig {
	
	@Bean("mysqlConnector")
	DatabaseConnector mysqlConfigure() {
		DatabaseConnector mySqlConnector = new MySqlConnector();
		mySqlConnector.setUrl("jdbc:mysql://localhost/mysqlDatabase");
		return mySqlConnector;
	}
	
	@Bean("mongodbConnector")
	DatabaseConnector mongodbConfigure() {
		DatabaseConnector mongoDbConnector = new MongoDbConnector();
		mongoDbConnector.setUrl("mongodb://mongodb0.example.com");
		return mongoDbConnector;
	}
}
