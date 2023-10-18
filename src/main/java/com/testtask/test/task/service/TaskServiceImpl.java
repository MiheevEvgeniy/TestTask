package com.testtask.test.task.service;

import com.testtask.test.task.model.TaskInput;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {
    @Override
    public Map<Character, Long> findCharFrequency(TaskInput input) {
        return sort(input.getText().chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())));
    }

    private <K, V extends Comparable<V>> Map<K, V> sort(final Map<K, V> map) {
        Map<K, V> sorted = new TreeMap<>((k1, k2) -> {
            int comp = map.get(k1).compareTo(
                    map.get(k2));
            if (comp == 0)
                return 1;
            else
                return -comp;
        });

        sorted.putAll(map);

        return sorted;
    }
}
