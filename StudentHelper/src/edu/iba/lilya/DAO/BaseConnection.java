package edu.iba.lilya.DAO;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by lilya on 01.12.16.
 */
public class BaseConnection {
    protected final Connection getConnection() throws DAOException {
        try {
            InitialContext context = new InitialContext();
            //DataSource source = (DataSource)context.lookup("jcc/Student_Helper_DB");
            DataSource source = (DataSource) context.lookup("java:comp/env/jdbc/academic_reference");
            return source.getConnection();
        } catch (NamingException | SQLException e) {
            throw new DAOException(e);
        }
    }
}
