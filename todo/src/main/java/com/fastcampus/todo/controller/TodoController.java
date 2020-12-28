package com.fastcampus.todo.controller;

import com.fastcampus.todo.dto.TodoDto;
import com.fastcampus.todo.model.Todo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    @GetMapping("/api/todos")
    public List<Todo> getAll() {
        Todo todo = Todo.builder()
                .id(1L)
                .title("강의")
                .description("스프링 강의")
                .owner("martin")
                .category("education")
                .dueDate(LocalDate.now())
                .build();

        List<Todo> todos = new ArrayList<>();
        todos.add(todo);
        return todos;
    }

    @GetMapping("/api/todo")
    public Todo get() {
        return  Todo.builder()
                .id(1L)
                .title("강의")
                .description("스프링 강의")
                .owner("martin")
                .category("education")
                .dueDate(LocalDate.now())
                .build();
    }

    @PostMapping("/api/todo")
    public void post(@RequestBody TodoDto dto) {
        System.out.println(dto);
    }

    @PutMapping("/api/todo/{id}")
    public void put(@RequestBody TodoDto dto) {
        System.out.println(dto);
    }

    @PatchMapping("/api/todo/{id}/completed")
    public void patch(@PathVariable Long id) {
    }
}
