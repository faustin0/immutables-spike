package com.example.immutablesDemo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(Controller.class)
@ExtendWith(SpringExtension.class)
class ControllerTest {

    static Path projectJsonPath;

    @Autowired
    MockMvc sut;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeAll
    static void beforeAll() throws URISyntaxException {
        projectJsonPath = Paths.get(
                ControllerTest.class.getClassLoader()
                        .getResource("project.json")
                        .toURI()
        );
    }

    @Test
    void shouldMapExpectedProject() throws Exception {
        String jsonContent = Files
                .lines(projectJsonPath)
                .map(String::trim)
                .collect(Collectors.joining());

        MvcResult result = sut
                .perform(post("/new-issue")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonContent))
                .andExpect(status().isOk())
                .andReturn();

        String responseAsString = result.getResponse().getContentAsString();

        assertThat(responseAsString)
                .isEqualToIgnoringNewLines(jsonContent);
    }
}