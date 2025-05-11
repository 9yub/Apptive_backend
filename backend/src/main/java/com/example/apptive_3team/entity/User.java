package com.example.apptive_3team.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String providerId;

    @Enumerated(EnumType.STRING) // DB에 ENUM 값으로 저장될 때, String 형태로 저장됨
    private ProviderType providerType;

    private String name;
    private Double latitude;
    private Double longitude;
    private Boolean allow_notification;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    // Enum 타입을 정의
    public enum ProviderType {
        GOOGLE,
        KAKAO
    }
}