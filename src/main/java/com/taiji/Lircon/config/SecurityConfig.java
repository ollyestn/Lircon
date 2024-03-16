package com.taiji.Lircon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * @Description: 忽略swagger访问权限控制
 * @Version: 1.0
 * 增加SecurityConfig.java，忽略swagger访问权限控制
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final static String ACCOUNT_CLIENT_AUTHORITY = "ADMIN";

    //配置basicauth账号密码
    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager users = new InMemoryUserDetailsManager();
        users.createUser(User.withUsername("aaa")
                .password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("bbb"))
                .authorities(ACCOUNT_CLIENT_AUTHORITY).build());
        return users;
    }
    // 配置不同接口访问权限
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("/**").permitAll())
                .httpBasic(withDefaults())
                .build();
    }
}
