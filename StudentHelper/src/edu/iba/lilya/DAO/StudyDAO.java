package edu.iba.lilya.DAO;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import edu.iba.lilya.bean.StudyBean;

public class StudyDAO extends BaseDAO<StudyBean> {
	public List<StudyBean> loadAll() throws DAOException {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM STUDIES";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet set = statement.executeQuery();
			List<StudyBean> studyList = new ArrayList<>();
			while (set.next()) {
				StudyBean study = new StudyBean();
				study.setId(set.getInt(1));
				study.setName(set.getString(2));
				study.setHours(set.getInt(3));
				study.setProfessorId(set.getInt(4));
				study.setAvgMark(set.getFloat(5));
				studyList.add(study);
			}
			return studyList;
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
	
	public StudyBean getByKey(Object key) {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "SELECT * FROM STUDIES WHERE ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, (String) key);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				StudyBean study = new StudyBean();
				study.setId(set.getInt(1));
				study.setName(set.getString(2));
				study.setHours(set.getInt(3));
				study.setProfessorId(set.getInt(4));
				study.setAvgMark(set.getFloat(5));
				return study;
			}
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
	
	public void add(StudyBean bean) {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "INSERT INTO STUDIES VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, bean.getId());
			statement.setString(2, bean.getName());
			statement.setInt(3, bean.getHours());
			statement.setInt(4, bean.getProfessorId());
			statement.setFloat(5, bean.getAvgMark());
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
		delete(key,"STUDIES");
	}
	
	public void update(StudyBean bean) {
		Connection connection = null;
		try {
			connection = getConnection();
			String sql = "UPDATE STUDIES SET ID = ?, NAME = ?, HOURS = ?, PROFESSOR_ID = ?, AVG_MARK = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setInt(1, bean.getId());
			statement.setString(2, bean.getName());
			statement.setInt(3, bean.getHours());
			statement.setInt(4, bean.getProfessorId());
			statement.setFloat(5, bean.getAvgMark());
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
