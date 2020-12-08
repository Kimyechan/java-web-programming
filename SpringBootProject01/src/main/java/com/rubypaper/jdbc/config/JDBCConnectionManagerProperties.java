package com.rubypaper.jdbc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "board.jdbc")
@Data
public class JDBCConnectionManagerProperties {
    private String driverClass;
    private String url;
    private String username;
    private String password;
}
