package com.allianz.medicaltourism.configuration;


import com.allianz.medicaltourism.database.repository.UserEntityRepository;
import com.allianz.medicaltourism.util.security.JWTFilter;
import com.allianz.medicaltourism.util.security.SecurityService;
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
			"/swagger-ui.html",
			"/v3/api-docs/**",
			"/swagger-ui/**",
	};


	private static final String[] USER_AUTH_WHITELIST = {
			"/flightschedule",
			"/flightschedule/**",
			"/hotel",
			"/hotel/**",
			"/planeseat",
			"/planeseat/**",
			"/plane",
			"/plane/**",
			"/hotelroom",
			"/hotelroom/**",
			"/user",
			"/user/**",
			"/doctor",
			"/doctor/**",
			"/hospital",
			"/hospital/**",
			"/appointment",
			"/appointment/**",
			"/patient",
			"/patient/**"
	};

	private static final String[] ADMIN_AUTH_WHITELIST = {
			"/role",
			"/role/**",
			"/doctor",
			"/doctor/**",
			"/flightschedule",
			"/flightschedule/**",
			"/hotel",
			"/hotel/**",
			"/planeseat",
			"/planeseat/**",
			"/plane",
			"/plane/**",
			"/hotelroom",
			"/hotelroom/**",
			"/user",
			"/user/**",
			"/hospital",
			"/hospital/**",
			"/appointment",
			"/appointment/**",
			"/patient",
			"/patient/**"
	};


	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
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
