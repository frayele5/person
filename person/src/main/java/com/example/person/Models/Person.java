package com.example.person.Models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

    @Data
    @Document(collection = "persons")
    public class Person {
        @Id
        private ObjectId id;

        @NotBlank(message = "First name is required")
        private String firstName;

        @NotBlank(message = "Last name is required")
        private String lastName;

        @Min(value = 1, message = "Age must be positive")
        private int age;
    }