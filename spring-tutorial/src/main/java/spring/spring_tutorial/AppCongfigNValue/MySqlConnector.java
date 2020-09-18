package spring.spring_tutorial.AppCongfigNValue;

public class MySqlConnector extends DatabaseConnector {
	@Override
	public void connect() {
		System.out.println(getUrl());
	}
}
