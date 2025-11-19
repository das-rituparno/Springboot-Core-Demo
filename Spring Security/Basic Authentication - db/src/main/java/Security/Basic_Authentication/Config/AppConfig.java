package Security.Basic_Authentication.Config;

import Security.Basic_Authentication.Service.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppConfig {
    @Autowired
    UserAuthService userAuthService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/reg",
                                "/h2-console/**",
                                "/api/hi").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable()) // H2 needs CSRF disabled
                .headers(headers -> headers.frameOptions(frame -> frame.disable())) // H2 needs this for frames
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
