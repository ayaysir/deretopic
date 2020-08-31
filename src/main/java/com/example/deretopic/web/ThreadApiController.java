package com.example.deretopic.web;

import com.example.deretopic.security.CurrentUser;
import com.example.deretopic.security.UserPrincipal;
import com.example.deretopic.service.ThreadEntityService;
import com.example.deretopic.web.dto.ThreadEntityDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/thread")
public class ThreadApiController {
    private final ThreadEntityService threadEntityService;

    @PostMapping
    public Map<String, Object> save(@RequestBody ThreadEntityDTO dto, @CurrentUser UserPrincipal userPrincipal) {
        dto.setAuthorId(userPrincipal.getId());
        Long id = threadEntityService.save(dto);
        Map<String, Object> result = new HashMap<>();
        result.put("status", 200);
        if(id > 0) {
            result.put("status", 201);
        }

        result.put("threadId", id);
        return result;

    }

    @PutMapping
    public Map<String, Object> update(@PathVariable Long id, @RequestBody ThreadEntityDTO dto, @CurrentUser UserPrincipal userPrincipal) {

        return null;
    }

    @DeleteMapping("/{threadId}")
    public Long delete(@PathVariable Long threadId, @CurrentUser UserPrincipal userPrincipal) {
        ThreadEntityDTO dto = threadEntityService.findById(threadId);
        if(userPrincipal.getId().equals(dto.getAuthor().getId())) {
            threadEntityService.delete(threadId);
            return threadId;
        } else {
            return -99l;
        }
    }

    @GetMapping("/{threadName}")
    public List<ThreadEntityDTO> findByThreadNameOrderByDesc(@PathVariable String threadName) {
        return threadEntityService.findByThreadNameOrderByDesc(threadName);
    }

    @GetMapping
    public ThreadEntityDTO findById(Long id) {
        return threadEntityService.findById(id);
    }
}
