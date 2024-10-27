package jay.admin.product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import jay.common.DBConnection;
import jay.common.Product;

public class ViewProductsDAO {
	private Connection con = DBConnection.getCon();

	public ArrayList<Product> showProducts() {
		ArrayList<Product> l = new ArrayList<Product>();
		try {
			ResultSet rs = con.prepareStatement("select * from product").executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescr(rs.getString(3));
				p.setPrice(rs.getFloat(4));
				p.setQty(rs.getInt(5));
				p.setCategory(rs.getString(6));
				p.setPic_url(rs.getString(7));
				l.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return l;
	}
}
