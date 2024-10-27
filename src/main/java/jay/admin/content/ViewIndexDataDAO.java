package jay.admin.content;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jay.common.DBConnection;

public class ViewIndexDataDAO {
	private Connection con = DBConnection.getCon();

	public IndexData showData() {
		IndexData id = new IndexData();

		try {
			PreparedStatement ps = con.prepareStatement("select * from index_data");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id.setLogo(rs.getString(1));
				id.sethText(rs.getString(2));
				id.setPicUrl(rs.getString(3));
				id.setDescr(rs.getString(4));
				id.setfLink(rs.getString(5));
				id.setxLink(rs.getString(6));
				id.setiLink(rs.getString(7));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return id;
	}

}
