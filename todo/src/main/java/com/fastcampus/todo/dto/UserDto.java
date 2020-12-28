package com.fastcampus.todo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
//    @NotNull // null == str
//    @NotBlank // null == str && "" == str " " == str
    @NotEmpty // null == str && "" == str
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String address;

    @NotEmpty
    private String password;
}
