package jay.user.content;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class MailDAO {
	private Connection con = DBConnection.getCon();

	public int saveData(Mail m) {
		int k = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into mail values(default,?,?,?)");
			ps.setString(1, m.getName());
			ps.setLong(2, m.getNumber());
			ps.setString(3, m.getMsg());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;
	}

}
