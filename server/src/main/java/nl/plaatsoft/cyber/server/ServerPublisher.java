package nl.plaatsoft.cyber.server;

import javax.xml.ws.Endpoint;

public class ServerPublisher {
	
	public static void main(String[] args) {
		   Endpoint.publish("http://0.0.0.0:81/", new ServerImpl());
	    }
}
