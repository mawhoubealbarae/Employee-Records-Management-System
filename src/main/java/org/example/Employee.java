package org.example;

import jakarta.persistence.*;
import jdk.jfr.DataAmount;
import lombok.Data;


import java.util.Date;
@Data
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String employeeId;
    private String jobTitle;
    private String department;
    private Date hireDate;
    private String employmentStatus;
    private String contactInfo;
    private String address;

    // Getters and Setters
}