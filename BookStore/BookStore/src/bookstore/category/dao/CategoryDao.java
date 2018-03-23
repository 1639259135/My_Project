package bookstore.category.dao;

import bookstore.book.domain.Book;
import bookstore.utils.DbcpUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoryDao {

    public List queryAll() throws SQLException {
        Connection connection = DbcpUtil.getConnection();
        List<Book> books = new QueryRunner().query(
                connection,
                "select * from book",
                new BeanListHandler<>(Book.class));

        connection.close();
        return books;
    }


}
