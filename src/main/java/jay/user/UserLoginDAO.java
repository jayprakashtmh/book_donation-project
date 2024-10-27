package jay.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jay.common.DBConnection;

public class UserLoginDAO {
	private Connection con = DBConnection.getCon();

	public User loginUser(String uN, String pW) {
		User u = new User();
		try {
			PreparedStatement ps = con.prepareStatement("select * from user_reg where uname=? and pword=?");
			ps.setString(1, uN);
			ps.setString(2, pW);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				u.setId(rs.getInt(1));
				u.setUname(uN);
				u.setPword(pW);
				u.setFname(rs.getString(4));
				u.setLname(rs.getString(5));
				u.setPhno(rs.getLong(6));
				u.setEmail(rs.getString(7));
				u.setDob(rs.getDate(8));
				u.setPic_url(rs.getString(9));
				u.setAddr(rs.getString(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}
}
