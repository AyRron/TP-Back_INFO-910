package back_devops.tp.tpback.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Autoriser les origines localhost sur différents ports
        config.addAllowedOrigin("http://localhost:80"); // Pour les requêtes générales
        config.addAllowedOrigin("http://localhost:3000"); // Pour React
        config.addAllowedOrigin("http://localhost:4200"); // Pour Angular
        config.addAllowedOrigin("http://localhost:8080"); // Pour d'autres applications

        // Autoriser tous les en-têtes et méthodes
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
