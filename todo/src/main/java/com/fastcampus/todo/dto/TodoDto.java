package com.fastcampus.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDto {
    private String title;
    private String description;
    private String category;
    private LocalDate dueDate;
    private String password;
}
