package com.spo.core_app.jobs;

import com.spo.core_app.contants.SystemConstant;
import com.spo.core_app.models.Operation;
import com.spo.core_app.repositories.OperationRepository;
import com.spo.core_app.utilities.SystemUtility;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
public class SystemJob {

    private OperationRepository operationRepository;

    @Autowired
    public SystemJob(OperationRepository operationRepository){
    this.operationRepository=operationRepository;
    }

    public List<Operation> getAllSystemOperations(){
         return List.of(
                 Operation.builder().id("OPR-35").operationName("SOURCE_STRATEGY_DEFINITION").operationCategory("SOURCING").build(),
                 Operation.builder().id("OPR-36").operationName("CATEGORY_MANAGEMENT").operationCategory("SOURCING").build(),
                 Operation.builder().id("OPR-37").operationName("MARKET_INTELLIGENCE").operationCategory("SOURCING").build(),
                 Operation.builder().id("OPR-38").operationName("SUPPLIER_IDENTIFICATION").operationCategory("SUPPLIER_MANAGEMENT").build(),
                 Operation.builder().id("OPR-39").operationName("SUPPLIER_QUALIFICATION").operationCategory("SUPPLIER_MANAGEMENT").build(),
                 Operation.builder().id("OPR-40").operationName("SUPPLIER_ONBOARDING").operationCategory("SUPPLIER_MANAGEMENT").build(),
                 Operation.builder().id("OPR-41").operationName("REQUEST_FOR_INFORMATION_RFI").operationCategory("SOURCING").build(),
                 Operation.builder().id("OPR-42").operationName("REQUEST_FOR_PROPOSAL_RFP").operationCategory("SOURCING").build(),
                 Operation.builder().id("OPR-43").operationName("REQUEST_FOR_QUOTATION_RFQ").operationCategory("SOURCING").build(),
                 Operation.builder().id("OPR-44").operationName("BID_MANAGEMENT_AND_EVALUATION").operationCategory("SOURCING").build(),
                 Operation.builder().id("OPR-45").operationName("CONTRACT_NEGOTIATION").operationCategory("CONTRACTING").build(),
                 Operation.builder().id("OPR-46").operationName("CONTRACT_CREATION").operationCategory("CONTRACTING").build(),
                 Operation.builder().id("OPR-47").operationName("CONTRACT_APPROVAL_AND_EXECUTION").operationCategory("CONTRACTING").build(),
                 Operation.builder().id("OPR-48").operationName("MASTER_AGREEMENT_MANAGEMENT").operationCategory("CONTRACTING").build(),
                 Operation.builder().id("OPR-49").operationName("RATE_CONTRACT_MANAGEMENT").operationCategory("CONTRACTING").build(),
                 Operation.builder().id("OPR-50").operationName("PURCHASE_REQUISITION_CREATION").operationCategory("PROCUREMENT").build(),
                 Operation.builder().id("OPR-51").operationName("PURCHASE_REQUISITION_APPROVAL").operationCategory("PROCUREMENT").build(),
                 Operation.builder().id("OPR-52").operationName("CREATE_PR").operationCategory("PROCUREMENT").build(),
                 Operation.builder().id("OPR-53").operationName("VIEW_PR").operationCategory("PROCUREMENT").build(),
                 Operation.builder().id("OPR-54").operationName("PURCHASE_ORDER_CREATION").operationCategory("PROCUREMENT").build(),
                 Operation.builder().id("OPR-55").operationName("CREATE_PO").operationCategory("PROCUREMENT").build(),
                 Operation.builder().id("OPR-56").operationName("PO_APPROVAL_WORKFLOW").operationCategory("PROCUREMENT").build(),
                 Operation.builder().id("OPR-57").operationName("PO_CHANGE_AND_AMENDMENT").operationCategory("PROCUREMENT").build(),
                 Operation.builder().id("OPR-58").operationName("CATALOG_MANAGEMENT").operationCategory("PROCUREMENT").build(),
                 Operation.builder().id("OPR-59").operationName("E_PROCUREMENT_PUNCHOUT").operationCategory("TECHNOLOGY").build(),
                 Operation.builder().id("OPR-60").operationName("GOODS_RECEIPT_CREATION").operationCategory("RECEIPT").build(),
                 Operation.builder().id("OPR-61").operationName("GOODS_RECEIPT_VERIFICATION").operationCategory("RECEIPT").build(),
                 Operation.builder().id("OPR-62").operationName("INSPECTION_AND_ACCEPTANCE").operationCategory("RECEIPT").build(),
                 Operation.builder().id("OPR-63").operationName("RETURN_TO_SUPPLIER_RTS").operationCategory("RECEIPT").build(),
                 Operation.builder().id("OPR-64").operationName("INVOICE_RECEIPT").operationCategory("INVOICE").build(),
                 Operation.builder().id("OPR-65").operationName("INVOICE_VALIDATION").operationCategory("INVOICE").build(),
                 Operation.builder().id("OPR-66").operationName("INVOICE_MATCHING_3_WAY").operationCategory("INVOICE").build(),
                 Operation.builder().id("OPR-67").operationName("INVOICE_DISPUTE_MANAGEMENT").operationCategory("INVOICE").build(),
                 Operation.builder().id("OPR-68").operationName("INVOICE_APPROVAL").operationCategory("FINANCE").build(),
                 Operation.builder().id("OPR-69").operationName("PAYMENT_SCHEDULING_AND_EXECUTION").operationCategory("FINANCE").build(),
                 Operation.builder().id("OPR-70").operationName("THIRD_PARTY_FINANCIAL_INTEGRATION").operationCategory("FINANCE").build(),
                 Operation.builder().id("OPR-71").operationName("SUPPLIER_PERFORMANCE_MANAGEMENT").operationCategory("SUPPLIER_MANAGEMENT").build(),
                 Operation.builder().id("OPR-72").operationName("SUPPLIER_RISK_ASSESSMENT").operationCategory("RISK_COMPLIANCE").build(),
                 Operation.builder().id("OPR-73").operationName("SUSTAINABILITY_AND_CSR_ASSESSMENT").operationCategory("RISK_COMPLIANCE").build(),
                 Operation.builder().id("OPR-74").operationName("PROCUREMENT_COMPLIANCE_AND_AUDIT").operationCategory("RISK_COMPLIANCE").build(),
                 Operation.builder().id("OPR-75").operationName("SPEND_ANALYSIS_AND_REPORTING").operationCategory("ANALYTICS").build(),
                 Operation.builder().id("OPR-76").operationName("SUPPLIER_PORTAL_ACCESS").operationCategory("SUPPLIER_MANAGEMENT").build(),
                 Operation.builder().id("OPR-77").operationName("PROCUREMENT_AUTOMATION_RPA").operationCategory("TECHNOLOGY").build(),
                 Operation.builder().id("OPR-78").operationName("REPORT_VIEW").operationCategory("ANALYTICS").build(),
                 Operation.builder().id("OPR-78").operationName("REPORT_VIEW").operationCategory("ANALYTICS").build(),
                 Operation.builder().id("OPR-79").operationName("INVITE_USER").operationCategory("SYSTEM").build()

        );
    }



    @Scheduled(fixedRate = 10000, initialDelay = 5000)
    public void loadAllOperations(){
        // or noramlly also we can call getAllSystemOperations();
        // if local variable is same as instance var then using this is advised to differentiate.

        List<Operation> operations = this.getAllSystemOperations();

        for(Operation operation : operations){

            SystemUtility.setGlobalRecordProperties(operation,
                    LocalDateTime.now(),
                    LocalDateTime.now(),
                    SystemConstant.APPLICATION_USER_NAME,
                    SystemConstant.APPLICATION_USER_NAME);

            Optional<Operation> opr = operationRepository.findByOperationName(operation.getOperationName());

            if(opr.isEmpty()){
                operationRepository.save(operation);
                log.info(String.format("the operation-Name %s got saved in the operations Table",operation.getOperationName()));
            }else{
                log.info(String.format("the operation-Name %s alreay exists in the operations table",operation.getOperationName()));
            }


        }
        System.out.println();
    }


}
