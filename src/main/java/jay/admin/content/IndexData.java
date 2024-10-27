package jay.admin.content;

import java.io.Serializable;

@SuppressWarnings("serial")
public class IndexData implements Serializable {
	private String logo;
	private String hText;
	private String picUrl;
	private String descr;
	private String fLink;
	private String xLink;
	private String iLink;

	public final String getLogo() {
		return logo;
	}

	public final void setLogo(String logo) {
		this.logo = logo;
	}

	public final String gethText() {
		return hText;
	}

	public final void sethText(String hText) {
		this.hText = hText;
	}

	public final String getPicUrl() {
		return picUrl;
	}

	public final void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public final String getDescr() {
		return descr;
	}

	public final void setDescr(String descr) {
		this.descr = descr;
	}

	public final String getfLink() {
		return fLink;
	}

	public final void setfLink(String fLink) {
		this.fLink = fLink;
	}

	public final String getxLink() {
		return xLink;
	}

	public final void setxLink(String xLink) {
		this.xLink = xLink;
	}

	public final String getiLink() {
		return iLink;
	}

	public final void setiLink(String iLink) {
		this.iLink = iLink;
	}

}
