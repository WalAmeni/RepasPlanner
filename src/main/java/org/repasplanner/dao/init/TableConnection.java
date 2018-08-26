package org.repasplanner.dao.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.repasplanner.dao.DaoProperties;

public class TableConnection {

	private TableConnection() {
		// TODO Auto-generated constructor stub
	}
	public static Connection connect() {
	
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(DaoProperties.DB_URL);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}

}


