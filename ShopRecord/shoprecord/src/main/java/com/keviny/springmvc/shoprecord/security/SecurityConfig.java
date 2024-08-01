package com.keviny.springmvc.shoprecord.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails kevin = User.builder()
                .username("kevin")
                .password("{noop}kevin")
                .roles("ADMIN", "USER")
                .build();

        UserDetails guest = User.builder()
                .username("user")
                .password("{noop}user")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(kevin, guest);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                configurer
                        .anyRequest().authenticated() // any request to the app must be authenticated
                )
                .formLogin(form ->
                        form
                                // show our custom form at request mapping
                                .loginPage("/showLoginPage")

                                // login form should POST data to this URL for processing (check user id and password)
                                // no controller request mapping required for the processing URL
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll() // allow everyone to see login page
                )
                .logout(logout -> logout.permitAll()
                        );

        return http.build();
    }
}
