package com.adobe.dao.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.adobe.dao.EmployeeDao;
import com.adobe.entity.Employee;
import com.adobe.entity.Role;

@Repository
public class EmployeeDaoDatabaseImpl implements EmployeeDao {

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		Connection con = null;
		Statement stmt = null;
		String SQL = "SELECT id, first_name, last_name, email, salary, role FROM T_EMPLOYEE";
		
		try {
			con = DBUtil.getConnection();
			stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				Employee p = new Employee(rs.getInt("id"), rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"), rs.getDouble("salary"), Role.valueOf(rs.getString("role")));
				employees.add(p);
			}
		} catch (SQLException e) {
		    System.out.println("Error occurred while fetching employees");
			e.printStackTrace();
		} finally {
			DBUtil.releaseStatement(stmt);
			DBUtil.releaseConnection(con);
		}
		return employees;
	}

	@Override
	public List<Employee> getEmployees(Role role) {
		return null;
	}

	@Override
	public void addEmployee(Employee employee) {
		Connection con = null;
		PreparedStatement ps = null;
		String SQL = "INSERT INTO T_EMPLOYEE (id, first_name, last_name, email, salary, role) VALUES (?,?,?,?,?,?)";
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement(SQL);
			ps.setInt(1, employee.getId());
			ps.setString(2, employee.getfName());
			ps.setString(3, employee.getlName());
			ps.setString(4, employee.getEmail());
			ps.setDouble(5, employee.getSalary());
			ps.setString(6, employee.getRole().name());
			ps.executeUpdate();
		} catch (SQLException e) {
		    e.printStackTrace();
		    System.out.println("Error occurred while adding an employee");
		} finally {
			DBUtil.releaseStatement(ps);
			DBUtil.releaseConnection(con);
		}
	}

	@Override
	public Employee getEmployee(int id) {
		return null;
	}

}
