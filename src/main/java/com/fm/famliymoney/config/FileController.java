package com.fm.famliymoney.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class FileController {
    public final static String IMG_PATH_PREFIX = "static/upload/imgs";
    @GetMapping("/file")
    public String file(){
        return "file";
    }

    @PostMapping("/fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam(value = "file")MultipartFile file, Model model, HttpServletRequest request){
        if (file.isEmpty()) {
            System.out.println("上传失败，请选择文件");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainy//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        model.addAttribute("filename", filename);
        return "http://localhost:8484"+filename;
    }
}
