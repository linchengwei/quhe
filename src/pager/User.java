package pager;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 3201782511929434548L;

	private String user_id;
	private String password;
	private String user_name;
	private String college;
	private String major;
	private String classnumber;
	private String tel;
	public User() {
		super();
	}
	public User(String user_id, String password, String user_name,
			String college, String major, String classnumber, String tel) {
		super();
		this.user_id = user_id;
		this.password = password;
		this.user_name = user_name;
		this.college = college;
		this.major = major;
		this.classnumber = classnumber;
		this.tel = tel;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClassnumber() {
		return classnumber;
	}
	public void setClassnumber(String classnumber) {
		this.classnumber = classnumber;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", password=" + password
				+ ", user_name=" + user_name + ", college=" + college
				+ ", major=" + major + ", classnumber=" + classnumber
				+ ", tel=" + tel + "]";
	}
	
}
