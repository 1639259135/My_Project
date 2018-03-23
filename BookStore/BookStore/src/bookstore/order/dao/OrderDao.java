package bookstore.order.dao;

import bookstore.order.domain.Order;
import bookstore.utils.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderDao {

    private String sql = "";

    public List queryAll(String uid) throws SQLException {
        Connection connection = DbcpUtil.getConnection();
        List<Order> orders = new QueryRunner().query(
                connection,
                "select * from orders where uid=?",
                new BeanListHandler<Order>(Order.class),
                uid);

        connection.close();
        return orders;
    }


    public Order queryByOid(String oid) throws SQLException {

        Connection connection = DbcpUtil.getConnection();
        Order order = new QueryRunner().query(
                connection,
                "select * from orders where oid=?",
                new BeanHandler<Order>(Order.class),
                oid);

        connection.close();
        return order;
    }


    public void insertOrder(Order order) throws SQLException {

        QueryRunner qr = new QueryRunner();
        sql = "INSERT INTO user VALUES (?,?,?,?,?,?)";
        Connection conn = DbcpUtil.getConnection();
        qr.insert(conn, sql,new BeanHandler<Order>(Order.class),
                order.getOid(),order.getOrderTime(),order.getPrice(),order.getState(),order.getUid(),order.getAddress()
        );

        conn.close();
    }


    public void removeOrder(String oid) throws SQLException {

        QueryRunner qr = new QueryRunner();
        Connection connection = DbcpUtil.getConnection();
        sql = "DELETE FROM orders WHERE oid=?";
        qr.update(connection,sql,oid);

        connection.close();

    }


    public void alterOrder(String oid,String address) throws SQLException {

        QueryRunner qr = new QueryRunner();
        sql = "update orders set state=1,address=? where oid=?";
        Connection connection = DbcpUtil.getConnection();
        qr.update(connection,sql,oid,address,oid);

        connection.close();
    }


}
