package edu.iba.lilya.DAO;

import edu.iba.lilya.bean.GroupBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lilya on 01.12.16.
 */
public class GroupDAO extends BaseDAO<GroupBean> {
    @Override
    public List<GroupBean> loadAll() throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM GROUPS";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            List<GroupBean> groupsList = new ArrayList<>();
            while (set.next()) {
                GroupBean groupBean = new GroupBean();
                groupBean.setGroupNumber(set.getString(1));
                groupBean.setAvgMark(set.getFloat(2));
                groupsList.add(groupBean);
            }
            return groupsList;
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
    public GroupBean getByKey(Object key) throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM GROUPS WHERE GROUP_NUMBER = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, (String) key);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                GroupBean groupBean = new GroupBean();
                groupBean.setGroupNumber(set.getString(1));
                groupBean.setAvgMark(set.getFloat(2));
                return groupBean;
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
    public void add(GroupBean bean) throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "INSERT INTO GROUPS VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bean.getGroupNumber());
            statement.setFloat(2, bean.getAvgMark());
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
    public void delete(Object key) throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "DELETE FROM GROUPS WHERE GROUP_NUMBER = ?";
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

    @Override
    public void update(GroupBean bean) throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "UPDATE GROUPS SET GROUP_NUMBER = ?, AVG_MARK = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, bean.getGroupNumber());
            statement.setFloat(2, bean.getAvgMark());
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
