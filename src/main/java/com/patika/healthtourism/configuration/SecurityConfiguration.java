package com.patika.healthtourism.configuration;

import com.patika.healthtourism.database.repository.UserEntityRepository;
import com.patika.healthtourism.util.security.JWTFilter;
import com.patika.healthtourism.util.security.SecurityService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

import static javax.management.Query.and;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserEntityRepository userRepo;
    @Autowired
    private JWTFilter filter;
    @Autowired
    private SecurityService uds;



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
            "/swagger-ui/**",
            "/doctor/get-all-filter",
            "/flight/get-all-filter",
            "/hospital/get-all-filter",
            "/hotel/get-all-filter"

    };
    private static final String[] DOCTOR_AUTH_WHITELIST = {
            "/examination",
            "/examination/**",
    };

    private static final String[] ADMIN_AUTH_WHITELIST = {
            "/doctor",
            "/doctor/**",
            "/flight",
            "/flight/**",
            "/hospital",
            "/hospital/**",
            "/hotel",
            "/hotel/**",
            "/appointment/get-all-filter",
            "/examination/get-all-filter",
            "/travelPlan/get-all-filter"
    };

    private static final String[] USER_AUTH_WHITELIST = {
            "/patient",
            "/patient/**",
            "/appointment",
            "/appointment/**",
            "/travelPlan",
            "/travelPlan/**"
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
                .authorizeHttpRequests(
                        authorize -> {
                            authorize
                                    .requestMatchers(AUTH_WHITELIST).permitAll()
                                    .requestMatchers(USER_AUTH_WHITELIST).hasRole("USER")
                                    .requestMatchers(DOCTOR_AUTH_WHITELIST).hasRole("DOCTOR")
                                    .requestMatchers(ADMIN_AUTH_WHITELIST).hasRole("ADMIN");

                        }
                );

                http
                        .userDetailsService(uds)
                .exceptionHandling()
                .authenticationEntryPoint(
                        (request, response, authException) ->
                                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized")
                )
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);


        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

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