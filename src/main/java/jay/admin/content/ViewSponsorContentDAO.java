package jay.admin.content;

import java.sql.Connection;
import java.sql.ResultSet;

import jay.common.DBConnection;

public class ViewSponsorContentDAO {
	private Connection con = DBConnection.getCon();

	public SponsorContent showData() {
		SponsorContent sc = new SponsorContent();

		try {
			ResultSet rs = con.prepareStatement("select * from sponsor").executeQuery();
			if (rs.next()) {
				sc.setText1(rs.getString(1));
				sc.setText2(rs.getString(2));
				sc.setText3(rs.getString(3));
				sc.setPicUrl(rs.getString(4));
				sc.setaText1(rs.getString(5));
				sc.setaText1Url(rs.getString(6));
				sc.setaText2(rs.getString(7));
				sc.setaText1Url(rs.getString(8));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sc;
	}
}
