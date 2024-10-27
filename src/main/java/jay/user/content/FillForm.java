package jay.user.content;

import java.io.Serializable;

@SuppressWarnings("serial")
public class FillForm implements Serializable {
	private String name;
	private String profession;
	private long phno;
	private String email;
	private String state;
	private String city;
	private int pin;
	private String addr;

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name=name;
	}

	public final String getProfession() {
		return profession;
	}

	public final void setProfession(String profession) {
		this.profession = profession;
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

	public final String getState() {
		return state;
	}

	public final void setState(String state) {
		this.state = state;
	}

	public final String getCity() {
		return city;
	}

	public final void setCity(String city) {
		this.city = city;
	}

	public final int getPin() {
		return pin;
	}

	public final void setPin(int pin) {
		this.pin = pin;
	}

	public final String getAddr() {
		return addr;
	}

	public final void setAddr(String addr) {
		this.addr = addr;
	}

}
