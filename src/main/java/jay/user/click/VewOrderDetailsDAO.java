package jay.user.click;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jay.common.DBConnection;
import jay.user.OrderDetails;

public class VewOrderDetailsDAO {
	private Connection con = DBConnection.getCon();

	public ArrayList<OrderDetails> showOrderDetails(int id) {
		ArrayList<OrderDetails> od = new ArrayList<OrderDetails>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from order_details where u_id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				OrderDetails o = new OrderDetails();
				o.setId(rs.getInt(1));
				o.setName(rs.getString(2));
				o.setQty(rs.getInt(3));
				o.setPrice(rs.getFloat(4));
				o.setPic(rs.getString(5));
				o.setDate(rs.getDate(6));
				o.setuId(id);
				od.add(o);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return od;
	}
}
