package de.holisticon.demo;

import com.google.common.eventbus.EventBus;

public class ApplicationEventBus {

	private static ApplicationEventBus instance;
	private EventBus eventBus;

	private ApplicationEventBus() {
		eventBus = new EventBus();
	}

	private static ApplicationEventBus getInstance() {
		if (instance == null) {
			instance = new ApplicationEventBus();
		}
		return instance;
	}

	public static void register(Object object) {
		getInstance().eventBus.register(object);
	}

	public static void unregister(Object object) {
		getInstance().eventBus.unregister(object);
	}

	public static void post(Object object) {
		getInstance().eventBus.post(object);
	}

}
