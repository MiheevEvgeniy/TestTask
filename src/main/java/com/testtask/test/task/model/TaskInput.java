package com.testtask.test.task.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class TaskInput {
    @Size(min = 1, max = 300)
    @NotBlank
    String text;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskInput taskInput = (TaskInput) o;
        return Objects.equals(text, taskInput.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
