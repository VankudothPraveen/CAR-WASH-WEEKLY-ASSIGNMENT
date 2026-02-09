package com.carwash.carwash.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerCleanerResponse {

    private String customerName;
    private String customerArea;

    private String cleanerName;
    private int cleanerExperience;

    private String packageDuration;
    private String serviceType;

    private LocalDate startDate;
    private LocalDate endDate;

    private String message;
}
