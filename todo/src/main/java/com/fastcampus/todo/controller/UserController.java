package com.fastcampus.todo.controller;

import com.fastcampus.todo.dto.UserDto;
import com.fastcampus.todo.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {
    @GetMapping("/api/user/{id}")
    public User getUser(@PathVariable Long id) {
        return new User(id, "martin", "martin@fastcampus.com");
    }

    @PostMapping("/api/user")
    public void postUser(@Valid @RequestBody UserDto userDto) {
        System.out.println(userDto);

    }
}
