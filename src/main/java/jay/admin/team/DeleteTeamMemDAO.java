package jay.admin.team;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class DeleteTeamMemDAO {
	private Connection con = DBConnection.getCon();

	public int deleteTeamMem(int id) {
		int k = 0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from our_team where id=?");
			ps.setInt(1, id);
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
