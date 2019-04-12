package com.kn.clv.suspect.model.vo;

import org.springframework.stereotype.Component;

@Component
public class Suspect implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 35L;
	private int suspect_no;
	private String suspect_name;
	private String suspect_account;
	private String suspect_phone;
	private int suspect_count;

	public Suspect() {

	}

	public Suspect(int suspect_no, String suspect_name, String suspect_account, String suspect_phone,
			int suspect_count) {
		super();
		this.suspect_no = suspect_no;
		this.suspect_name = suspect_name;
		this.suspect_account = suspect_account;
		this.suspect_phone = suspect_phone;
		this.suspect_count = suspect_count;
	}

	public int getSuspect_no() {
		return suspect_no;
	}

	public void setSuspect_no(int suspect_no) {
		this.suspect_no = suspect_no;
	}

	public String getSuspect_name() {
		return suspect_name;
	}

	public void setSuspect_name(String suspect_name) {
		this.suspect_name = suspect_name;
	}

	public String getSuspect_account() {
		return suspect_account;
	}

	public void setSuspect_account(String suspect_account) {
		this.suspect_account = suspect_account;
	}

	public String getSuspect_phone() {
		return suspect_phone;
	}

	public void setSuspect_phone(String suspect_phone) {
		this.suspect_phone = suspect_phone;
	}

	public int getSuspect_count() {
		return suspect_count;
	}

	public void setSuspect_count(int suspect_count) {
		this.suspect_count = suspect_count;
	}

	@Override
	public String toString() {
		return "Suspect [suspect_no=" + suspect_no + ", suspect_name=" + suspect_name + ", suspect_account="
				+ suspect_account + ", suspect_phone=" + suspect_phone + ", suspect_count=" + suspect_count + "]";
	}
}
