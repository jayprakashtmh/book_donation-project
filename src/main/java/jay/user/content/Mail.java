package jay.user.content;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Mail implements Serializable {
	private String name;
	private long number;
	private String msg;

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final long getNumber() {
		return number;
	}

	public final void setNumber(long number) {
		this.number = number;
	}

	public final String getMsg() {
		return msg;
	}

	public final void setMsg(String msg) {
		this.msg = msg;
	}

}
