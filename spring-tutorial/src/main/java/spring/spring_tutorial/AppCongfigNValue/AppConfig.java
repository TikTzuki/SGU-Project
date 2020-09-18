package spring.spring_tutorial.AppCongfigNValue;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig {
	@Value("${tik.mysql.url}")
	String mysqlUrl;

	@Bean("mysqlConfigure")
	DatabaseConnector mysqlConfigure() {
		DatabaseConnector mySqlConnector = new MySqlConnector();
		
		System.out.println(mysqlUrl);
		
		mySqlConnector.setUrl(mysqlUrl);
		return mySqlConnector;
	}
}
