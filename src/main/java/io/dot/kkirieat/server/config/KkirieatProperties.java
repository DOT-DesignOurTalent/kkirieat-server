package io.dot.kkirieat.server.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "app.kkirieat")
public class KkirieatProperties {
}
