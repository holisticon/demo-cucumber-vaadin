package de.holisticon.emapp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.webapp.WebAppContext;

public class TestServer {

	public static final TestServer INSTANCE = new TestServer(8080, "src/main/webapp", "/demo-cucumber-vaadin-app");

	private Server server;

	private TestServer(final int port, final String resources, final String context) {
		server = new Server(port);
		server.setHandler(new WebAppContext(resources, context));
	}

	public void start(){
		try {
			server.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void stop() {
		try {
			server.stop();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public boolean isRunning() {
		return server.isRunning();
	}
}