package com.example.deretopic.domain.user;

import com.example.deretopic.domain.BaseTimeEntity;
import com.example.deretopic.security.oauth.AuthProvider;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email")
})
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Column(nullable = false)
    private String name;

    @Setter
    @Column(nullable = false)
    private String email;

    @Setter
    private String imageUrl;

    @Setter
    @JsonIgnore
    private String password;

    @Setter
    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;

    @Setter
    private String providerId;

    @Builder
    public User(String name, String email, String imageUrl) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
    }


}