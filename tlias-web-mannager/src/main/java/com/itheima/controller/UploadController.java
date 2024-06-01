package com.itheima.controller;

import com.itheima.pojo.Result;
import com.itheima.properties.AliyunOSSProperties;
import com.itheima.util.AliyunOSSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
@Slf4j
public class UploadController {
    @Autowired
    private AliyunOSSProperties aliyunOSSProperties;
    /*
     * 基础
     * */
/*    @PostMapping
    public Result upload(MultipartFile file) throws IOException {
        String oldFileName = file.getOriginalFilename();
        log.info("文件接收成功 "+oldFileName);
        String newFileName = UUID.randomUUID().toString() + oldFileName.substring(oldFileName.lastIndexOf("."));
        log.info(newFileName);
        file.transferTo(new File("E:\\ideaWorkSpace\\Web\\day11\\tlias-web-mannager\\src\\main\\resources\\file\\"+newFileName));
        return Result.success();
    }*/

 /*   private String endpoint = "https://oss-cn-shenzhen.aliyuncs.com";
    private String bucketName = "web-tlias-mystudy";*/


    /**
     * 上载员工图像
     * @param file 文件
     * @return 后端统一返回结果
     * @throws Exception 例外
     */
    @PostMapping
    public Result upload(MultipartFile file) throws Exception {
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String url = AliyunOSSUtils.upload(aliyunOSSProperties.getEndpoint(), aliyunOSSProperties.getBucketName(), file.getBytes(), suffix);
        return Result.success(url);
    }
}
