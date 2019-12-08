package com.example.immutablesDemo;


import com.example.immutablesDemo.models.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    Logger log = LoggerFactory.getLogger(Controller.class);

    @PostMapping(path = "/new-issue", headers = "Accept=application/json")
    public Project onIssueEvent(@RequestBody Project project) {
        log.info("receiving {}", project);
        return project;
    }
}
