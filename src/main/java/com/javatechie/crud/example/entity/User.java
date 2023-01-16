package com.javatechie.crud.example.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
    private String userName;
    private Integer age;
}