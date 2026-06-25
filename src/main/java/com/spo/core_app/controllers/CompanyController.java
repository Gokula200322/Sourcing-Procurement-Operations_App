package com.spo.core_app.controllers;


import com.spo.core_app.dtos.request.ProcurementCompanyRegistrationDto;
import com.spo.core_app.models.ProcurementCompany;
import com.spo.core_app.services.ProcurementCompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tools.jackson.databind.ObjectMapper;


@Slf4j
@RestController
@RequestMapping("/api/company/")
public class CompanyController {

    private ProcurementCompanyService procurementCompanyService;

    @Autowired
    public CompanyController(ProcurementCompanyService procurementCompanyService) {
        this.procurementCompanyService = procurementCompanyService;
    }

    @PostMapping(value = "/register/procurementcompany", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity registerProcurementCompany(
            @RequestPart String prcourementCompanyDetails,
            @RequestPart MultipartFile companyLogo,
            @RequestPart MultipartFile companyRegCertificate){

        // convert String prcourementCompanyDetails text to Java Object
        ObjectMapper objectMapper = new ObjectMapper();
        ProcurementCompanyRegistrationDto procurementCompanyRegistrationDto = objectMapper.readValue(prcourementCompanyDetails, ProcurementCompanyRegistrationDto.class);
        // now pass the dto obj to the ProcurementCompanyService Class for businessLogic
        ProcurementCompany procurementCompany = procurementCompanyService.registerProcurementCompany(procurementCompanyRegistrationDto, companyLogo, companyRegCertificate);

        return new ResponseEntity(procurementCompany, HttpStatus.CREATED);
    }

}
