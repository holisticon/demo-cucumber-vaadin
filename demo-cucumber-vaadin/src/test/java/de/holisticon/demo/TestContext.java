package de.holisticon.demo;

public enum TestContext {

	INSTANCE;

	private ApplicationDriver application = new ApplicationDriver();
	
	public ApplicationDriver getApplication() {
		return application;
	}
	
}
