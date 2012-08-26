package de.holisticon.employeemanager.handler;

import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.LoginForm.LoginEvent;

import de.holisticon.demo.MyVaadinApplication;

public class LoginHandler {

	private final MyVaadinApplication application;

	public LoginHandler(MyVaadinApplication application) {
		this.application = application;
	}

	@Subscribe
	public void processLogin(LoginEvent loginEvent) {
		String username = loginEvent.getLoginParameter("username");
		String password = loginEvent.getLoginParameter("password");
		
		if(username.equals("willi") && password.equals("winzig")){
			application.loginSuccessful();
		}
		else {
			application.loginDenied();
		}
	}
}
