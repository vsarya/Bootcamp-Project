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
import com.adobe.entity.Project;
import com.adobe.entity.ProjectContributor;
import com.adobe.entity.ProjectDisplayItem;

@Repository
public class ProjectDaoDatabaseImpl implements ProjectDao {
    private static Connection con;

    public ProjectDaoDatabaseImpl() {
        try {
            ProjectDaoDatabaseImpl.con = DBUtil.getConnection();
        } catch (SQLException e) {
            System.out.println("Error occurred while creating the database connection");
            e.printStackTrace();
        }
    }

    @Override
	public List<ProjectDisplayItem> getProjects() {
		List<ProjectDisplayItem> projects = new ArrayList<ProjectDisplayItem>();
		Statement stmt = null;
		String SQL = "SELECT id, name, client_name FROM T_PROJECT";
		
		try {
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while(rs.next()) {
			    ProjectDisplayItem project = new ProjectDisplayItem(rs.getString("name"), this.getManager(rs.getInt("id")), this.getStaff(rs.getInt("id")));
				projects.add(project);
			}
		} catch (SQLException e) {
		    System.out.println("Error occurred while fetching projects");
            e.printStackTrace();
		} finally {
			DBUtil.releaseStatement(stmt);
		}
		return projects;
	}

	private List<String> getStaff(int pid) {
	    List<String> staffList = new ArrayList<String>();
	    String query = "SELECT employee_id FROM T_WORKS_ON WHERE project_id = ?";
	    PreparedStatement ps = null;
	    try {
            ps = ProjectDaoDatabaseImpl.con.prepareStatement(query);
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                staffList.add(this.getStaffName(rs.getInt("employee_id")));
            }
            return staffList;
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching the list of employees assigned to the project with id = " + pid);
            e.printStackTrace();
        }
        return null;
    }

    private String getManager(int pid) {
        String query = "SELECT manager_id FROM T_MANAGES WHERE project_id = ?";
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, pid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int mid = rs.getInt("manager_id");
                return this.getStaffName(mid);
            }
        } catch (SQLException e) {
            System.out.println("Error occurred while fetching the manager details for the project with id = " + pid);
            e.printStackTrace();
        } finally {
            DBUtil.releaseStatement(ps);
        }
        return null;
    }

    private String getStaffName(int id) throws SQLException {
        String query = "SELECT first_name, last_name FROM T_EMPLOYEE WHERE id = ?";
        PreparedStatement ps = ProjectDaoDatabaseImpl.con.prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
        	System.out.println(rs.getString("first_name") + rs.getString("last_name"));
            return rs.getString("first_name") + " " + rs.getString("last_name");
        }
        return null;
    }

	@Override
	public void addProject(Project project) {
		PreparedStatement ps = null;
		String SQL = "INSERT INTO T_PROJECT (id, name, client_name) VALUES (?,?,?)";
		
		try {
			ps = ProjectDaoDatabaseImpl.con.prepareStatement(SQL);
			ps.setInt(1, project.getId());
			ps.setString(2, project.getName());
			ps.setString(3, project.getClientName());
			ps.executeUpdate();
		} catch (SQLException e) {
		    System.out.println("Error occurred while adding the project with id = " + project.getId());
            e.printStackTrace();
		} finally {
			DBUtil.releaseStatement(ps);
		}
	}

	@Override
	public void assignManager(ProjectContributor projectContributor) {
		PreparedStatement ps = null;
		String SQL = "INSERT INTO T_MANAGES (project_id, manager_id) VALUES (?,?)";
		
		try {
			ps = ProjectDaoDatabaseImpl.con.prepareStatement(SQL);
			ps.setInt(1, projectContributor.getProjectId());
			ps.setInt(2, projectContributor.getEmployeeId());
			ps.executeUpdate();
		} catch (SQLException e) {
		    System.out.println("Error occurred while assigning the manager to the project with id = " + projectContributor.getProjectId());
            e.printStackTrace();
		} finally {
			DBUtil.releaseStatement(ps);
		}
	}

	@Override
	public void assignEmployee(ProjectContributor projectContributor) {
		PreparedStatement ps = null;
		String SQL = "INSERT INTO T_WORKS_ON (project_id, employee_id) VALUES (?,?)";
		
		try {
			ps = ProjectDaoDatabaseImpl.con.prepareStatement(SQL);
			ps.setInt(1, projectContributor.getProjectId());
			ps.setInt(2, projectContributor.getEmployeeId());
			ps.executeUpdate();
		} catch (SQLException e) {
		    System.out.println("Error occurred while assigning an employee to the project with id = " + projectContributor.getEmployeeId());
		    e.printStackTrace();
		} finally {
			DBUtil.releaseStatement(ps);
		}
	}

    @Override
    public Project getProject(int id) {
        return null;
    }
}
