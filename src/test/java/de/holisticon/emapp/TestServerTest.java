package de.holisticon.emapp;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class TestServerTest {

	@Test
	public void shouldStartJetty() throws Exception {
		TestServer server = TestServer.INSTANCE;
		
		server.start();
		assertThat(server.isRunning()).isTrue();
		server.stop();
	}
}
