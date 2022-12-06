package com.atguigu.gmall.controller;

import com.atguigu.common.result.Result;
import com.atguigu.gmall.config.minio.MinioConfiguration;
import com.atguigu.gmall.config.minio.MinioProperties;
import io.minio.MinioClient;
import io.minio.PutObjectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.HttpRequestHandlerServlet;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping("/admin/product")
public class FileController {

    @Autowired
    MinioProperties minioProperties;

    @Autowired
    MinioClient minioClient;

    @PostMapping("/fileUpload")
    public Result fileUpload(HttpRequestHandlerServlet
                                 request,@RequestPart("file") MultipartFile file) throws Exception{
        String name = UUID.randomUUID().toString().replace("-", "") + "_" + file.getOriginalFilename();
        PutObjectOptions options = new PutObjectOptions(file.getSize(),-1);
        options.setContentType(file.getContentType());

        minioClient.putObject(minioProperties.getBucketName(),name, file.getInputStream(),options);

        String url = minioProperties.endPoint+"/"+minioProperties.getBucketName()+"/"+name;
        return Result.ok(url);
    }

}
