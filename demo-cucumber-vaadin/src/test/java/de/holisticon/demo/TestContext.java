package de.holisticon.demo;

import de.holisticon.demo.pageobject.LoginPage;
import de.holisticon.demo.pageobject.MainPage;

public enum TestContext {

	INSTANCE;

	private final ApplicationDriver appInstance = new ApplicationDriver();
	
	private ApplicationDriver getApplication() {
		return appInstance;
	}
	
	public static LoginPage loginPage() {
		if(application().currentPage() instanceof LoginPage){
			return new LoginPage(application().browser());
		} 
		throw new UnsupportedOperationException("loginPage not at display");
	}

	public static MainPage mainPage() {
		if(application().currentPage() instanceof MainPage){
			return new MainPage(application().browser());
		} 
		throw new UnsupportedOperationException("mainPage not at display");
	}

	public static ApplicationDriver application() {
		return TestContext.INSTANCE.getApplication();
	}
}
