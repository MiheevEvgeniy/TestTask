package com.testtask.test.task.controller;

import com.testtask.test.task.model.TaskInput;
import com.testtask.test.task.service.TaskService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/task")
@Slf4j
public class TaskController {
    @Autowired
    private TaskService service;

    @PostMapping
    public Map<Character, Long> findCharFrequency(@RequestBody @Valid TaskInput input) {
        log.info("findCharFrequency with body: {}", input);
        Map<Character, Long> result = service.findCharFrequency(input);
        log.info("findCharFrequency finished with result: {}", result);
        return result;
    }
}
