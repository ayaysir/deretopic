package com.example.deretopic.util;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.net.URLEncoder;
import java.util.Base64;

public class FileIOUtil {
    private static final String SERVICE_CODE = "deretopic";

    private static File getFileFromRelativePath(String dirRelativePath, String fileName) {
        String rootPath = FileSystemView.getFileSystemView().getHomeDirectory().toString();
        String basePath = rootPath + "/" + SERVICE_CODE;
        String fileAbsolutePath = basePath + "/" + dirRelativePath + "/" + fileName;
        System.out.println(">>>> fileAbsolutePath: " + fileAbsolutePath);

        File dir = new File(basePath + "/" + dirRelativePath);
        if(!dir.exists()) {
            dir.mkdirs();
        }

        return new File(fileAbsolutePath);
    }

    public static ResponseEntity<Resource> flushFileFromResources(String dirRelativePath,
                                                          String downloadName,
                                                          HttpServletRequest request) throws Exception {

        File file = getFileFromRelativePath(dirRelativePath, downloadName);

        String browser = request.getHeader("User-Agent");

        // 파일 인코딩
        if (browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")) {
            // 브라우저 확인 파일명 encode
            downloadName = URLEncoder.encode(downloadName, "UTF-8").replaceAll("\\+", "%20");
        } else {
            downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
        }

        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", "filename=\"" + downloadName + "\"");
        headers.set("Accept-Ranges", "bytes");
        headers.set("Content-Length", file.length() + "");
        headers.set("Content-Transfer-Encoding", "binary;");

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(resource);
    }

    public static File writeFileToResourceFromBASE64Bytes(String dirRelativePath,
                                                   String fileName,
                                                   byte[] encodedBytes) throws IOException {

        File file = getFileFromRelativePath(dirRelativePath, fileName);

        Base64.Decoder decoder = Base64.getDecoder();
        byte[] decodedBytes = decoder.decode(encodedBytes);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(decodedBytes);
        fileOutputStream.close();

        return file;

    }
}
