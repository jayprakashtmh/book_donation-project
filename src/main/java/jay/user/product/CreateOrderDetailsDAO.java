package jay.user.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;
import jay.user.OrderDetails;

public class CreateOrderDetailsDAO {
	private Connection con = DBConnection.getCon();

	public int createOrder(OrderDetails od) {
		int k = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into order_details values(default,?,?,?,?,?,?)");
			ps.setString(1, od.getName());
			ps.setInt(2, od.getQty());
			ps.setFloat(3, od.getPrice());
			ps.setString(4, od.getPic());
			ps.setDate(5, od.getDate());
			ps.setInt(6, od.getuId());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
