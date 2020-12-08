package com.rubypaper.service;

import com.rubypaper.jdbc.util.JDBCConnectionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

@Service
public class JDBCConnectionManagerRunner implements ApplicationRunner {
    @Autowired
    private JDBCConnectionManager manager;

    public JDBCConnectionManagerRunner() {
        System.out.println("====> JDBCConnectionManagerRunner 생성");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("커넥션 매니저 : " + manager.toString());
    }
}
