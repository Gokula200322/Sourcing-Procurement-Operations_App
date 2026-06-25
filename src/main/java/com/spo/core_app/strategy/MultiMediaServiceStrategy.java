package com.spo.core_app.strategy;

import com.spo.core_app.constants.SystemConstant;
import com.spo.core_app.services.AwsService;
import com.spo.core_app.services.AzureService;
import com.spo.core_app.services.ImageKitService;
import com.spo.core_app.services.MultiMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MultiMediaServiceStrategy {

    private AwsService awsService;
    private AzureService azureService;
    private ImageKitService imageKitService;

    @Autowired
    MultiMediaServiceStrategy(AwsService awsService, AzureService azureService, ImageKitService imageKitService){
        this.awsService = awsService;
        this.azureService = azureService;
        this.imageKitService = imageKitService;
    }


    public MultiMediaService getService(String cloudServiceName){

        switch(cloudServiceName){
            case SystemConstant.AWS_SERVICE_NAME : return awsService;
            //break;

            case SystemConstant.AZURE_SERVICE_NAME : return azureService;
            //break;

            case SystemConstant.IMAGE_KIT_SERVICE_NAME : return imageKitService;
            //break;

            default : throw new IllegalArgumentException("Incorect Service Name passed");
           // break;
        }
    }

}
