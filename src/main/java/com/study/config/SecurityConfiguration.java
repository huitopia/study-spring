package com.study.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 스프링의 구성 클래스임을 나타냄
@EnableMethodSecurity // 애플리케이션에서 특정 메소드에 대한 접근을 제어하고 보안 규칙을 적용 가능
public class SecurityConfiguration {
    // SecurityFilterChain : 보안 필터 체인 설정
    //  메서드 내에 http 요청에 대한 인증 및 인가 규칙 정의하고, 필요한 보안 구성 설정 가능
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // CSRF 보호를 비활성화하는 설정
        http.csrf(csrf -> csrf.disable());
        // 사용자가 로그인할 때 필요한 폼 기반 인증 설정
        http.formLogin(form -> form.loginPage("/login"));
        // 보안 필터 체인 빌드 : http 요청에 대한 보안 필터의 순서와 설정을 정의하여 보안 작업 구성
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 해시값 생성한 객체 반환
        return new BCryptPasswordEncoder();
    }
}
