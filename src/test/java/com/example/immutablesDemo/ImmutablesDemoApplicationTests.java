package com.example.immutablesDemo;

import com.example.immutablesDemo.models.Project;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

@SpringBootTest
class ImmutablesDemoApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void testJackson() throws IOException, URISyntaxException {
		URI res = ImmutablesDemoApplicationTests.class.getClassLoader().getResource("project.json").toURI();

		File json  = new File(res);
		ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());

		JsonNode jsonNode = objectMapper.readTree(json);
		Project project = objectMapper.readValue(json, Project.class);


		Assertions.assertThat(jsonNode.get("id").asInt()).isEqualTo(1);
		Assertions.assertThat(project.visibilityLevel()).isEmpty();
	}
}
