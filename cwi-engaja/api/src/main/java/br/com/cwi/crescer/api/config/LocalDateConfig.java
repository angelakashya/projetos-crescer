package br.com.cwi.crescer.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;

@Configuration
public class LocalDateConfig {

    @Bean
    public Clock clock() {
        return Clock.systemDefaultZone();
    }

}
