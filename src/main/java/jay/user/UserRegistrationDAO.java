package jay.user;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class UserRegistrationDAO {
	private Connection con = DBConnection.getCon();

	public int regUser(User u) {
		int k = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into user_reg values(default,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, u.getUname());
			ps.setString(2, u.getPword());
			ps.setString(3, u.getFname());
			ps.setString(4, u.getLname());
			ps.setLong(5, u.getPhno());
			ps.setString(6, u.getEmail());
			ps.setDate(7, u.getDob());
			ps.setString(8, u.getPic_url());
			ps.setString(9, u.getAddr());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
