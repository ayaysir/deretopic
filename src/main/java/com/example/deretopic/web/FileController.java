package com.example.deretopic.web;

import com.example.deretopic.domain.uwasa.UwasaEntity;
import com.example.deretopic.service.UwasaEntityService;
import com.example.deretopic.web.dto.UwasaEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class FileController {

    private final UwasaEntityService uwasaEntityService;

    @GetMapping("/api/idol/tts/{id}")
    @ResponseStatus(HttpStatus.OK)	// Thymeleaf 사용시 이것을 사용해야 에러가 발생하지 않음
    public void fileDownloadOnWebBroweser(HttpServletRequest req,
                                          HttpServletResponse res,
                                          @PathVariable Long id) throws Exception  {

        String basePath = FileSystemView.getFileSystemView().getHomeDirectory().toString()
                + "/deretopic/resources/tts/";

        // find target
        File oneFile = null;
        UwasaEntityDTO dto = uwasaEntityService.findById(id);

        if(dto.getTtsFileName() != null) {
            oneFile = new File(basePath + dto.getTtsFileName());
        } else {
            res.sendError(404, "NoTTSFile");
        }

        String downloadName = "tts.mp3";
        String browser = req.getHeader("User-Agent");

        //파일 인코딩
        if(browser.contains("MSIE") || browser.contains("Trident") || browser.contains("Chrome")){
            //브라우저 확인 파일명 encode
            downloadName = URLEncoder.encode(oneFile.getName(), "UTF-8").replaceAll("\\+", "%20");
        }else{
            downloadName = new String(oneFile.getName().getBytes("UTF-8"), "ISO-8859-1");
        }

        res.setHeader("Content-Disposition", "attachment;filename=\"" + downloadName +"\"");
        res.setContentType("audio/mp3");
        res.setHeader("Content-Transfer-Encoding", "binary;");

        try(FileInputStream fis = new FileInputStream(oneFile);
            ServletOutputStream sos = res.getOutputStream();	){

            byte[] b = new byte[1024];
            int data = 0;

            while((data=(fis.read(b, 0, b.length))) != -1){
                sos.write(b, 0, data);
            }

            sos.flush();

        } catch(Exception e) {
            throw e;
        }

    }

    @ResponseBody
    @GetMapping("/api/idol/tts/refresh")
    public List<Long> refreshTTSTable() {
        List<UwasaEntityDTO> list = uwasaEntityService.findAll();
        List<Long> result = new ArrayList<>();

        // 파일 이름 규칙
        // voice_{id}_{nameJa}_{topicNum}.mp3
        list.stream().forEach(dto -> {
            Long id = dto.getId();
            String nameJa = dto.getIdolNameJa();
            Integer topicNum = dto.getTopicNum();

            String fileName = "voice_" + id + "_" + nameJa + "_" + topicNum + ".mp3";

            result.add(uwasaEntityService.updateTTSOnly(id, fileName));

        });

        return result;
    }


    public static void main(String[] args) throws IOException {
//        ClassPathResource res2 = new ClassPathResource("references/tts/");
//        System.out.println(res2);
//        File f = res2.getFile();
        File f = new File(FileSystemView.getFileSystemView().getHomeDirectory() + "/deretopic/resources/tts/");
        System.out.println(f.getAbsolutePath());
        System.out.println(f.isDirectory());
        File[] fs = f.listFiles();
        if(fs.length > 0) {
            for(File e : fs) {
                System.out.println(e.getName());
                String[] parts = e.getName().split("_");
                System.out.println(parts[2] + " : " + parts[3]);
                String[] splitted = parts[3].split("\\.");
                for(String s : splitted) {
                    System.out.println(">> " + s);
                }
                System.out.println(parts[2].equals("島村卯月") + " : " + parts[3].split("\\.")[0].equals("1"));
            }
        }
    }
}
