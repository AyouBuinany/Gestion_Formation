package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Config {
		private String host;
		private String userName;
		private String password;
		private String driver;
	public Connection connect;
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Config(String host , String userName,String password,String driver) {
		this.host=host;
		this.userName=userName;
		this.password=password;
	this.driver=driver;
	}
	public Connection ConnectionLoad() throws Exception {
	Class.forName(getDriver());
		connect= DriverManager.getConnection(getHost(), getUserName(), getPassword());
		return connect;
	}


}
