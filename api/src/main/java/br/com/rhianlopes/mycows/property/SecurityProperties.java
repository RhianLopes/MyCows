package br.com.rhianlopes.mycows.property;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@Accessors(chain = true)
@ConfigurationProperties(value = "security")
public class SecurityProperties {

    private JwtProperties jwt;

    private PublicProperties publicLink;

    @Data
    @Accessors(chain = true)
    public static class JwtProperties {
        private String security;
        private Long expiration;
    }

    @Data
    @Accessors(chain = true)
    public static class PublicProperties {
        private String path;
    }
}
