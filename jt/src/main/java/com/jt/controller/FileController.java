package com.jt.controller;

import com.jt.service.FileService;
import com.jt.vo.ImageVo;
import com.jt.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/file")
public class FileController {
    @Autowired
    private FileService fileService;

    /*
     *需求：实现我们的文件的上传
     * URL地址:"http://localhost:8091/file/upload"
     * 参数：file=xxxx
     * 类型：post请求
     * 返回值:SysResult(ImageVo)
     * 基础知识：
     * inputStream  outputStream
     * 高级API吧
     * 控制图片大小1m
     * */
    @PostMapping("/upload")
    public SysResult upload2(MultipartFile file) {
        ImageVo imageVo = fileService.upload(file);
        if (imageVo == null) {
            return SysResult.fail();
        }
        return SysResult.success(imageVo);
    }


    //    @PostMapping("/upload")
    public SysResult upload(MultipartFile file) throws IOException {
        //1.获取图片的名称
        String fileName = file.getOriginalFilename();
        //2.封装文件上传的目录
        String fileDir = "D:/images";
        //3.检查目录是否存在
        File dir = new File(fileDir);
        if (!dir.exists()) {//如果目录不存在则创建目录
            dir.mkdirs();


        }

        //
        //4.封装文件的全路径
        String path = fileDir + "/" + fileName;
        //5.上传文件
        file.transferTo(new File(path));
        return SysResult.success();
    }


    /*
    * 需求：删除图片信息
    * 类型：delete
    * 参数名称virtulPath
    * 返回值
    *
    * */
    @DeleteMapping("/deleteFile")
    public  SysResult deleteFile(String virtualPath){
        fileService.deleteFile(virtualPath);
        return SysResult.success();
    }


}
