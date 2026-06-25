package com.spo.core_app.services;

import com.spo.core_app.constants.SystemConstant;
import com.spo.core_app.responses.FileUploadResult;
import io.imagekit.sdk.ImageKit;
import io.imagekit.sdk.models.FileCreateRequest;
import io.imagekit.sdk.models.results.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@Service
public class ImageKitService implements MultiMediaService {

    private ImageKit imageKit;

    @Autowired
    ImageKitService(ImageKit imageKit){
        this.imageKit = imageKit;
    }

    @Override
    public void getImage() {

    }

    @Override
    public FileUploadResult uploadImage(MultipartFile file, String path, String fileName) {
        FileUploadResult result=null;
        for(int i =0 ;i<SystemConstant.FILE_UPLOAD_RETRY_TIMES;i++){
            try {
                byte[] fileBytes = file.getBytes();
                FileCreateRequest fileCreateRequest = new FileCreateRequest(fileBytes,file.getOriginalFilename());
                fileCreateRequest.setFolder(path);
                Result imageKitResult = imageKit.upload(fileCreateRequest);
                result =  FileUploadResult.builder()
                        .fileId(imageKitResult.getFileId()).
                        fileName(imageKitResult.getName()).
                        fileLink(imageKitResult.getUrl()).
                        fileSize(imageKitResult.getSize()).
                        fileType(imageKitResult.getFileType()).
                        build();
                return result;
            } catch (Exception e) {
                log.error(String.format("%d time tried Image Upload failed because of the following reason %s ",i+1 ,e.getMessage()));
            }
        }
        return result;

    }

    @Override
    public void deleteImage() {

    }
}
