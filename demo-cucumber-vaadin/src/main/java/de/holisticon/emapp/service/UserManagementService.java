package de.holisticon.emapp.service;

import java.io.FileInputStream;
import java.util.Properties;

public class UserManagementService {

	public static final String DEFAULT_CONFIG_PROPS = "src/main/resources/users.properties";
	private Properties users;

	public UserManagementService() {
		try {
			users = new Properties();
			FileInputStream fis = new FileInputStream(DEFAULT_CONFIG_PROPS);
			users.load(fis);
			fis.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean exists(String username, String password) {
		if (!users.isEmpty()){
			boolean knowsUsername = users.containsKey(username.trim());
			return knowsUsername && (users.getProperty(username).equals(password));
		}
		return false;
	}
	
	public String pathToBrowser() {
		return valueOf("pathToBrowser");
	}

	private String valueOf(String key) {
		return users.getProperty(key);
	}

}
