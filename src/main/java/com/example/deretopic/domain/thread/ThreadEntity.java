package com.example.deretopic.domain.thread;

import com.example.deretopic.domain.BaseTimeEntity;
import com.example.deretopic.domain.user.User;
import com.example.deretopic.web.dto.ThreadEntityDTO;
import lombok.*;

import javax.persistence.*;

@Getter
@ToString
@NoArgsConstructor  // 파라미터가 없는 생성자를 만든다.
@Entity
public class ThreadEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String threadName;
    private String category;

    // @Column: 선언하지 않더라도 클래스의 필드는 모두 컬럼이 됨
    // 추가 변경 옵션이 필요한 경우 지정

    // 제목 없음

   @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "users_id")
    @Setter
    private User author;

    @Builder
    public ThreadEntity(String threadName, String category, String content, User author) {
        this.threadName = threadName;
        this.category = category;
        this.content = content;
        this.author = author;
    }

    public void update(ThreadEntityDTO dto) {
        // threadName, author 변경할 수 없다.
        this.category = dto.getCategory();
        this.content = dto.getContent();

    }
}


