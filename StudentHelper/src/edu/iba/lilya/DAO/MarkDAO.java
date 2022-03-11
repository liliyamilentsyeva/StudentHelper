package edu.iba.lilya.DAO;

import edu.iba.lilya.bean.MarkBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lilya on 02.12.16.
 */
public class MarkDAO extends BaseDAO<MarkBean> {
    @Override
    public List<MarkBean> loadAll() throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM MARKS";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet set = statement.executeQuery();
            List<MarkBean> markList = new ArrayList<>();
            while (set.next()) {
                MarkBean mark = new MarkBean();
                mark.setId(set.getInt(1));
                mark.setStudyId(set.getInt(2));
                mark.setStudentId(set.getInt(3));
                mark.setDate(set.getDate(4));
                mark.setProfessorId(set.getInt(5));
                mark.setMark(set.getInt(6));
                mark.setComments(set.getString(7));
                markList.add(mark);
            }
            return markList;
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
    public MarkBean getByKey(Object key) throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM MARKS WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, (String) key);
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                MarkBean mark = new MarkBean();
                mark.setId(set.getInt(1));
                mark.setStudyId(set.getInt(2));
                mark.setStudentId(set.getInt(3));
                mark.setDate(set.getDate(4));
                mark.setProfessorId(set.getInt(5));
                mark.setMark(set.getInt(6));
                mark.setComments(set.getString(7));
                return mark;
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
    public void add(MarkBean bean) throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "INSERT INTO MARKS VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bean.getId());
            statement.setInt(2, bean.getStudyId());
            statement.setInt(3, bean.getStudentId());
            statement.setDate(4, bean.getDate());
            statement.setInt(5, bean.getProfessorId());
            statement.setInt(6, bean.getMark());
            statement.setString(7, bean.getComments());
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
        delete(key,"MARKS");
    }

    @Override
    public void update(MarkBean bean) throws DAOException {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "UPDATE MARKS SET ID = ?, STUDY_ID = ?, STUDENT_ID = ?, MDATE = ?, PROFESSOR_ID = ?, MARK = ?, COMMENTS = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, bean.getId());
            statement.setInt(2, bean.getStudyId());
            statement.setInt(3, bean.getStudentId());
            statement.setDate(4, bean.getDate());
            statement.setInt(5, bean.getProfessorId());
            statement.setInt(6, bean.getMark());
            statement.setString(7, bean.getComments());
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
