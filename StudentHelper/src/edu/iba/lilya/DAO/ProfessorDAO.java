package edu.iba.lilya.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import edu.iba.lilya.bean.ProfessorBean;

public class ProfessorDAO extends BaseDAO<ProfessorBean> {

	public List<ProfessorBean> loadAll() throws DAOException  {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM PROFESSORS";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			List<ProfessorBean> professorList = new ArrayList<>();
			while (set.next()) {
				ProfessorBean professor = new ProfessorBean();
				professor.setId(set.getInt(1));
				professor.setFirstName(set.getString(2));
				professor.setFatherName(set.getString(3));
				professor.setSecondName(set.getString(4));
				professor.setBirthDate(set.getDate(5));
				professor.setAvgMark(set.getFloat(6));
				professorList.add(professor);
			}
			return professorList;
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
	
	public ProfessorBean getByKey(Object key) {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM PROFESSORS WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, (String) key);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				ProfessorBean professor = new ProfessorBean();
				professor.setId(set.getInt(1));
				professor.setFirstName(set.getString(2));
				professor.setFatherName(set.getString(3));
				professor.setSecondName(set.getString(4));
				professor.setBirthDate(set.getDate(5));
				professor.setAvgMark(set.getFloat(6));
				return professor;
			}
		} catch (SQLException | DAOException e) {
            e.printStackTrace();
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
	
	public void add(ProfessorBean bean) {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "INSERT INTO PROFESSORS VALUES (?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, bean.getId());
			statement.setString(2, bean.getFirstName());
			statement.setString(3, bean.getFatherName());
			statement.setString(4, bean.getSecondName());
			statement.setDate(5, bean.getBirthDate());
			statement.setFloat(6, bean.getAvgMark());
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
	
	public void delete(Object key) throws DAOException {
		delete(key, "PROFESSORS");
	}
	
	public void update(ProfessorBean bean) {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "UPDATE PROFESSORS SET ID = ?, FIRST_NAME = ?, FATHER_NAME = ?, SECOND_NAME = ?, BIRTH_DATE = ?, AVG_MARK = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, bean.getId());
			statement.setString(2, bean.getFirstName());
			statement.setString(3, bean.getFatherName());
			statement.setString(4, bean.getSecondName());
			statement.setDate(5, bean.getBirthDate());
			statement.setFloat(6, bean.getAvgMark());
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
}
