package jay.admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jay.common.DBConnection;

public class AdminLoginDAO {
	private Connection con;

	public String login(String uN, String pW) {
		String name = null;
		try {
			con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("select * from admin where uname=? and pword=?");
			ps.setString(1, uN);
			ps.setString(2, pW);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				name = rs.getString(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return name;
	}
}
