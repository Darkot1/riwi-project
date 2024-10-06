package com.riwi.proyect.infrastructure.security;

import com.riwi.proyect.domain.enums.RoleEnum;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
@AllArgsConstructor
public class SecurityConfig {

    private final JwtFilter jwtFilter; // Inyección de JwtFilter
    private final AuthenticationProvider authenticationProvider; // Inyección de AuthenticationProvider

    private final String[] PUBLIC_ENDPOINTS = {
            "/auth/login",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    };

    private final String[] ADMIN_ENDPOINTS = {
            "/users/register/user",
            "/users/readAll",
            "/users/{id}",
            "/users/register/admin",
            "/users/delete/**",
            "/projects/**",
            "/tasks/**"
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable) // Deshabilitar CSRF ya que se usa JWT
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(PUBLIC_ENDPOINTS).permitAll() // Permitir acceso a endpoints públicos
                        .requestMatchers(ADMIN_ENDPOINTS).hasAuthority("ROLE_ADMIN")// Solo ADMIN puede acceder a estos endpoints
                        .anyRequest().authenticated() // Cualquier otra solicitud requiere autenticación
                )
                .authenticationProvider(authenticationProvider) // Configurar el proveedor de autenticación
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // Usar sesión sin estado (sin almacenamiento de sesión)
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // Añadir el filtro JWT antes de la autenticación de usuario y contraseña
                .build();
    }
}
