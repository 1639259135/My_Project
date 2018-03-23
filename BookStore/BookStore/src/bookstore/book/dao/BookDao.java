package bookstore.book.dao;

import bookstore.book.domain.Book;
import bookstore.utils.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BookDao {

    public Book queryByBid(String bid) throws SQLException {
        Connection connection = DbcpUtil.getConnection();
        Book book = new QueryRunner().query(
                connection,
                "select * from book where bid=?",
                new BeanHandler<Book>(Book.class),
                bid);
        connection.close();
        return book;
    }

    public List queryByCategory(String cname) throws SQLException {
        Connection connection = DbcpUtil.getConnection();
        List<Book> list = new QueryRunner().query(
                connection,
                "SELECT * FROM book b INNER JOIN category c ON b.cid = c.cid WHERE cname=?",
                new BeanListHandler<Book>(Book.class),
                cname);

        connection.close();
        return list;
    }




}
