package edu.iba.lilya.DAO;
import java.sql.SQLException;


public class DAOException extends Exception {

	public DAOException() {
		// TODO Auto-generated constructor stub
	}

	public DAOException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DAOException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	public DAOException(SQLException cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public DAOException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

}
