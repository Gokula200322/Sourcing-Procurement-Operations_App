package com.spo.core_app.utilities;

import com.spo.core_app.models.GlobalRecord;

import java.time.LocalDateTime;

public class SystemUtility {
    // since we set this for all the classes we create and get from the user we have kept setGlobalRecordFields as a utilityFunc

    public static void setGlobalRecordProperties(GlobalRecord globalRecord,
                                                 LocalDateTime createdAt,
                                                 LocalDateTime updatedAt,
                                                 String createdBy,
                                                 String updatedBy){
       // globalRecord.builder().createdAt(createdAt).updatedAt(updatedAt).createdBy(createdBy).updatedBy(updatedBy).build();
        globalRecord.setCreatedAt(createdAt);
        globalRecord.setUpdatedAt(updatedAt);
        globalRecord.setCreatedBy(createdBy);
        globalRecord.setUpdatedBy(updatedBy);

    }
}
