package com.fastcampus.todo.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode
//@Value
@Builder
public class Todo {
    @NonNull // Required
    private Long id;
    @NonNull
    private String title;
    private String description;
    private String owner;
    private String category;
    private LocalDate dueDate; // Date는 불변객체가 아니여서 사용하지 않음 -> 여려 곳에서 변경이 발생한다
    @ToString.Exclude
    private String password;
}


