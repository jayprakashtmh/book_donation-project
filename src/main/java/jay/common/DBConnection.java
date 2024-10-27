package jay.common;

import java.sql.Connection;
import java.sql.DriverManager;

import static jay.common.DBInfo.*;

public class DBConnection {
	private static Connection con;

	static {
		try {
			Class.forName(PATH);
			con = DriverManager.getConnection(URL, UNAME, PWORD);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private DBConnection() {
		// TODO Auto-generated constructor stub
	}

	public static Connection getCon() {
		return con;
	}
}
