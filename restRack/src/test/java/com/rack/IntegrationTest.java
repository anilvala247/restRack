package com.rack;

import java.io.File;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

public class IntegrationTest {

	private static URI getBaseURI() {
		return UriBuilder.fromUri(
				"http://localhost:8080/restRack/rest/task").build();
	}

	public static void main(String[] args) {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		WebResource service = client.resource(getBaseURI());

		// Get XML
		System.out.println("Get XML");
		System.out.println(service.queryParam("id", "3")
				.accept(MediaType.APPLICATION_XML).get(String.class));

		// Post XML
//		String response1 = service.type(MediaType.APPLICATION_XML)
//				.accept(MediaType.APPLICATION_XML).entity(new File("post.xml"))
//				.post(String.class);
//		System.out.println(response1);
	}

}
