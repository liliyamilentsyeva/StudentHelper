package edu.iba.lilya.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

abstract class BaseDAO<T> extends BaseConnection {

    protected void delete(Object key, String table) throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "DELETE FROM " + table + " WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, (String) key);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException(e);
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

    abstract public List<T> loadAll() throws DAOException;

    abstract public T getByKey(Object key) throws DAOException;

    abstract public void add(T bean) throws DAOException;

    abstract public void delete(Object key) throws DAOException;

    abstract public void update(T bean) throws DAOException;
}
