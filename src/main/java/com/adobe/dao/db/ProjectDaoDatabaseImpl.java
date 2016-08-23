package com.adobe.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.adobe.dao.ProjectDao;
import com.adobe.entity.Employee;
import com.adobe.entity.Project;
import com.adobe.entity.ProjectContributor;

@Repository
public class ProjectDaoDatabaseImpl implements ProjectDao {

	@Override
	public List<Project> getProjects() {
		List<Project> projects = new ArrayList<Project>();
		Connection con = null;
		Statement stmt = null;
		String SQL = "SELECT id, name, client_name FROM T_PROJECT";
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				Project p = new Project(rs.getInt("id"), rs.getString("name"), rs.getString("client_name"));
				projects.add(p);
			}
		} catch (SQLException e) {
//			throw new FetchException("unable to get products", e);		
		} finally {
			DBUtil.releaseStatement(stmt);
			DBUtil.releaseConnection(con);
		}
		return projects;
	}

	@Override
	public Project getProject(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addProject(Project project) {
		Connection con = null;
		PreparedStatement ps = null;
		String SQL = "INSERT INTO T_PROJECT (id, name, client_name) VALUES (?,?,?)";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setInt(1, project.getId());
			ps.setString(2, project.getName());
			ps.setString(3, project.getClientName());
			ps.executeUpdate();
		} catch (SQLException e) {
//			throw new PersistenceException("unable to add product", e);		
		} finally {
			DBUtil.releaseStatement(ps);
			DBUtil.releaseConnection(con);
		}
	}

	@Override
	public void addManager(Employee manager) {
		// TODO Auto-generated method stub

	}

    @Override
    public void assignEmployee(ProjectContributor contributor) {
        // TODO Auto-generated method stub
        
    }

}
