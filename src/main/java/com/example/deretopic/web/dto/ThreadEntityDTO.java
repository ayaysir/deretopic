package com.example.deretopic.web.dto;

import com.example.deretopic.domain.thread.ThreadEntity;
import com.example.deretopic.domain.user.User;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@ToString
public class ThreadEntityDTO {
    private Long id;

    private String threadName;
    private String category;

    // @Column: 선언하지 않더라도 클래스의 필드는 모두 컬럼이 됨
    // 추가 변경 옵션이 필요한 경우 지정

    // 제목 없음

    private String content;

    @Setter
    private Long authorId;

    private User author;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    public ThreadEntity toEntity() {
        return ThreadEntity.builder()
                .category(category)
                .content(content)
                .threadName(threadName)
                .build();
    }


    @Builder
    public ThreadEntityDTO(Long id, String threadName, String category, String content, Long authorId, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.id = id;
        this.threadName = threadName;
        this.category = category;
        this.content = content;
        this.authorId = authorId;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public ThreadEntityDTO(ThreadEntity entity) {
        this.id = entity.getId();
        this.author = entity.getAuthor();
        this.content = entity.getContent();
        this.category = entity.getCategory();
        this.threadName = entity.getThreadName();
        this.createdDate = entity.getCreatedDate();
        this.modifiedDate = entity.getModifiedDate();
    }
}
