package com.kn.clv.member.model.vo;

import java.sql.Date;

public class Member {
	
	private String userid;
	private String userpwd;
	private String username;
	private String phone;
	private String email;
	private int state;
	private Date enroll_date;
	private Date lastmodified;
	private Date deletedate;
	
	public Member() {
		super();
	}

	public Member(String userid, String userpwd, String username, String phone, String email, int state,
			Date enroll_date, Date lastmodified, Date deletedate) {
		super();
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.phone = phone;
		this.email = email;
		this.state = state;
		this.enroll_date = enroll_date;
		this.lastmodified = lastmodified;
		this.deletedate = deletedate;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getEnroll_date() {
		return enroll_date;
	}

	public void setEnroll_date(Date enroll_date) {
		this.enroll_date = enroll_date;
	}

	public Date getLastmodified() {
		return lastmodified;
	}

	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	public Date getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(Date deletedate) {
		this.deletedate = deletedate;
	}

	@Override
	public String toString() {
		return "Member [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", phone=" + phone
				+ ", email=" + email + ", state=" + state + ", enroll_date=" + enroll_date + ", lastmodified="
				+ lastmodified + ", deletedate=" + deletedate + "]";
	}
	
}
