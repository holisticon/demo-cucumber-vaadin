package de.holisticon.emapp.handler;

import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.LoginForm.LoginEvent;

import de.holisticon.emapp.EmployeeManagerApp;
import de.holisticon.emapp.service.UserManagementService;

public class LoginHandler {

	private final EmployeeManagerApp application;

	private UserManagementService userManagementService = new UserManagementService();

	public LoginHandler(EmployeeManagerApp application) {
		this.application = application;
	}

	@Subscribe
	public void processLogin(LoginEvent loginEvent) {
		String username = loginEvent.getLoginParameter("username");
		String password = loginEvent.getLoginParameter("password");

		if (userManagementService.exists(username, password)) {
//			application.getMainWindow().setContent(new MainComponent());
		}
		else {
//			MessageBox.showError(application.getMainWindow(), "unbekannter user");
		}
	}

}
