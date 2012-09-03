package de.holisticon.employeemanager.handler;

import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.LoginForm.LoginEvent;

import de.holisticon.demo.MyVaadinApplication;
import de.holisticon.employeemanager.service.UserManagementService;

public class LoginHandler {

	private final MyVaadinApplication application;
	
	private UserManagementService userManagementService = new UserManagementService();

	public LoginHandler(MyVaadinApplication application) {
		this.application = application;
	}

	@Subscribe
	public void processLogin(LoginEvent loginEvent) {
		String username = loginEvent.getLoginParameter("username");
		String password = loginEvent.getLoginParameter("password");
		
		if(userManagementService.exists(username, password)){
			application.login();
		}
		else {
			application.loginDenied();
		}
	}
	
}
