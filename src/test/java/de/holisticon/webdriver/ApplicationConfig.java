package de.holisticon.webdriver;

import java.io.FileInputStream;
import java.util.Properties;

public class ApplicationConfig {

	public static final String DEFAULT_CONFIG_PROPS = "src/test/resources/conf.properties";
	private Properties props;

	public ApplicationConfig() {
		try {
			props = new Properties();
			FileInputStream fis = new FileInputStream(DEFAULT_CONFIG_PROPS);
			props.load(fis);
			fis.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String pathToBrowser() {
		return valueOf("pathToBrowser");
	}

	public String display() {
		return valueOf("display");
	}

	public String applicationUrl() {
		return valueOf("applicationUrl");
	}

	public int delayForRendering() {
		return Integer.valueOf(valueOf("delayForRenderingInSeconds"));
	}

	public String databaseUrl() {
		return valueOf("databaseUrl");
	}

	private String valueOf(String key) {
		return props.getProperty(key);
	}

}
