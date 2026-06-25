package com.spo.core_app.services;

import com.spo.core_app.responses.FileUploadResult;
import io.imagekit.sdk.models.results.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AzureService implements MultiMediaService {
    @Override
    public void getImage() {

    }

    @Override
    public FileUploadResult uploadImage(MultipartFile file, String path, String fileName) {
        return null;
    }

    @Override
    public void deleteImage() {

    }
}
