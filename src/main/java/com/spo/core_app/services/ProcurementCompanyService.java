package com.spo.core_app.services;


import com.spo.core_app.constants.SystemConstant;
import com.spo.core_app.dtos.request.ProcurementCompanyRegistrationDto;
import com.spo.core_app.models.Attachment;
import com.spo.core_app.models.ProcurementCompany;
import com.spo.core_app.repositories.AttachmentRepository;
import com.spo.core_app.repositories.ProcurementCompanyRepository;
import com.spo.core_app.responses.FileUploadResult;
import com.spo.core_app.strategy.MultiMediaServiceStrategy;
import com.spo.core_app.transformers.CompanyAdaptor;
import com.spo.core_app.utilities.SystemUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ProcurementCompanyService {

    private CompanyAdaptor companyAdaptor;
    private ProcurementCompanyRepository procurementCompanyRepository;
    private MultiMediaServiceStrategy multiMediaServiceStrategy;
    private AttachmentRepository attachmentRepository;

    @Autowired
    ProcurementCompanyService(CompanyAdaptor companyAdaptor ,ProcurementCompanyRepository procurementCompanyRepository ,MultiMediaServiceStrategy multiMediaServiceStrategy ,AttachmentRepository attachmentRepository){
        this.companyAdaptor = companyAdaptor;
        this.procurementCompanyRepository = procurementCompanyRepository;
        this.multiMediaServiceStrategy = multiMediaServiceStrategy;
        this.attachmentRepository = attachmentRepository;
    }


    public ProcurementCompany registerProcurementCompany(
            ProcurementCompanyRegistrationDto procurementCompanyRegistrationDto,
            MultipartFile companyLogo,
            MultipartFile companyRegCertificate
    ){
        // now we have to map the ProcurementCompanyRegistrationDto obj with ProcurementCompany model class obj
        // so we are going to use the  Adapter/Transformer design Pattern.

        ProcurementCompany procurementCompany = companyAdaptor.mapProcurementCompanyDtoToModel(procurementCompanyRegistrationDto);
       // procurementCompany = procurementCompanyRepository.save(procurementCompany);
        // now imageKit connectivity and logic
        MultiMediaService multiMediaService = multiMediaServiceStrategy.getService(SystemConstant.IMAGE_KIT_SERVICE_NAME);
        // procurementCompany.getSysId() SINCE DB has not stored the procurementCompany data so sysID is not being generated
        // and showing null in the ImageKit Server so we'll use
        FileUploadResult compLogoResult = multiMediaService.uploadImage(companyLogo,SystemConstant.PROCUREMENT_COMPANY_DOC_BASE_PATH + "/" + procurementCompany.getLegalName(), "companyLogo");
        Attachment compLogoAttachment = Attachment.builder()
                .attachmentId(SystemUtility.generate(SystemConstant.ATTACHMENT_ENTITY_NAME))
                .AttachmentUrl(compLogoResult.getFileLink())
                .attachmentType(compLogoResult.getFileType()) // enum means how to do so for now im comnverting the datatype from enum to String
                .attachmentDescription("company logo document")
                .fileOriginalName(compLogoResult.getFileName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy(SystemConstant.APPLICATION_USER_NAME)
                .updatedBy(SystemConstant.APPLICATION_USER_NAME)
                .build();

        compLogoAttachment = attachmentRepository.save(compLogoAttachment);

        FileUploadResult compRegCertificateResult = multiMediaService.uploadImage(companyRegCertificate,SystemConstant.PROCUREMENT_COMPANY_DOC_BASE_PATH + "/" + procurementCompany.getSysId(), "companyRegisterCertificate");
        Attachment compRegCertiAttachment = Attachment.builder()
                .attachmentId(SystemUtility.generate(SystemConstant.ATTACHMENT_ENTITY_NAME))
                .AttachmentUrl(compRegCertificateResult.getFileLink())
                .attachmentType(compRegCertificateResult.getFileType()) // enum means how to do so for now im comnverting the datatype from enum to String
                .attachmentDescription("company Registered Certificate document")
                .fileOriginalName(compRegCertificateResult.getFileName())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .createdBy(SystemConstant.APPLICATION_USER_NAME)
                .updatedBy(SystemConstant.APPLICATION_USER_NAME)
                .build();

        compRegCertiAttachment = attachmentRepository.save(compRegCertiAttachment);

        List<Attachment> attachments = List.of(compLogoAttachment,compRegCertiAttachment);

        procurementCompany.setAttachments(attachments);

        procurementCompanyRepository.save(procurementCompany);

        return procurementCompany;
    }
}
