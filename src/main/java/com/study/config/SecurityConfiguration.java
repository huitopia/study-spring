package com.study.config;

import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import com.nimbusds.jose.jwk.source.JWKSource;
import com.nimbusds.jose.proc.SecurityContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

@Configuration // 스프링의 구성 클래스임을 나타냄
@EnableMethodSecurity // 애플리케이션에서 특정 메소드에 대한 접근을 제어하고 보안 규칙을 적용 가능
public class SecurityConfiguration {
    @Value("${jwt.public.key}")
    RSAPublicKey key;

    @Value("${jwt.private.key}")
    RSAPrivateKey priv;

    // SecurityFilterChain : 보안 필터 체인 설정
    //  메서드 내에 http 요청에 대한 인증 및 인가 규칙 정의하고, 필요한 보안 구성 설정 가능
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // CSRF 보호를 비활성화하는 설정
        http.csrf(csrf -> csrf.disable());
        // 사용자가 로그인할 때 필요한 폼 기반 인증 설정
        http.formLogin(form -> form.loginPage("/login"));
        // 보안 필터 체인 빌드 : http 요청에 대한 보안 필터의 순서와 설정을 정의하여 보안 작업 구성
        http.oauth2ResourceServer(httpSecurityOAuth2ResourceServerConfigurer -> httpSecurityOAuth2ResourceServerConfigurer.jwt(Customizer.withDefaults()));
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        // 해시값 생성한 객체 반환
        return new BCryptPasswordEncoder();
    }

    @Bean
    JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(this.key).build();
    }

    @Bean
    JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(this.key).privateKey(this.priv).build();
        JWKSource<SecurityContext> jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }


}
