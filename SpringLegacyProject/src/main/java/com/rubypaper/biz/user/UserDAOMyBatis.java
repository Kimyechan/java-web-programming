package com.rubypaper.biz.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class UserDAOMyBatis implements UserDAO {

    @Autowired
    private SqlSessionTemplate myBatis;

    // 회원 등록
    public void insertUser(UserVO vo) {
        System.out.println("===> MyBatis 기반으로 insertUser() 기능 처리");
        myBatis.insert("UserDAO.insertUser", vo);
    }

    // 회원 상세 조회
    public UserVO getUser(UserVO vo) {
        System.out.println("===> MyBatis 기반으로 getUser() 기능 처리");
        return (UserVO) myBatis.selectOne("UserDAO.getUser", vo);
    }
}