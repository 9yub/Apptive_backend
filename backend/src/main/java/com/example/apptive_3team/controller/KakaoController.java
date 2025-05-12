package com.example.apptive_3team.controller;

import com.example.apptive_3team.entity.User;
import com.example.apptive_3team.service.KakaoService;
import com.example.apptive_3team.util.JwtUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/auth/kakao")
@AllArgsConstructor
public class KakaoController {

    private final KakaoService kakaoService;
    private final JwtUtil jwtUtil;

    // 카카오 사용자 인증
    @PostMapping("/login")
    public ResponseEntity<?> kakaoLogin(@RequestBody Map<String, String> request) {
        try {
            String accessToken = request.get("accessToken");
            boolean agree = Boolean.parseBoolean(request.get("agree")); // 알림 허용 여부

            User user = kakaoService.loginOrRegister(accessToken, agree);
            String jwt_token = jwtUtil.createToken(user.getProviderId());

            return ResponseEntity.ok(Map.of(
                    "token", jwt_token,
                    "user", Map.of(
                            "id", user.getId(),
                            "name", user.getName()
                    )
            ));

        } catch (Exception e) {
            System.out.println("❗ 예외 발생: " + e.getClass().getName() + " - " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", e.getMessage()));
        }
    }

}