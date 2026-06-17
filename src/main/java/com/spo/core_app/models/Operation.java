package com.spo.core_app.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "operations")
public class Operation extends GlobalRecord{
    private String id; // for human readable format - OPR-1 , OPR-2, OPR-3 etc

    @Column(unique = true,nullable = false)
    private String operationName;
    private String operationCategory;

}
