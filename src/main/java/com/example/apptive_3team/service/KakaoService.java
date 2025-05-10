package com.example.apptive_3team.service;

import com.example.apptive_3team.client.KakaoApiClient;
import com.example.apptive_3team.entity.User;
import com.example.apptive_3team.dto.KakaoUserResponse;
import com.example.apptive_3team.repository.KakaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class KakaoService {
    private final KakaoApiClient kakaoApiClient;
    private final KakaoRepository kakaoRepository;

    public User loginOrRegister(String token, boolean agree) {
        // 1. DTO로 받기
        KakaoUserResponse kakaoData = kakaoApiClient.getUserInfo(token);

        // 2. ID 추출
        String providerId = String.valueOf(kakaoData.id());

        // 3. nickname 추출 (Map<String, Object>에서 캐스팅)
        Map<String, Object> properties = kakaoData.properties();
        String name = properties != null
                ? (String) properties.getOrDefault("nickname", "카카오사용자")
                : "카카오사용자";

        // 4. 기존 유저 확인 및 신규 가입
        return kakaoRepository.findByProviderId(providerId)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setProviderId(providerId);
                    newUser.setProviderType(User.ProviderType.KAKAO);
                    newUser.setName(name);
                    newUser.setAllow_notification(agree);
                    newUser.setCreatedAt(LocalDateTime.now());
                    return kakaoRepository.save(newUser);
                });
    }
}
