package edu.iba.lilya.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by lilya on 01.12.16.
 */
public class ProcedureDAO extends BaseConnection {

    public void updateStudyAvrgMarks() {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "CALL STUDY_AVRG_MARKS()";
            CallableStatement statement = connection.prepareCall(sql);
            statement.execute();
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

    public void updateGroupAvrgMarks() {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "CALL GROUP_AVRG_MARKS()";
            CallableStatement statement = connection.prepareCall(sql);
            statement.execute();
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

    public void updateProfAvrgMarks() {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "CALL PROF_AVRG_MARKS()";
            CallableStatement statement = connection.prepareCall(sql);
            statement.execute();
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

    public void updateStudentAvrgMarks() {
        Connection connection = null;
        try {
            connection = getConnection();
            String sql = "CALL STUDENT_AVRG_MARKS()";
            CallableStatement statement = connection.prepareCall(sql);
            statement.execute();
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
}
