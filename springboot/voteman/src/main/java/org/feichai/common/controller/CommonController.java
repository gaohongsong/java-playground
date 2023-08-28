package org.feichai.common.controller;

import lombok.extern.slf4j.Slf4j;
import org.feichai.common.exception.FileDownloadException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Controller
public class CommonController {
    @RequestMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response) throws FileDownloadException, IOException {

        String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf('_') + 1);
        String filePath = "file/" + fileName;
        File file = new File(filePath);
        if(!file.exists()) {
            throw new FileDownloadException("文件未找到!");
        }

        response.setHeader("Content-Disposition", "attachment;fileName=" + java.net.URLEncoder.encode(realFileName, "utf-8"));
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");

        try (InputStream inputStream = new FileInputStream(file); OutputStream outputStream = response.getOutputStream()) {
            byte[] b = new byte[2048];
            int length;
            while ((length = inputStream.read(b)) > 0) {
                outputStream.write(b, 0, length);
            }
        } catch (Exception e) {
            log.error("文件下载失败", e);
        } finally {
            if (delete) {
                Files.delete(Paths.get(filePath));
            }
        }
    }
}
