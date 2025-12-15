package ma.enset.univ_events.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // Indique que cette classe est une classe de configuration Spring
public class SecurityConfig { // Configuration de la sécurité de l'application

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // Swagger autorisé
                .requestMatchers(
                    "/swagger-ui/**",
                    "/swagger-ui.html",
                    "/v3/api-docs/**"
                ).permitAll()

                // API autorisée pour le moment
                .requestMatchers("/api/**").permitAll()

                // le reste protégé
                .anyRequest().authenticated()
            )
            .formLogin();

        return http.build();
    }
}
