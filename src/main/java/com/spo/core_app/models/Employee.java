package com.spo.core_app.models;

import com.spo.core_app.enums.EmploymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="employees")
public class Employee extends User {

    private String employeeId;

    private String designation;

    private String costCenter;

    private String businessUnit;

    @Enumerated(EnumType.STRING)
    private EmploymentType employmentType;

    private BigDecimal approvalLimit;

    private Boolean procurementApprover;

    private Boolean financeApprover;

    @ManyToOne
    private Employee manager;









}
