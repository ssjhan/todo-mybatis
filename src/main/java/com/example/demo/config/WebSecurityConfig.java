package com.example.demo.config;

import com.example.demo.security.JwtAuthFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.filter.CorsFilter;

//인증 및 인가처리 설정
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;


    //사용자의 패스워드를 암호화하는 라이브러리
    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        // http 시큐리티 빌더
        http.cors()
                .and()
                .csrf().disable() // 기본cors설정과 csrf방어설정을 해제한다.
                .httpBasic().disable() // jwt를 사용하므로 basic인증을 해제한다.
                // 세션기반 인증이 아님을 선언
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // /경로와 /auth로 시작하는 경로는 인증안해도됨
                .authorizeRequests().antMatchers("/", "/auth/**").permitAll()
                // 그 외의 경로는 모두 인증을 거쳐야 함
                .anyRequest().authenticated();

        // 토큰 인증 필터 등록
        http.addFilterAfter(
                jwtAuthFilter,
                CorsFilter.class // import주의!
        );

        return http.build();
    }


}
