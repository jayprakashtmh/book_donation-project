package jay.admin.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class DeleteProductDAO {
	private Connection con = DBConnection.getCon();

	public int deleteProd(int id) {
		int k = 0;
		try {
			PreparedStatement ps = con.prepareStatement("delete from product where id=?");
			ps.setInt(1, id);
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
