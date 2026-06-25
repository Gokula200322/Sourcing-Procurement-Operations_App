package com.spo.core_app.models;


import com.spo.core_app.enums.CompanyType;
import com.spo.core_app.enums.CompanyStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Table(name = "companies")
public class Company extends GlobalRecord{

    private String companyId;
    private String legalName;
    private String displayName;
    @Enumerated
    private CompanyType companyType;
    @Enumerated
    private CompanyStatus companyStatus;
    private String mainLogoUrl;
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

    @OneToMany
    private List<Activity> activities;
    @OneToMany
    private List<Attachment> attachments;


}
