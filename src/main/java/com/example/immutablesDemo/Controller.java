package com.example.immutablesDemo;


import com.example.immutablesDemo.models.Project;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @PostMapping(path = "/new-issue", headers = "Accept=application/json")
    public Project onIssueEvent(@RequestBody Project project) {
        System.out.println(project);
        return project;
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}
