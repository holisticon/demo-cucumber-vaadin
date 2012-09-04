package de.holisticon.employeemanager.ui;

import com.vaadin.ui.Window;
import com.vaadin.ui.Window.Notification;

public class MessageBox {

	public static void showTray(Window window, String title, String message) {
		window.showNotification(title, message, Notification.TYPE_TRAY_NOTIFICATION);
	}

	public static void showError(Window window, String message) {
		window.showNotification(message, Notification.TYPE_ERROR_MESSAGE);
	}

}
