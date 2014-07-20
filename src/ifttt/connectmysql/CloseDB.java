package ifttt.connectmysql;

import java.sql.*;

public class CloseDB {
	public static void close(Connection connection){
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
