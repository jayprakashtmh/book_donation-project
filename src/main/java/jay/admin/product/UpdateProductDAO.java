package jay.admin.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jay.common.DBConnection;
import jay.common.Product;

public class UpdateProductDAO {
	private Connection con = DBConnection.getCon();

	public int updateProd(Product p) {
		int k = 0;
		try {
			PreparedStatement ps = con.prepareStatement("update product set descr=?, price=?, qty=? where id =?");
			ps.setString(1, p.getDescr());
			ps.setFloat(2, p.getPrice());
			ps.setInt(3, p.getQty());
			ps.setInt(4, p.getId());
			k = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return k;
	}
}
