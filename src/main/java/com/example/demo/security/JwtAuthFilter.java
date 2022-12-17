package com.example.demo.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {

    private final TokenProvider tokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            // 요청에서 토큰 가져오기
            String token = parseBearerToken(request);
            log.info("Token Filter is running.... - token: {}", token);

            // 토큰 검사하기
            if (token != null && !token.equalsIgnoreCase("null")) {
                // userId가져오기. 위조된 경우 예외가 발생한다.
                String userId = tokenProvider.validateAndGetUserId(token);
                log.info("인증된 user id : {}", userId);

                // 인증 완료!! api서버에서는 SecurityContextHolder에 등록해야 인증된 사용자라고 생각한다.
                AbstractAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userId,
                        null,
                        AuthorityUtils.NO_AUTHORITIES
                );
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContext securityContext = SecurityContextHolder.createEmptyContext();
                securityContext.setAuthentication(authentication);

                SecurityContextHolder.setContext(securityContext);
            }

        } catch (Exception e) {
            log.error("Could not set user authentication in security context", e);
        }

        // 필터체인에 연결한다.
        filterChain.doFilter(request, response);
    }

    private String parseBearerToken(HttpServletRequest request) {
        // Http요청 헤더에서 Bearer 토큰을 가져온다
        String bearerToken = request.getHeader("Authorization");

        // 토큰값을 파싱하여 리턴
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}