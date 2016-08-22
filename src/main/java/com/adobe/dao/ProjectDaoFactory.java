package com.adobe.dao;

import java.util.ResourceBundle;

public class ProjectDaoFactory {
	private static String DAO_CLASS = "";
	static {
		ResourceBundle res = ResourceBundle.getBundle("database");
		DAO_CLASS = res.getString("DAO").trim();
	}
	public static EmployeeDao getEmployeeDao() {
		try {
			return (EmployeeDao )Class.forName(DAO_CLASS).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
}
