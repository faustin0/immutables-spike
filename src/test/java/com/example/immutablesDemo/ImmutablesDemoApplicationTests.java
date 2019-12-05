package com.example.immutablesDemo;

import com.example.immutablesDemo.models.Project;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.IOException;

@SpringBootTest
class ImmutablesDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testJackson() throws IOException {
		File json = new File("C:\\GIT_SANDBOX\\immutablesDemo\\src\\test\\resources\\project.json");
		ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());

		JsonNode jsonNode = objectMapper.readTree(json);
		Project project = objectMapper.readValue(json, Project.class);


		Assertions.assertThat(jsonNode.get("id").asInt()).isEqualTo(1);


	}
}
