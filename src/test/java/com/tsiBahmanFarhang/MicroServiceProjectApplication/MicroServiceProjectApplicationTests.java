package com.tsiBahmanFarhang.MicroServiceProjectApplication;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import static junit.framework.TestCase.assertEquals;

@SpringBootTest

class MicroServiceProjectApplicationTests {

	@Test
	public void testPath() throws IOException, InterruptedException {

		// Given
		String name = "api";
		//create client http
		HttpClient client = HttpClient.newBuilder()
				.version(HttpClient.Version.HTTP_2)
				.build();
		//Create url
		HttpRequest request = HttpRequest.newBuilder()
				.uri(URI.create("http://localhost:8080/api/v1/update"))
				.timeout(Duration.ofMinutes(1))
				.header("Content-Type", "application/json")
				.GET()
				.build();

		HttpResponse<String> response =
				client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println(response.statusCode());
		System.out.println(response.body());

		assertEquals(
				response.statusCode(),
				HttpStatus.ACCEPTED);

	}
	@Test
	void contextLoads() {
	}

}
