package com.maryed.hotel_admin_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(authz -> authz

                        .requestMatchers(
                                "/hotel/hoteles",
                                "/habitacion/habitaciones/**",
                                "/habitacion/**"
                        ).permitAll()


                        .requestMatchers(
                                "/reserva/**",
                                "/cliente/**",
                                "/pago/**",
                                "/consumo/**",
                                "/acompanante/**",
                                "/hotel/crear", "/hotel/actualizar/**", "/hotel/eliminar/**",
                                "/habitacion/crear", "/habitacion/actualizar/**", "/habitacion/eliminar/**"
                        ).hasRole("RECEPCION")

                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails recepcionUser = User.builder()
                .username("recepcion")
                .password(passwordEncoder().encode("password123"))
                .roles("RECEPCION")
                .build();

        UserDetails adminUser = User.builder()
                .username("admin")
                .password(passwordEncoder().encode("admin123"))
                .roles("RECEPCION", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(recepcionUser, adminUser);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}