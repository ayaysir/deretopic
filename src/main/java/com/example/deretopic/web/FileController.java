package com.example.deretopic.web;

import com.example.deretopic.service.UwasaEntityService;
import com.example.deretopic.util.FileIOUtil;
import com.example.deretopic.web.dto.UwasaEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class FileController {

    private final UwasaEntityService uwasaEntityService;

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
        if (fs.length > 0) {
            for (File e : fs) {
                System.out.println(e.getName());
                String[] parts = e.getName().split("_");
                System.out.println(parts[2] + " : " + parts[3]);
                String[] splitted = parts[3].split("\\.");
                for (String s : splitted) {
                    System.out.println(">> " + s);
                }
                System.out.println(parts[2].equals("島村卯月") + " : " + parts[3].split("\\.")[0].equals("1"));
            }
        }
    }
}
