package de.holisticon.emapp;

import de.holisticon.emapp.pageobject.LoginPage;
import de.holisticon.emapp.pageobject.MainPage;

public enum EmployeeManagerContext {

	INSTANCE;

	private final EmployeeManagerDriver appInstance = new EmployeeManagerDriver();

	public static LoginPage loginPage() {
		if (application().currentPage() instanceof LoginPage) {
			return new LoginPage(application().browser());
		}
		throw new UnsupportedOperationException("loginPage not at display");
	}

	public static MainPage mainPage() {
		if (application().currentPage() instanceof MainPage) {
			return new MainPage(application().browser());
		}
		throw new UnsupportedOperationException("mainPage not at display");
	}

	public static EmployeeManagerDriver application() {
		return EmployeeManagerContext.INSTANCE.appInstance;
	}
}
