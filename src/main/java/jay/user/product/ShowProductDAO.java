package jay.user.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jay.common.DBConnection;
import jay.common.Product;

public class ShowProductDAO {
	private Connection con = DBConnection.getCon();

	public ArrayList<Product> showProd() {
		ArrayList<Product> p = new ArrayList<Product>();
		try {
			PreparedStatement ps = con.prepareStatement("select * from product");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Product prod = new Product();
				prod.setId(rs.getInt(1));
				prod.setName(rs.getString(2));
				prod.setDescr(rs.getString(3));
				prod.setPrice(rs.getFloat(4));
				prod.setQty(rs.getInt(5));
				prod.setCategory(rs.getString(6));
				prod.setPic_url(rs.getString(7));
				p.add(prod);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return p;
	}
}
