package edu.iba.lilya.DAO;

import edu.iba.lilya.bean.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lilya on 02.12.16.
 */
public class UserDAO extends BaseDAO<UserBean> {

    @Override
    public List<UserBean> loadAll() throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM USERS";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            List<UserBean> userList = new ArrayList<>();
            while (set.next()) {
                UserBean userBean = new UserBean();
                userBean.setUser(set.getString(1));
                userBean.setPassword(set.getString(2));
                userBean.setRole(set.getString(3));
                userList.add(userBean);
            }
            return userList;
        }
        catch (SQLException e) {
            throw new DAOException(e);
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public UserBean getByKey(Object name) throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM USERS WHERE USER = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, (String)name);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                UserBean user = new UserBean();
                user.setUser(set.getString(1));
                user.setPassword(set.getString(2));
                user.setRole(set.getString(3));
                return user;
            }
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
        return null;
    }

    @Override
    public void add(UserBean bean) throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "INSERT INTO USERS VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bean.getUser());
            statement.setString(2, bean.getPassword());
            statement.setString(3, bean.getRole());
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

    @Override
    public void delete(Object key) {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "DELETE FROM USERS WHERE USER = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, (String) key);
            statement.executeUpdate();
        } catch (SQLException e) {
            try {
                throw new DAOException(e);
            } catch (DAOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        } catch (DAOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if (connection != null)
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        }
    }

    @Override
    public void update(UserBean bean) throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "UPDATE USERS SET USER = ?, PASS = ?, ROLE = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bean.getUser());
            statement.setString(2, bean.getPassword());
            statement.setString(3, bean.getRole());
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
}
