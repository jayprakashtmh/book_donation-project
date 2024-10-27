package jay.admin.team;

import java.io.Serializable;

@SuppressWarnings("serial")
public class TeamMem implements Serializable {
	private int id;
	private String name;
	private String about;
	private String pic;
	private String fLink;
	private String xLink;
	private String iLink;

	public TeamMem() {
		// TODO Auto-generated constructor stub
	}

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

	public final String getAbout() {
		return about;
	}

	public final void setAbout(String about) {
		this.about = about;
	}

	public final String getPic() {
		return pic;
	}

	public final void setPic(String pic) {
		this.pic = pic;
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
