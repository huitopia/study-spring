package com.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    // BCryptPasswordEncoder : 사용자의 비밀번호 해시화
    private final BCryptPasswordEncoder bcrypt;

    @Override
    // loadUserByUsername : Spring Security 가 사용자를 로드하는 방법 정의
    public UserDetails loadUserByUsername(
            String username
    ) throws UsernameNotFoundException {
        if (username.equals("h1")) {
            String encoded = bcrypt.encode("hi");
            return new User("h1", encoded, List.of(
                    new SimpleGrantedAuthority("user")
            ));
        } else if (username.equals("h2")) {
            String encoded = bcrypt.encode("hii");
            return new User("h2", encoded,
                    List.of(
                            // SimpleGrantedAuthority : 사용자 권한 부여
                            new SimpleGrantedAuthority("admin"),
                            new SimpleGrantedAuthority("user")
                    )
            );
        } else {
            throw new UsernameNotFoundException(username + " not found");
        }
    }
}