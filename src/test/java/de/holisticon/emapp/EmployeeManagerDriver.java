package de.holisticon.emapp;

import de.holisticon.emapp.pageobject.LoginPage;
import de.holisticon.emapp.pageobject.MainPage;
import de.holisticon.emapp.service.UserManagementService;
import de.holisticon.vaadin.pageobject.VaadinPageObject;
import de.holisticon.webdriver.ApplicationDriver;

public class EmployeeManagerDriver extends ApplicationDriver {

	public boolean existsUserWithCredentials(String username, String password) {
		return new UserManagementService().exists(username, password);
	}

	public VaadinPageObject currentPage() {
		if (pageContainsId("_loginComponent")) {
			return new LoginPage(browser());
		}

		if (pageContainsId("_mainComponent")) {
			return new MainPage(browser());
		}

		throw new IllegalStateException("invalid display state, only mainpage or loginpage are allowed");
	}
}
