package com.itschool.spring_boot.models;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Book {

    private UUID id;
    private String title;
    private String author;
    private int pageNo;
    private String description;
    private LocalDateTime createdAt;

}