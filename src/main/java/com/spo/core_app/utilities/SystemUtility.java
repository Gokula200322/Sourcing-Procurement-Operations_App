package com.spo.core_app.utilities;

import com.spo.core_app.models.GlobalRecord;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
public class SystemUtility {
    // since we set this for all the classes we create and get from the user
    // we have kept setGlobalRecordFields as a utilityFunc

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final Random random = new Random();


    public static void setGlobalRecordProperties(GlobalRecord globalRecord,
                                                 LocalDateTime createdAt,
                                                 LocalDateTime updatedAt,
                                                 String createdBy,
                                                 String updatedBy){
      //  GlobalRecord.builder().createdAt(createdAt).updatedAt(updatedAt).createdBy(createdBy).updatedBy(updatedBy).build();
        globalRecord.setCreatedAt(createdAt);
        globalRecord.setUpdatedAt(updatedAt);
        globalRecord.setCreatedBy(createdBy);
        globalRecord.setUpdatedBy(updatedBy);

    }

    //generates values for all entity class IDS as COMPANY-001, ATTACHMENT-00
    public static String generate(String entityName){
        String prefix = entityName.substring(0,Math.min(3,entityName.length())).toUpperCase();
        StringBuilder suffixRandom = new StringBuilder();



        for(int i = 0 ; i < 3 ; i++){

            suffixRandom.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        return prefix+"-"+suffixRandom;
    }


}
