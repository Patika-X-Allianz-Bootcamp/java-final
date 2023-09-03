package com.burakcanciftci.healthtourism.configuration;

import com.burakcanciftci.healthtourism.database.repository.UserEntityRepository;
import com.burakcanciftci.healthtourism.util.security.JWTFilter;
import com.burakcanciftci.healthtourism.util.security.SecurityService;
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
            "/swagger-ui/**"
    };

    private static final String[] ADMIN_AUTH_WHITELIST = {
            "/**" // to access all
    };

    private static final String[] CUSTOMER_AUTH_WHITELIST = {
            "/airport",
            "/airport/**",
            "/hospital",
            "/hospital/**",
            "/examination",
            "/examination/**",
            "/flight",
            "/flight/**",
            "/hotel",
            "/hotel/**",
            "/hotel-room",
            "/hotel-room/**",
            "/medical-department",
            "/medical-department/**",
            "/plane",
            "/plane/**",
            "/plane-seat",
            "/plane-seat/**",
            "/room-reservation",
            "/room-reservation/**",
            "/seat-reservation",
            "/seat-reservation/**",
            "/travel-plan",
            "/trvel-plan/**",
            "/customer",
            "/customer/*",
    };

    private static final String[] DOCTOR_AUTH_WHITELIST = {
            "/examination-card",
            "/examination-card/*",
            "/examination",
            "/examination/*",
            "/hospital",
            "/hospital/*",
            "/medical-department",
            "/medical-department/*",
            "/doctor",
            "/doctor/*",
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
                .requestMatchers(ADMIN_AUTH_WHITELIST).hasRole("admin")
                .requestMatchers(DOCTOR_AUTH_WHITELIST).hasRole("doctor")
                .requestMatchers(CUSTOMER_AUTH_WHITELIST).hasRole("customer")

                .and()

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