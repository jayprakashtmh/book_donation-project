package jay.user.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;

public class DecreaseQtyPaymentBookDAO {
	private Connection con = DBConnection.getCon();

	public int setQty(int id, int qty) {
		int k = 0;
		try {
			PreparedStatement ps = con.prepareStatement("update product set qty =? where id=?");
			ps.setInt(1, qty);
			ps.setInt(2, id);
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
