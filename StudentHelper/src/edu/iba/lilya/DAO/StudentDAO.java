package edu.iba.lilya.DAO;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import edu.iba.lilya.bean.StudentBean;

public class StudentDAO extends BaseDAO<StudentBean> {
	
	public List<StudentBean> loadAll() {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM STUDENTS";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			List<StudentBean> studList = new ArrayList<StudentBean>();
			while (set.next()) {
				StudentBean stud = new StudentBean();
				stud.setId(set.getInt(1));
				stud.setFirstName(set.getString(2));
				stud.setSecondName(set.getString(3));
				stud.setAvgMark(set.getFloat(4));
				stud.setGroupNumber(set.getString(5));
				studList.add(stud);
			}
			return studList;
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
		return null;
	}
	
	public StudentBean getByKey(Object key) throws DAOException {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM STUDENTS WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, (String) key);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				
				StudentBean stud = new StudentBean();
				stud.setId(set.getInt(1));
				stud.setFirstName(set.getString(2));
				stud.setSecondName(set.getString(3));
				stud.setAvgMark(set.getFloat(4));
				stud.setGroupNumber(set.getString(5));
				return stud;
			}
		}
		catch (SQLException | DAOException e) {
			throw new DAOException(e);
		}
        finally {
			if (connection != null)
				try {
					connection.close();
				} catch (SQLException e) {
                    e.printStackTrace();
				}
		}
		return null;
	}
	
	public void add(StudentBean bean) {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "INSERT INTO STUDENTS VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, bean.getId());
			statement.setString(2, bean.getFirstName());
			statement.setString(3, bean.getSecondName());
			statement.setFloat(4, bean.getAvgMark());
			statement.setString(5, bean.getGroupNumber());
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
					e.printStackTrace();
				}
		}
	}
	
	public void delete(Object key) throws DAOException {
		delete(key,"STUDENTS");
	}
	
	public void update(StudentBean bean) {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "UPDATE STUDENTS SET ID = ?, FIRST_NAME = ?, SECOND_NAME = ?, AVG_MARK = ?, GROUP_NUMBER = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, bean.getId());
			statement.setString(2, bean.getFirstName());
			statement.setString(3, bean.getSecondName());
			statement.setFloat(4, bean.getAvgMark());
			statement.setString(5, bean.getGroupNumber());
			statement.executeUpdate();
		} catch (SQLException e) {
			try {
				throw new DAOException(e);
			} catch (DAOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} catch (DAOException e) {
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
