package com.rubypaper.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.rubypaper.biz.common.JDBCUtil;
import org.springframework.stereotype.Repository;

// DAO(Data Access Object) Ŭ����
@Repository
public class UserDAO {
    // JDBC ���� ���� ����
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    // USERS ���̺� ���� SQL ��ɾ�
    private static final String USER_INSERT = "INSERT INTO USERS VALUES(?, ?, ?, ?)";
    private static final String USER_GET = "SELECT * FROM USERS WHERE ID=? AND PASSWORD=?";

    // USERS ���̺� ���� CRUD ����� �޼ҵ�
    // ȸ�� ���
    public void insertUser(UserVO vo) {
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_INSERT);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            stmt.setString(3, vo.getName());
            stmt.setString(4, vo.getRole());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(stmt, conn);
        }
    }

    // ȸ�� �� ��ȸ
    public UserVO getUser(UserVO vo) {
        UserVO user = null;
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(USER_GET);
            stmt.setString(1, vo.getId());
            stmt.setString(2, vo.getPassword());
            rs = stmt.executeQuery();
            if (rs.next()) {
                // �˻� ��� �� ���� UserVO ��ü�� �����Ѵ�.
                user = new UserVO();
                user.setId(rs.getString("ID"));
                user.setPassword(rs.getString("PASSWORD"));
                user.setName(rs.getString("NAME"));
                user.setRole(rs.getString("ROLE"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.close(rs, stmt, conn);
        }
        return user;
    }
}




