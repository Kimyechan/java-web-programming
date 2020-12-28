package com.fastcampus.todo.model;

import lombok.*;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class User {
    private Long id;
    private String name;
    private String email;

//    private int age;
//    private String hobby;

//    @Override
//    public boolean equals(Object obj) {
//        if (obj == null) {
//            return false;
//        }
//
//        User user = (User) obj;
//
//        if (!user.getName().equals(this.getName())) {
//            return false;
//        }
//
//        if (!user.getEmail().equals(this.getEmail())) {
//            return false;
//        }
//
//        return true;
//    }
//
//    @Override
//    public int hashCode() {
//        return (name + email).hashCode();
//    }
}
