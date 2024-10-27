package jay.admin.team;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import jay.common.DBConnection;

public class ViewUsersDAO {
	private Connection con = DBConnection.getCon();

	public ArrayList<TeamMem> getUsers() {
		ArrayList<TeamMem> ul = new ArrayList<>();
		try {
			ResultSet rs = con.prepareStatement("select * from our_team").executeQuery();
			while (rs.next()) {
				TeamMem tm = new TeamMem();
				tm.setId(rs.getInt(1));
				tm.setName(rs.getString(2));
				tm.setAbout(rs.getString(3));
				tm.setPic(rs.getString(4));
				tm.setfLink(rs.getString(5));
				tm.setxLink(rs.getString(6));
				tm.setiLink(rs.getString(7));
				ul.add(tm);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ul;
	}
}
