package com.example.immutablesDemo.models;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.immutables.value.Value;

import java.util.Optional;
import java.util.OptionalInt;

@Value.Immutable
@JsonSerialize(as = ImmutableProject.class)
@JsonDeserialize(as = ImmutableProject.class)
public interface Project {
    int id();

    String name();

    String description();

    @JsonProperty("web_url")
    String webUrl();

    @JsonProperty("avatar_url")
    Optional<String> avatarUrl();

    @JsonProperty("git_ssh_url")
    String gitSshUrl();

    @JsonProperty("git_http_url")
    String gitHttpUrl();

    String namespace();

    @JsonProperty("visibility_level")
    OptionalInt visibilityLevel();

    @JsonProperty("path_with_namespace")
    String pathWithNamespace();

    @JsonProperty("default_branch")
    String defaultBranch();

    String homepage();

    String url();

    @JsonProperty("ssh_url")
    String sshUrl();

    @JsonProperty("http_url")
    String httpUrl();
}
