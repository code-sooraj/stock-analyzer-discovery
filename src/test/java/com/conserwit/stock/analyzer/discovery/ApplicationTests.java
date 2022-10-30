package com.conserwit.stock.analyzer.discovery;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.DEFINED_PORT;

@SpringBootTest(webEnvironment = DEFINED_PORT)
@ActiveProfiles("dev")
class ApplicationTests {

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void catalogLoads() {
		ResponseEntity<Map> entityMap = testRestTemplate.getForEntity("/eureka/apps", Map.class);
		assertThat(entityMap.getStatusCode()).isEqualTo(HttpStatus.OK);
	}

	@Test
	public void adminLoads() {
		ResponseEntity<Map> entityMap = testRestTemplate.getForEntity("/actuator/env", Map.class);
		assertThat(entityMap.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
}
