package com.carwash.carwash.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "customers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String area;

    // Example: "MONTHLY FULL CLEAN"
    private String packageType;

    private LocalDate startDate;
    private LocalDate endDate;

    // ✅ Correct mapping: Many customers → One cleaner
    @ManyToOne
    @JoinColumn(name = "cleaner_id")
    private cleaner cleaner;
}
