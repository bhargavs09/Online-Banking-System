package beanclass;

public class si {
	private String fullname ,username ,password ,mailid,number,address ;
	
	private int accno;

	public si() {
		super();
	}

	public si(String fullname, String username, String password, String mailid, String number, String address, int accno) {
		super();
		this.fullname = fullname;
		this.username = username;
		this.password = password;
		this.mailid = mailid;
		this.number = number;
		this.address = address;
		this.accno = accno;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}
	
	
}
