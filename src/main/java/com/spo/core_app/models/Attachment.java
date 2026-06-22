package com.spo.core_app.models;

import com.spo.core_app.enums.AttachmentType;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "attachments")
public class Attachment extends GlobalRecord {

    private String attachmentId;

    private String AttachmentUrl;
    @Enumerated
    private AttachmentType attachmentType;
    private String attachmentDescription;
    private String fileOriginalName;
    private String fileSystemName;




}
