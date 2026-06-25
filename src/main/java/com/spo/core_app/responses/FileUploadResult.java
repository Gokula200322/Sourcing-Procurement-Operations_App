package com.spo.core_app.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FileUploadResult {
    String fileId;
    String fileLink;
    String fileName;
    String fileType;
    Long fileSize;
}
