package com.rubypaper.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

// DAO(Data Access Object) Ŭ����
@Repository
//@Primary
public class UserDAOSpring implements UserDAO {
    private final JdbcTemplate spring;

    @Autowired
    public UserDAOSpring(JdbcTemplate spring) {
        this.spring = spring;
    }

    private static final String USER_INSERT = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
    private static final String USER_GET = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";

    @Override
    public void insertUser(UserVO vo) {
        System.out.println("====> Spring 기반으로 insertUser 처리");
        Object[] args = {vo.getId(), vo.getPassword(), vo.getName(), vo.getRole()};
        spring.update(USER_INSERT, args);
    }

    @Override
    public UserVO getUser(UserVO vo) {
        System.out.println("====> Spring 기반으로 getUser 처리");
        Object[] args = {vo.getId(), vo.getPassword()};

        return spring.queryForObject(USER_GET, args,  new UserRowMapper());
    }
}




