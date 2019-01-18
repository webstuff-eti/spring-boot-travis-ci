package br.eti.webstuff.api.context;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

@Data
@Configuration
@PropertySource("classpath:global.properties")
@ConfigurationProperties
public class GlobalProperties {
	
    private int threadPool;
    private String email;
}
