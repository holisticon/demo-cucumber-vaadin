package de.holisticon.emapp.handler;

import com.google.common.eventbus.Subscribe;

import de.holisticon.emapp.EmployeeManagerApp;
import de.holisticon.emapp.event.LogoutEvent;

public class LogoutHandler {

	private final EmployeeManagerApp application;

	public LogoutHandler(EmployeeManagerApp application) {
		this.application = application;
	}

	@Subscribe
	public void handleLogout(LogoutEvent logoutEvent) {
		application.logout();
	}
}
