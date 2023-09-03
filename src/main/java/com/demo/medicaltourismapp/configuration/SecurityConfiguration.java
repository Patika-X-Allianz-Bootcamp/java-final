package com.demo.medicaltourismapp.configuration;

import com.demo.medicaltourismapp.database.repository.UserRepository;
import com.demo.medicaltourismapp.util.security.JWTFilter;
import jakarta.servlet.http.HttpServletResponse;
import org.springdoc.core.service.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    @Autowired
    private UserRepository userRepo;
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
            "/doctor/get-all",
            "/doctor/get-all-by-filter",
            "/hospital/get-all",
            "/hospital/get-all-by-filter"
    };

    // users can create an appointment and list hotels, flights, hospitals, and doctors
    private static final String[] USER_AUTH_WHITELIST = {
            "/flight/get-all",
            "/flight/get-all-by-filter",
            "/hotel/get-all",
            "/hotel/get-all-by-filter",
            "/appointment/save"

    };

    // doctor can get hospital's, doctor's, and patient's list and has full access to the appointments
    private static final String[] USER_DOCTOR_WHITELIST = {
            "/patient/get-all",
            "/patient/get-all-by-filter",
            "/appointment",
            "/appointment/**"
    };
    // admin has full access to every area
    private static final String[] USER_ADMIN_WHITELIST = {
            "/doctor",
            "/doctor/**",
            "/hospital",
            "/hospital/**",
            "/patient",
            "/patient/**",
            "/appointment",
            "/appointment/**",
            "/flight",
            "/flight/**",
            "/hotel",
            "/hotel/**"
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
                .requestMatchers(USER_DOCTOR_WHITELIST).hasRole("doctor")
                .requestMatchers(USER_ADMIN_WHITELIST).hasRole("admin")
                .and()

                .userDetailsService((UserDetailsService) uds)
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
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
