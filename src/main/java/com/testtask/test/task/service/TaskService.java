package com.testtask.test.task.service;

import com.testtask.test.task.model.TaskInput;

import java.util.Map;

public interface TaskService {
    Map<Character, Long> findCharFrequency(TaskInput input);
}
