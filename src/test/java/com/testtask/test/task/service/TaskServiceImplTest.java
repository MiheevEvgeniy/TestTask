package com.testtask.test.task.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testtask.test.task.model.TaskInput;
import com.testtask.test.task.service.TaskService;
import com.testtask.test.task.service.TaskServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class TaskServiceImplTest {
    @InjectMocks
    private TaskServiceImpl service;
    private static TaskInput input;
    private static Map<Character, Long> output;

    @BeforeAll
    static void initData() {
        input = new TaskInput();
        input.setText("fffffasadadqwwwrrrfvvvvvc");

        output = new LinkedHashMap<>(){
            {
                put('f',6L);
                put('v',5L);
                put('a',3L);
                put('r',3L);
                put('w',3L);
                put('d',2L);
                put('q',1L);
                put('c',1L);
                put('s',1L);
            }
        };
    }
    @Test
    void findCharFrequency_whenInvoked_thenCharFrequencyMapReturned(){
        Map<Character, Long> result = service.findCharFrequency(input);

        assertEquals(output, new LinkedHashMap<>(result));
    }
}
