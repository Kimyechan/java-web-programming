package com.fastcampus.todo.concept;

import java.util.ArrayList;
import java.util.List;

public class NullSafeService {

}

class UserService{
    private UserRepository1 userRepository = new UserRepository1();

    public User getUser() {
        User user = userRepository.getUser();

        if (user != null) {
            return user;
        } else {
            return User.emptyObject();
        }
    }

    public List<User> getUsers(String name) {
        String str = "test" + "string" + "!!!"; // -> 문자열 여러개 사용, 최신에는 StringBuilder로 변경한다
        // Immutable, Singleton
        String str2 = "test"; // -> 동일한 객체 반환

        StringBuilder sb = new StringBuilder(); // 단일 스레드
        sb.append("test")
                .append("string")
                .append("!!!")
                .toString();

        StringBuffer sf = new StringBuffer(); // 멀티 스레드 -> Thread Safe

        List<User> users = new ArrayList<>();

        if(name != null) {
            users.add(new User(name));
        }

        return users;
    }
}

class UserViewService {
    private UserService userService = new UserService();

    public String getUserNameLogined() {
        String user = userService.getUser().getUserName();
        return user;
    }

    public List<String> getUserNamesLogined() {
        List<User> users = userService.getUsers("test");

        List<String> userNames = new ArrayList<>();

        for (User user : users) {
            userNames.add(user.getUserName());
        }
        return userNames;
    }
}

class UserRepository1{
    public User getUser() {
        return new User("test");
    }
}
class User {
    private String userName;

    public User(String name) {
        this.userName = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public static User emptyObject() {
        User user = new User("test");
        user.setUserName("유저 없음");
        return user;
    }
}