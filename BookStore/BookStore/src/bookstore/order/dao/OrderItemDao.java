package bookstore.order.dao;

import bookstore.order.domain.OrderItem;
import bookstore.utils.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class OrderItemDao {

    public List queryByOid(String oid) throws SQLException {

        Connection connection = DbcpUtil.getConnection();
        List<OrderItem> list = new QueryRunner().query(
                connection,
                "select * from orderitem where oid=?",
                new BeanListHandler<OrderItem>(OrderItem.class),
                oid);

        connection.close();
        return list;
    }


    public void insertOrderItem(OrderItem orderItem) throws SQLException {

        QueryRunner qr = new QueryRunner();
        String sql = "insert into orderitem values(?,?,?,?,?)";
        Connection conn = DbcpUtil.getConnection();
        qr.insert(conn,sql,new BeanHandler<OrderItem>(OrderItem.class)
                ,orderItem.getIid(),orderItem.getCount(),orderItem.getSubtotal(),orderItem.getOid(),orderItem.getBid()
        );
        conn.close();

    }


    public void deleteOrderItemByOid(String oid) throws SQLException {

        QueryRunner qr = new QueryRunner();
        String sql = "delete from orderitem where oid=?";
        Connection conn = DbcpUtil.getConnection();
        qr.insert(conn,sql,new BeanHandler<OrderItem>(OrderItem.class), oid);

        conn.close();
    }



}
