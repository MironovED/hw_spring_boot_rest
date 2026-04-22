package ru.netology.spring_boot_rest;

import org.junit.jupiter.api.Test;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.junit.jupiter.Container;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringBootRestApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Container
	private final GenericContainer<?> appDev = new GenericContainer<>("devapp:latest")
			.withExposedPorts(8080);

	@Container
	private final GenericContainer<?> appProd = new GenericContainer<>("prodapp:latest")
			.withExposedPorts(8080);


	@Test
	void shouldPort8080() {
		ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + appDev.getMappedPort(8080), String.class);
		System.out.println(forEntity.getBody());

		Integer port = appDev.getMappedPort(8080);
		assertEquals(8080, port);
	}

	@Test
	void shouldPort8081() {
		ResponseEntity<String> forEntity = restTemplate.getForEntity("http://localhost:" + appProd.getMappedPort(8080), String.class);
		System.out.println(forEntity.getBody());

		Integer port = appDev.getMappedPort(8080);
		assertEquals(8081, port);
	}
}
