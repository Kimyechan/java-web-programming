package com.rubypaper.jdbc.config;

import com.rubypaper.jdbc.util.JDBCConnectionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewBoardConfiguration {

    /*@Bean
    public JDBCConnectionManager getJDBCConnectionManager() {
        JDBCConnectionManager manager = new JDBCConnectionManager();
        manager.setDriverClass("org.h2.Driver");
        manager.setUrl("jdbc:h2:tcp://localhost/~/test");
        manager.setUsername("sa");
        manager.setPassword("");
        return manager;
    }*/
}
