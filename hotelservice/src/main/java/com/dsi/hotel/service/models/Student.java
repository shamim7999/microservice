package com.dsi.hotel.service.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity @Table(name = "students")
@Data
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;
}
