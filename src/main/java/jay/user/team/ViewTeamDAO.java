package jay.user.team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jay.common.DBConnection;

public class ViewTeamDAO {
	private Connection con = DBConnection.getCon();

	public ArrayList<Team> viewTeam() {
		ArrayList<Team> team = new ArrayList<Team>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from our_team");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Team t = new Team();
				t.setName(rs.getString(2));
				t.setAbout(rs.getString(3));
				t.setPic(rs.getString(4));
				t.setfLink(rs.getString(5));
				t.setxLink(rs.getString(6));
				t.setiLink(rs.getString(7));
				team.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return team;
	}
}
