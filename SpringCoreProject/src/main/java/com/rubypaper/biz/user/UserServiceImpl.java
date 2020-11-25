package com.rubypaper.biz.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void insertUser(UserVO vo) {
        userDAO.insertUser(vo);
    }

    @Override
    public UserVO getUser(UserVO vo) {
        return userDAO.getUser(vo);
    }
}
