package jay.user;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class User implements Serializable {
	private int id;
	private String uname;
	private String pword;
	private String fname;
	private String lname;
	private long phno;
	private String email;
	private Date dob;
	private String pic_url;
	private String addr;

	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
	}

	public final String getUname() {
		return uname;
	}

	public final void setUname(String uname) {
		this.uname = uname;
	}

	public final String getPword() {
		return pword;
	}

	public final void setPword(String pword) {
		this.pword = pword;
	}

	public final String getFname() {
		return fname;
	}

	public final void setFname(String fname) {
		this.fname = fname;
	}

	public final String getLname() {
		return lname;
	}

	public final void setLname(String lname) {
		this.lname = lname;
	}

	public final long getPhno() {
		return phno;
	}

	public final void setPhno(long phno) {
		this.phno = phno;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final Date getDob() {
		return dob;
	}

	public final void setDob(Date dob) {
		this.dob = dob;
	}

	public final String getPic_url() {
		return pic_url;
	}

	public final void setPic_url(String pic_url) {
		this.pic_url = pic_url;
	}

	public final String getAddr() {
		return addr;
	}

	public final void setAddr(String addr) {
		this.addr = addr;
	}

}
