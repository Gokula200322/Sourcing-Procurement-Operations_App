package com.spo.core_app.configurations;


import io.imagekit.sdk.ImageKit;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfiguration {

    @Value("${imagekit.public.key}")
    private String publicKey;
    @Value("${imagekit.private.key}")
    private String privateKey;
    @Value("${imagekit.endpoint}")
    private String endPoint;


    @Bean
    public ImageKit createImageKit(){
        io.imagekit.sdk.config.Configuration config = new io.imagekit.sdk.config.Configuration(
                 publicKey,
                 privateKey,
                 endPoint
                );
        ImageKit imageKit = ImageKit.getInstance();
        imageKit.setConfig(config);
        return imageKit;
    }

}
