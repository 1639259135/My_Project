package bookstore.user.dao;

import bookstore.user.domain.User;
import bookstore.utils.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.Connection;
import java.sql.SQLException;

public class UserDao {

    private String sql = "";

    public  User queryByUsername(String username) throws SQLException {
        Connection connection = DbcpUtil.getConnection();
        User user = new QueryRunner().query(
                connection,
                "select * from user where username =?",
                new BeanHandler<>(User.class),
                username);

        connection.close();
        return user;
    }

    public  void insertUser(User user) throws SQLException {
        QueryRunner qr = new QueryRunner();
        sql = "INSERT INTO user VALUES (?,?,?,?,?,?)";
        Connection conn = DbcpUtil.getConnection();
        qr.insert(conn, sql,new BeanHandler<User>(User.class),
                user.getUid(),user.getUsername(),user.getPassword(),user.getEmail(),user.getCode(),0
        );

        conn.close();

    }

    public User queryByCode(String code) throws SQLException {

        QueryRunner qr = new QueryRunner();
        Connection connection = DbcpUtil.getConnection();
        sql = "select * from user where code =?";
        User user = qr.query(connection, sql, new BeanHandler<>(User.class), code);

        connection.close();
        return user;
    }


    public void alterUser(String code) throws SQLException {
        QueryRunner qr = new QueryRunner();
        sql = "UPDATE user SET state=1 WHERE code=?";
        Connection conn = DbcpUtil.getConnection();
        qr.update(conn,sql,code);

        conn.close();
    }




}
