package spring.spring_tutorial.ConfigurationNBean;

public class MongoDbConnector extends DatabaseConnector {

	@Override
	public void connect() {
		System.out.println("Connect to Mongodb successed " + getUrl());
	}
}
