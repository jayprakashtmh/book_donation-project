package jay.admin.team;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class UpdateTeamMemDAO {
	private Connection con = DBConnection.getCon();

	public int updateTeam(TeamMem tm) {
		int k = 0;
		try {
			PreparedStatement ps = con.prepareStatement("update our_team set name=?, about=? where id = ?");
			ps.setString(1, tm.getName());
			ps.setString(2, tm.getAbout());
			ps.setInt(3, tm.getId());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
