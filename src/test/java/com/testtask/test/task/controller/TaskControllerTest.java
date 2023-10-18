package com.testtask.test.task.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testtask.test.task.model.TaskInput;
import com.testtask.test.task.service.TaskService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.scheduling.config.Task;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = TaskController.class)
public class TaskControllerTest {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @MockBean
    private TaskService service;

    private static TaskInput input;
    private static Map<Character, Long> output;

    @BeforeAll
    static void initData() {
        input = new TaskInput();

        output = new TreeMap<>(){
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
    @SneakyThrows
    void findCharFrequency_whenInvoked_thenCharFrequencyMapReturned() {
        when(service.findCharFrequency(input))
                .thenReturn(output);

        input.setText("fffffasadadqwwwrrrfvvvvvc");

        mvc.perform(post("/task")
                        .content(mapper.writeValueAsString(input))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$").exists())
                .andReturn()
                .getResponse()
                .getContentAsString();

    }
    @Test
    @SneakyThrows
    void findCharFrequencyWithInvalidText_whenInvoked_thenBadRequestReturned() {
        when(service.findCharFrequency(input))
                .thenReturn(output);

        input.setText("   ");

        mvc.perform(post("/task")
                        .content(mapper.writeValueAsString(input))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.status").exists())
                .andReturn()
                .getResponse()
                .getContentAsString();

    }
}
