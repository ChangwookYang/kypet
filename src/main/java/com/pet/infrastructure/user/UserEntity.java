package com.pet.infrastructure.user;

import com.pet.application.domain.user.Role;
import com.pet.application.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String refreshToken;
    private LocalDateTime joinDt;

    @Enumerated(EnumType.STRING)
    private Role role;

    public void updateRefreshToken(String updateRefreshToken) {
        this.refreshToken = updateRefreshToken;
    }

    @Builder
    public UserEntity(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.joinDt = LocalDateTime.now();
        this.role = Role.USER;
    }

    public User toUser() {
        return User.builder()
                .userId(this.id)
                .email(this.email)
                .password(this.password)
                .nickname(this.nickname)
                .role(this.role)
                .build();
    }
}
