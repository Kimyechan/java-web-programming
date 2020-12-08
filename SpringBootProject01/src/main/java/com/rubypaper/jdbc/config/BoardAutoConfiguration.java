package com.rubypaper.jdbc.config;

import com.rubypaper.jdbc.util.JDBCConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BoardAutoConfiguration {

    @Bean
    public JDBCConnectionManager getJDBCConnectionManager() {
        JDBCConnectionManager manager = new JDBCConnectionManager();
        manager.setDriverClass("oracle.jdbc.driver.OracleDriver");
        manager.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
        manager.setUsername("hr");
        manager.setPassword("hr");
        return manager;
    }
}
