package com.allianz.medicaltourismapp.configuration;

import com.allianz.medicaltourismapp.database.entity.roles.AdminEntity;
import com.allianz.medicaltourismapp.database.entity.roles.HospitalSecretaryEntity;
import com.allianz.medicaltourismapp.database.entity.roles.UserEntity;
import com.allianz.medicaltourismapp.util.securityUtil.JWTFilter;
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

    private final HospitalSecretaryEntity secretaryEntity;
    private final UserEntity userEntity;
    private final AdminEntity adminEntity;

    private final JWTFilter filter;

    private final SecurityService securityService;


    private static final String[] AUTH_WHITELIST = {
            "/auth/",
            "/swagger-ui/",
            "v3/api-docs/",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/",
            "/v3/api-docs/",
            "/api/public/",
            "/api/public/authenticate",
            "/actuator/*",
            "/swagger-ui/",
            "/hospital/filter/*",
            "/hospital",
            "/hotel/filter/*",
            "/flight",
            "/hotel",
            "/flight",
            "/flight/get-all-filter",
            "/flight",
            "/hotel/get-all-filter",
            "/hotel"


    };


    private static final String[] SECRETARY_AUTH_WHITELIST = {
            "/appointment/",
            "/appointment/filter/*",
            "/department",
            "/department/filter/*",
            "/patient",
            "/patient/filter/*",
            "/doctor",
            "/doctor/filter/*"






    };

    private static final String[] USER_AUTH_WHITELIST = {
            "/appointment/",
            "/appointment/filter/*",
            "/department",
            "/department/filter/*",
            "/patient",
            "/patient/filter/*",
            "/doctor",
            "/doctor/filter/*",
            "/ticket",
            "/ticket/filter/*",
            "/admin",
            "/admin/filter/*"
    };

    private static final String[] ADMIN_AUTH_WHITELIST = {
            "/**" // Sadece /admin altındaki yollara erişim izni
    };

    @Autowired
    public SecurityConfiguration(HospitalSecretaryEntity secretaryEntity,UserEntity userEntity, AdminEntity adminEntity, JWTFilter filter, SecurityService securityService) {
        this.secretaryEntity = secretaryEntity;
        this.userEntity = userEntity;
        this.filter = filter;
        this.securityService = securityService;
        this.adminEntity = adminEntity;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        System.out.println("security");
        http.headers().frameOptions().disable();
        http.csrf().disable()
                .httpBasic().disable()
                .cors()
                .configurationSource(request -> {
                    CorsConfiguration configuration = new CorsConfiguration();
                    configuration.setAllowedOrigins(List.of(""));
                    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
                    configuration.setAllowedHeaders(List.of(""));
                    configuration.setExposedHeaders(List.of("Content-Disposition"));
                    return configuration;
                }).and()
                .authorizeHttpRequests()
                .requestMatchers(AUTH_WHITELIST).permitAll()
                .requestMatchers(SECRETARY_AUTH_WHITELIST).hasRole("secretary")
                .requestMatchers(ADMIN_AUTH_WHITELIST).hasRole("admin")
                .requestMatchers(USER_AUTH_WHITELIST).hasRole("user")
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
