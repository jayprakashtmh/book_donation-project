package jay.user.content;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class FillFormDAO {
	private Connection con = DBConnection.getCon();

	public int addData(FillForm ff) {
		int k = 0;

		try {
			PreparedStatement ps = con.prepareStatement("insert into fillup values(default,?,?,?,?,?,?,?,?)");
			ps.setString(1, ff.getName());
			ps.setString(2, ff.getProfession());
			ps.setLong(3, ff.getPhno());
			ps.setString(4, ff.getEmail());
			ps.setString(5, ff.getState());
			ps.setString(6, ff.getCity());
			ps.setInt(7, ff.getPin());
			ps.setString(8, ff.getAddr());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;
	}
}
