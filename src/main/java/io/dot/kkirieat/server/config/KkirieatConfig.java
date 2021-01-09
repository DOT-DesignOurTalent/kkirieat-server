package io.dot.kkirieat.server.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({KkirieatProperties.class})
public class KkirieatConfig {
    @Bean
    public KkirieatProperties kkirieatProperties() {
        return new KkirieatProperties();
    }
}
