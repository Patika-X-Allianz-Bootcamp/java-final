package com.allianz.meliorator.configuration;

import com.allianz.meliorator.database.repository.UsersRepository;
import com.allianz.meliorator.util_security.JWTFilter;
import com.allianz.meliorator.util_security.SecurityService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import java.util.Arrays;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
    private final UsersRepository usersRepository;
    private final JWTFilter jwtFilter;
    private final SecurityService securityService;

    public SecurityConfiguration(UsersRepository usersRepository, JWTFilter jwtFilter, SecurityService securityService) {
        this.usersRepository = usersRepository;
        this.jwtFilter = jwtFilter;
        this.securityService = securityService;
    }

    private static final String[] AUTH_WHITELIST = {
            "/auth/**",
            "/swagger-ui/**",
            "v3/api-docs/**",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
            "/v3/api-docs/**",
            "/api/public/**",
            "/api/public/authenticate",
            "/actuator/*",
            "/role",
            "/role/**",
            "/swagger-ui/**",
            "airline-company/get-all-filter",
            "airline-company",
            "doctor/get-all-filter",
            "doctor",
            "flight/get-all-filter",
            "flight",
            "hospital/get-all-filter",
            "hospital",
            "hotel/get-all-filter",
            "hotel",
            "room/get-all-filter",
            "room",
            "seat/get-all-filter",
            "seat",
    };


    private static final String[] USER_AUTH_WHITELIST = {
            "/appointment/**",
            "/prescription/get-all-filter",
            "/prescription",

    };

    private static final String[] ADMIN_AUTH_WHITELIST = {
            "/**"
    };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("security");
        http.headers().frameOptions().disable();
        http.csrf().disable()
                .httpBasic().disable()
                .cors()
                .configurationSource(request -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOrigins(List.of("*"));
                    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
                    configuration.setAllowedHeaders(List.of("*"));
                    configuration.setExposedHeaders(List.of("Content-Disposition"));
                    return configuration;
                }).and()
                .authorizeHttpRequests()
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .requestMatchers(USER_AUTH_WHITELIST).hasRole("user")
                .requestMatchers(ADMIN_AUTH_WHITELIST).hasRole("admin")
                .requestMatchers(ADMIN_AUTH_WHITELIST).hasRole("doctor")
                .and()

                .userDetailsService(securityService)
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, authException) ->
                                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
                )
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
}
