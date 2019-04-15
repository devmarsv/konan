package com.kn.clv.member.model.vo;

public class ConnectionData {
	private String ip;
	private String brower;
	private String os;
	private String date;
	
	public ConnectionData() {
		super();
	}

	public ConnectionData(String ip, String brower, String os, String date) {
		super();
		this.ip = ip;
		this.brower = brower;
		this.os = os;
		this.date = date;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getBrower() {
		return brower;
	}

	public void setBrower(String brower) {
		this.brower = brower;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ConnectionData [ip=" + ip + ", brower=" + brower + ", os=" + os + ", date=" + date + "]";
	}

}
