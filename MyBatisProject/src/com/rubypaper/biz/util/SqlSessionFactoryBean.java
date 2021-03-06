package com.rubypaper.biz.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class SqlSessionFactoryBean {
    private static SqlSessionFactory sessionFactory;

    static {
        try {
            if (sessionFactory == null) {
                // MyBatis 컨테이너 공장을 메인 환경 설정 파일(sql-map-config.xml)을 읽어서 생성한다.
                Reader reader = Resources.getResourceAsReader("sql-map-config.xml");
                sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSessionInstance() {
        // 컨테이너 공장(SqlSessionFactory)에서 MyBatis 컨테이너 하나를 생성하여 리턴한다
        return sessionFactory.openSession();
    }
}
