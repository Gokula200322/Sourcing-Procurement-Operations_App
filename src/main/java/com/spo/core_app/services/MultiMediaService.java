package com.spo.core_app.services;

import com.spo.core_app.responses.FileUploadResult;
import io.imagekit.sdk.models.results.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface MultiMediaService {

    public void getImage();
    public FileUploadResult uploadImage(MultipartFile file, String path, String fileName);
    public void deleteImage();
}
