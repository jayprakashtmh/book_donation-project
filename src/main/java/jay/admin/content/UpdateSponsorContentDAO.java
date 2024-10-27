package jay.admin.content;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class UpdateSponsorContentDAO {
	private Connection con = DBConnection.getCon();

	public int updateContent(SponsorContent sc) {
		int k = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into sponsor values(?,?,?,?,?,?,?,?)");
			ps.setString(1, sc.getText1());
			ps.setString(2, sc.getText2());
			ps.setString(3, sc.getText3());
			ps.setString(4, sc.getPicUrl());
			ps.setString(5, sc.getaText1());
			ps.setString(6, sc.getaText1Url());
			ps.setString(7, sc.getaText2());
			ps.setString(8, sc.getaText2Url());

			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
