package com.fastcampus.todo.concept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

/**
 * SOLID : 객체 지향의 5원칙 -> 결론 : 높은 응집력, 느슨한 결합
 * SRP : Single Responsibility Principle, 단일 책임 원칙, 하나의 모듈은 하나의 역할을 해야한다
 * OCP : Open Close Principle, 확장에는 열려있고 변경에는 닫혀있다
 * LSP: 리스코프 치환원칙, 서브타입은 상위타입으로 치환이 가능해야한다, 잘못된 추상화를 하지 않아야한다
 * ISP : 인터페이스 분리의 원칙
 * DIP : Dependency inversion principle, 제어의 역전 원칙, 추상화에 의존해야지 구체화에 의존하면 안된다.
 */
// SRP
public class SolidService {
    public String getUserName(){
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String userName = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql:localhost", "app", "app_pw");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from user order by id asc limit 1");

            if (resultSet.next()) {
                userName = resultSet.getString("user_name");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {

        }

        return userName;
    }

    private UserRepository userRepository;

    public String getUserName1() {
        return userRepository.findFirstOrderByIdAsc();
    }

    public class UserRepository {
        public String findFirstOrderByIdAsc() {
            return null;
        }
    }
}

// OCP
class ParisBaquetRecipt {
    public void print(long price, long sktDiscount, long happyconDiscountPrice) {
        System.out.println("총액: " + price);
        System.out.println("할인액: " + sktDiscount);
        System.out.println("해피콘 할인액: " + happyconDiscountPrice);
    }

    public void print(List<Price> priceList) {
        for (Price price: priceList) {
            price.print();
        }
    }
    interface Price {
        void print();
    }

    class SupplyPrice implements Price{
        private long price;

        @Override
        public void print() {
            System.out.println("총액: " + price);
        }
    }

    class SktPrice implements Price {
        private long price;


        @Override
        public void print() {
            System.out.println("통신사 할인액: " + price);
        }
    }

    class HappyconPrice implements Price {
        private String price;

        @Override
        public void print() {
            System.out.println("해피콘 할인액: " + price);
        }
    }
}

// LSP
class Rectangle{
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}

class Square extends Rectangle {
    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }
}

class ShapeService {
    public void drawRectangle() {
        Rectangle rectangle = new Square();
        rectangle.setHeight(5);
        rectangle.setWidth(3);

        System.out.println(rectangle.width);
        System.out.println(rectangle.height);
        System.out.println(rectangle.getClass());
    }
}

// ISP
//class PaymentService implements Payment{
class PaymentService implements CardPayment, MoneyPayment, GifticonPayment {
    @Override
    public void payByCard() {
        System.out.println("카드결제");
    }

    @Override
    public void payByMoney() {
        System.out.println("현금결제");
    }

    @Override
    public void payByGifticon() {
        System.out.println("기프티콘 결제");
    }
}

//class OnlinePaymentService implements Payment {
class OnlinePaymentService implements CardPayment, MoneyPayment, GifticonPayment {
    @Override
    public void payByCard() {
        System.out.println("카드 결제");
    }

    @Override
    public void payByMoney() { // -> 잘 못 만듬
        throw new RuntimeException("온라인에서는 현금으로 결제할 수 없습니다");
    }

    @Override
    public void payByGifticon() {
        System.out.println("기프티콘 결제");
    }
}

interface Payment {
    void payByCard();
    void payByMoney();
    void payByGifticon();
}

interface CardPayment{
    void payByCard();
}

interface MoneyPayment{
    void payByMoney();
}

interface GifticonPayment{
    void payByGifticon();
}

// DIP
class UsersService {
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName() {
        return userRepository.getUserName();
    }
}

interface UserRepository {
    String getUserName();
}

class DaumUserRepository implements UserRepository{
    public String getUserName() {
        return "daumUser";
    }
}

class NaverUserRepository implements UserRepository{
    public String getUserName() {
        return "NaverUser";
    }
}
