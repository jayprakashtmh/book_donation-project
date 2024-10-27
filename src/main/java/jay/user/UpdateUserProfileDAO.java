package jay.user;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class UpdateUserProfileDAO {
	private Connection con = DBConnection.getCon();

	public int updateUser(User u) {
		int k = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement("update user_reg set fname=?,lname=?,phno=?,email=?,addr=? where id=?");
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setLong(3, u.getPhno());
			ps.setString(4, u.getEmail());
			ps.setString(5, u.getAddr());
			ps.setInt(6, u.getId());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
