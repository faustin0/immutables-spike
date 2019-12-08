package com.example.immutablesDemo;

import com.example.immutablesDemo.models.ImmutableProject;
import com.example.immutablesDemo.models.Project;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.OptionalInt;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;


class ImmutablesDemoApplicationTests {


    @Test
    void testImmutablesMapping() throws IOException, URISyntaxException {
        Project expected = ImmutableProject.builder()
                .id(1)
                .avatarUrl(Optional.empty())
                .visibilityLevel(OptionalInt.empty())
                .name("Gitlab Test")
                .description("Aut reprehenderit ut est.")
                .webUrl("http://example.com/gitlabhq/gitlab-test")
                .gitSshUrl("git@example.com:gitlabhq/gitlab-test.git")
                .gitHttpUrl("http://example.com/gitlabhq/gitlab-test.git")
                .namespace("GitlabHQ")
                .pathWithNamespace("gitlabhq/gitlab-test")
                .defaultBranch("master")
                .homepage("http://example.com/gitlabhq/gitlab-test")
                .url("http://example.com/gitlabhq/gitlab-test.git")
                .sshUrl("git@example.com:gitlabhq/gitlab-test.git")
                .httpUrl("http://example.com/gitlabhq/gitlab-test.git")
                .build();

        URI res = ImmutablesDemoApplicationTests.class.getClassLoader().getResource("project.json").toURI();
        File json = new File(res);
        ObjectMapper objectMapper = new ObjectMapper(new JsonFactory());

        Project project = objectMapper.readValue(json, Project.class);

        assertAll(
                () -> assertThat(project.id()).isEqualTo(1),
                () -> assertThat(project.avatarUrl()).isEmpty(),
                () -> assertThat(project.visibilityLevel()).isEmpty(),
                () -> assertThat(project).isEqualTo(expected)
        );
    }
}
