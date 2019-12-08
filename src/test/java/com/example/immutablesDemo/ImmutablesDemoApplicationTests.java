package com.example.immutablesDemo;

import com.example.immutablesDemo.models.Project;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class ImmutablesDemoApplicationTests {


    @Test
    void testJackson() throws IOException, URISyntaxException {
        URI res = ImmutablesDemoApplicationTests.class.getClassLoader().getResource("project.json").toURI();

        File json = new File(res);
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());

        Project project = objectMapper.readValue(json, Project.class);

        assertAll(
                () -> assertThat(project.id()).isEqualTo(1),
                () -> assertThat(project.avatarUrl()).isEmpty(),
                () -> assertThat(project.visibilityLevel()).isEmpty()
        );
    }
}
