package com.spo.core_app.transformers;

import com.spo.core_app.dtos.request.ProcurementCompanyRegistrationDto;
import com.spo.core_app.enums.CompanyStatus;
import com.spo.core_app.models.ProcurementCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CompanyAdaptor {

    public ProcurementCompany mapProcurementCompanyDtoToModel(
            ProcurementCompanyRegistrationDto dto
    ){
        return ProcurementCompany.builder()
                // Company Fields
                .legalName(dto.getLegalName())
                .displayName(dto.getDisplayName())
                .companyType(dto.getCompanyType())
                .companyStatus(dto.getCompanyStatus())
                .taxId(dto.getTaxId())
                .taxRegNumber(dto.getTaxRegNumber())
                .govRegNumber(dto.getGovRegNumber())
                .primaryContactNumber(dto.getPrimaryContactNumber())
                .contactName(dto.getContactName())
                .contactEmail(dto.getContactEmail())
                .addressLine1(dto.getAddressLine1())
                .addressLine2(dto.getAddressLine2())
                .addressLine3(dto.getAddressLine3())
                .city(dto.getCity())
                .country(dto.getCountry())
                //Procurement Fields
                .baseCurrency(dto.getBaseCurrency())
                .annualProcurementBudget(dto.getAnnualProcurementBudget())
                .availableBudget(dto.getAvailableBudget())
                .approvalRequired(dto.getApprovalRequired())
                .approvalLevels(dto.getApprovalLevels())
                .autoApprovalThreshold(dto.getAutoApprovalThreshold())
                .rfqRequiredThreashold(dto.getRfqRequiredThreashold())
                .rfpRequiredThreshold(dto.getRfpRequiredThreshold())
                .contractRequired(dto.getContractRequired())
                .erpSystem(dto.getErpSystem())
                .erpCompanyCode(dto.getErpCompanyCode())
                .costCenterPrefix(dto.getCostCenterPrefix())
                // Default Values
                .activeSuppliers(0)
                .activeContracts(0)
                .activePurchaseOrders(0)
                .activePurchaseRequests(0)
                .complianceReviewRequired(true)
                .legalReviewRequired(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy(dto.getContactName())
                .updatedBy(dto.getContactEmail())
                .build();


    }
}
