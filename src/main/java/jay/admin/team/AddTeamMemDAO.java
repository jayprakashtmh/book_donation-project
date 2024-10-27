package jay.admin.team;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class AddTeamMemDAO {
	private Connection con = DBConnection.getCon();

	public int addTeam(TeamMem tm) {
		int k = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into our_team values(default,?,?,?,?,?,?)");
			ps.setString(1, tm.getName());
			ps.setString(2, tm.getAbout());
			ps.setString(3, tm.getPic());
			ps.setString(4, tm.getfLink());
			ps.setString(5, tm.getxLink());
			ps.setString(6, tm.getiLink());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
