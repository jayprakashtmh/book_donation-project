package jay.admin.content;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class UpdateIndexDataDAO {
	private Connection con = DBConnection.getCon();

	public int updateIndexData(IndexData id) {
		int k = 0;

		try {
			PreparedStatement ps = con.prepareStatement(
					"update index_data set logo=?, h_text=?, pic_url=?, descr=?, f_link=?, x_link=?, i_link=?");
			ps.setString(1, id.getLogo());
			ps.setString(2, id.gethText());
			ps.setString(3, id.getPicUrl());
			ps.setString(4, id.getDescr());
			ps.setString(5, id.getfLink());
			ps.setString(6, id.getxLink());
			ps.setString(7, id.getiLink());

			k = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return k;
	}
}
