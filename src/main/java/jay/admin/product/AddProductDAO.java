package jay.admin.product;

import java.sql.Connection;
import java.sql.PreparedStatement;

import jay.common.DBConnection;
import jay.common.Product;

public class AddProductDAO {
	private Connection con = DBConnection.getCon();

	public int addProduct(Product p) {
		int k = 0;
		try {
			PreparedStatement ps = con.prepareStatement("insert into product values(default,?,?,?,?,?,?)");
			ps.setString(1, p.getName());
			ps.setString(2, p.getDescr());
			ps.setFloat(3, p.getPrice());
			ps.setInt(4, p.getQty());
			ps.setString(5, p.getCategory());
			ps.setString(6, p.getPic_url());
			k = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return k;
	}

}
