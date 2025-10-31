package nigglenandu.Student_Management_Crud;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // Marks this class as a Spring configuration
public class GlobalCorsConfig {

    @Bean // Bean is managed by Spring container
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")                // Apply CORS to all endpoints
                        .allowedOrigins("http://localhost:5173") // Allow requests from React frontend
                        .allowedMethods("GET","POST","PUT","DELETE") // Allowed HTTP methods
                        .allowedHeaders("*");               // Allow all headers
            }
        };
    }
}
