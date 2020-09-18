package spring.spring_tutorial.ConfigurationNBean;

public class MySqlConnector extends DatabaseConnector{
	@Override
	public void connect() {
		System.out.println("connect to Mysql successed: "+ getUrl());
	}
}
