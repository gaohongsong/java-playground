package org.feichai.themyleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
public class FileController {

    @GetMapping("/toUpload")
    public String toUpload() {
        return "toUpload";
    }

    @PostMapping("/uploadFile")
    public String uploadSingleFile(@RequestParam("myfile") MultipartFile myfile, Model model) {

        if(myfile.isEmpty()) {
            model.addAttribute("result_singlefile", "文件为空");
            return "toUpload";
        }
        try {
            // InputStream inputStream = myfile.getInputStream();

            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            String mediaPath = path.getAbsolutePath() + "/media/";

            File targetFile = new File(mediaPath + myfile.getOriginalFilename());
            if(!targetFile.getParentFile().exists()) {
                targetFile.getParentFile().mkdirs();
            }

            // OutputStream outputStream = new FileOutputStream(targetFile);
            myfile.transferTo(targetFile);
            // FileCopyUtils.copy(inputStream, outputStream);

            model.addAttribute("uploadResult", "success");
        } catch (Exception e) {
            model.addAttribute("uploadResult", "fail");
        }
        return "toUpload";
    }

}
