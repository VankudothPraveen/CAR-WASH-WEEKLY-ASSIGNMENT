package com.carwash.carwash.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cleaners")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class cleaner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int experience; // years
    private double salary;
    private String area;
}

