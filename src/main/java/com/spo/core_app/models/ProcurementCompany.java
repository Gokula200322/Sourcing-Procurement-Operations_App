package com.spo.core_app.models;


import com.spo.core_app.enums.Currency;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "procurement_company")
public class ProcurementCompany extends Company {

    private String procurementCompanyId;


    //Procurement Organization Details
    private String procurementHead;
    private String procurementEmail;
    private String procurementPhone;

    //Financial Control
    @Enumerated
    private Currency baseCurrency;
    private BigDecimal annualProcurementBudget;
    private BigDecimal availableBudget;


    //Approval Configuration
    private Boolean approvalRequired;
    private Integer approvalLevels;


    //purchasing Control
    private BigDecimal autoApprovalThreshold;
    private BigDecimal rfqRequiredThreashold;
    private BigDecimal rfpequiredThreshold;

   // Procurement Policies

    private Boolean contractRequired;

    // Erp Integration

    private String erpSystem;
    private String erpCompanyCode;
    private String costCenterPrefix; // account for diff Products like Healthcare,Banking etc

    //Procurement Metrics

    private Integer activeSuppliers;
    private Integer activeContracts;
    private Integer activePurchaseRequests;
    private Integer activePurchaseOrders;


    // Compliance
    private Boolean complianceReviewRequired;
    private Boolean legalReviewRequired;

    //Dates

    private LocalDate goLiveDate;
    private LocalDate lastAuditDate;

    private String remarks;























}
