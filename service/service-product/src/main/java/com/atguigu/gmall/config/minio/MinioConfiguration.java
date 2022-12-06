package com.atguigu.gmall.config.minio;

import io.minio.MinioClient;
import io.minio.errors.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Configuration
@Slf4j
public class MinioConfiguration {

    @Autowired
    MinioProperties minioProperties;

    @Bean
    public MinioClient minioClient() throws InvalidPortException, InvalidEndpointException, InvalidBucketNameException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException, RegionConflictException {
        MinioClient minioClient = new MinioClient(minioProperties.getEndPoint(), minioProperties.getUsername(), minioProperties.getPassword());
        boolean exists = minioClient.bucketExists(minioProperties.getBucketName());
        if (!exists){
            minioClient.makeBucket(minioProperties.getBucketName());
            return minioClient;
        }
        return minioClient;
    }


}
