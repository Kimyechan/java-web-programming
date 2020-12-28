package com.fastcampus.todo.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TodoTest {
    @Test
    void test() {
        Todo toDo = new Todo(1L, "할일");
        System.out.println(toDo);
    }

    @Test
    void equalsAndHashCode() {
        Todo todo1 = new Todo(1L ,"할일");
        Todo todo2 = new Todo(2L , "할일");

        System.out.println(todo1 == todo2);
        System.out.println(todo1.equals(todo2));
        System.out.println(todo1.hashCode());
        System.out.println(todo2.hashCode());

        Map<Todo, String> map = new HashMap<>();
        map.put(todo1, todo1.getTitle());
        map.put(todo2, todo2.getTitle());

        Todo todo3 = new Todo(1L, "할일");
        System.out.println(todo3.hashCode());
        System.out.println(map);
        System.out.println(map.get(todo3));
//        assertThat(toDo1).isEqualTo(toDo2);
    }

    @Test
    public void equalsAndHashCode1() {
        // hashcode : 같은 객체를 의미함
        // equals : 같은 값을 가지고 있다는 의미
        // == : 같은 주소값을 가지고 있다는 의미 -> Singleton String bean (Immutable)
        User user1 = new User(1L, "martin", "martin@fastcampus.com");
        User user2 = new User(2L, "martin", "martin@fastcampus.com");

        System.out.println(user1.hashCode());
        System.out.println(user2.hashCode());
        System.out.println(user1 == user2);
        System.out.println(user1.equals(user2));

        Map<User, String> map = new HashMap<>();
        map.put(user1, user1.getName());

        System.out.println(map);
        System.out.println("map.get(user1) : " + map.get(user2));
    }

    @Test
    public void equalsAndHashCode2() {
        String str1 = "abc";
        String str2 = new String("abc");
        String str3 = String.valueOf("abc");
        String str4 = "abc"; // String Pool의 값을 사용
        String str5 = "abc".toString();

        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        System.out.println(str3.hashCode());
        System.out.println(str4.hashCode());
        System.out.println(str5.hashCode());

        System.out.println(str1.equals(str2));
        System.out.println(str1.equals(str3));
        System.out.println(str1.equals(str4));
        System.out.println(str1.equals(str5));

        System.out.println(str1 == str2); // 이것만 false
        System.out.println(str1 == str3);
        System.out.println(str1 == str4);
        System.out.println(str1 == str5);
    }

    @Test
    public void rest() {
        // get : Read 자원의 조회 (SELECT)
        // post : Create 생성 (Insert)
        // patch : Update 수정 -> 소규모 수정
        // put : Update 수정 -> 전폭 수정, 대규모 수정
        // delete : Delete 삭제
        // head
        // option

        // Resource -> API Call 을 통해서 사용하게 될 Domain -> URI
            // Response Body
        // Verb -> Domain 에 어떤 행위를 할거냐 -> Http Method
            // Http Status
    }

    @Test
    public void controller() {
        // Presentation Layer
        // Application Layer (Service Layer)
        // Persistence Layer
    }
}