package com.spo.core_app.dtos.request;

import com.spo.core_app.enums.CompanyStatus;
import com.spo.core_app.enums.CompanyType;
import com.spo.core_app.enums.Currency;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ProcurementCompanyRegistrationDto {

    private String legalName;
    private String displayName;
    private CompanyType companyType;

    private CompanyStatus companyStatus;
    private String taxId;
    private String taxRegNumber;
    private String govRegNumber;
    private String primaryContactNumber;
    private String contactName;
    private String contactEmail;
    private String addressLine1;
    private String addressLine2;
    private String addressLine3;
    private String city;
    private String country;



    //Procurement Organization Details
    private String procurementHead;

    //Financial Control

    private Currency baseCurrency;
    private BigDecimal annualProcurementBudget;
    private BigDecimal availableBudget;


    //Approval Configuration
    private Boolean approvalRequired;
    private Integer approvalLevels;


    //purchasing Control
    private BigDecimal autoApprovalThreshold;
    private BigDecimal rfqRequiredThreashold;
    private BigDecimal rfpRequiredThreshold;

    // Procurement Policies

    private Boolean contractRequired;

    // Erp Integration

    private String erpSystem;
    private String erpCompanyCode;
    private String costCenterPrefix; // account for diff Products like Healthcare,Banking etc


}
