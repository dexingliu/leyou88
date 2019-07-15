package com.leyou.upload.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class UploadService {

    private static final List<String> CONTENT_TYPES = Arrays.asList("image/jpeg", "image/gif");
    //定义一个白名单，contenttype在这个范围内就合法
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);
    //什么一个logger工具

    public String upload(MultipartFile file) {

        String originalFilename = file.getOriginalFilename();//获取原始文件名
        // 校验文件的类型
        String contentType = file.getContentType();//请求文件里有contenttype
        if (!CONTENT_TYPES.contains(contentType)){
            // 文件类型不合法，直接返回null
            LOGGER.info("文件类型不合法：{}", originalFilename);
            //哪个图片上传哪出错，就打印日志
            return null;
        }

        try {
            // 校验文件的内容
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            //imageIO可以读取图片，不是图片就返回空
            if (bufferedImage == null){
                LOGGER.info("文件内容不合法不是图片：{}", originalFilename);
                return null;
            }

            // 保存到服务器
            file.transferTo(new File("F:\\hm49\\images\\" + originalFilename));
            // 生成url地址，返回
            return "http://image.leyou.com/" + originalFilename;
        } catch (IOException e) {
            LOGGER.info("服务器内部错误：{}", originalFilename);
            e.printStackTrace();
        }
        return null;
    }
}