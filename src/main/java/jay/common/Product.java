package jay.common;

public class Product {
	private int id;
	private String name;
	private String descr;
	private float price;
	private int qty;
	private String category;
	private String pic_url;

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getDescr() {
		return descr;
	}

	public final void setDescr(String descr) {
		this.descr = descr;
	}

	public final float getPrice() {
		return price;
	}

	public final void setPrice(float price) {
		this.price = price;
	}

	public final int getQty() {
		return qty;
	}

	public final void setQty(int qty) {
		this.qty = qty;
	}

	public final String getCategory() {
		return category;
	}

	public final void setCategory(String category) {
		this.category = category;
	}

	public final String getPic_url() {
		return pic_url;
	}

	public final void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

}
