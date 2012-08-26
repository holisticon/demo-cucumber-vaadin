package de.holisticon.employeemanager.handler;

import com.google.common.eventbus.Subscribe;

import de.holisticon.demo.MyVaadinApplication;
import de.holisticon.employeemanager.event.LogoutEvent;

public class LogoutHandler {

	private final MyVaadinApplication application;

	public LogoutHandler(MyVaadinApplication application) {
		this.application = application;
	}

	@Subscribe
	public void handleLogout(LogoutEvent logoutEvent) {
		application.logout();
	}
}
