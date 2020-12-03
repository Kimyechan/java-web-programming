package com.rubypaper.biz.user;


// DAO(Data Access Object) Ŭ����
public class UserDAOMyBatis {

    private static final String USER_INSERT = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
    private static final String USER_GET = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";

    public void insertUser(UserVO vo) {
        System.out.println("====> MyBatis 기반으로 insertUser 처리");
    }

    public UserVO getUser(UserVO vo) {
        System.out.println("====> MyBatis 기반으로 getUser 처리");
        UserVO user = null;
        return user;
    }
}




