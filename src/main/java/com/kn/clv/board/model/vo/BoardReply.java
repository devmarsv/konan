package com.kn.clv.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class BoardReply implements Serializable{
	private static final long serialVersionUID = 1002L;
	
	private int board_reply_num;
	private String board_reply_content;
	private Date board_reply_date;
	private int board_num;
	private String userid;
	
	public BoardReply() {}
	
	public BoardReply(int board_reply_num, String board_reply_content, Date board_reply_date, int board_num,
			String userid) {
		super();
		this.board_reply_num = board_reply_num;
		this.board_reply_content = board_reply_content;
		this.board_reply_date = board_reply_date;
		this.board_num = board_num;
		this.userid = userid;
	}

	public int getBoard_reply_num() {
		return board_reply_num;
	}

	public void setBoard_reply_num(int board_reply_num) {
		this.board_reply_num = board_reply_num;
	}

	public String getBoard_reply_content() {
		return board_reply_content;
	}

	public void setBoard_reply_content(String board_reply_content) {
		this.board_reply_content = board_reply_content;
	}

	public Date getBoard_reply_date() {
		return board_reply_date;
	}

	public void setBoard_reply_date(Date board_reply_date) {
		this.board_reply_date = board_reply_date;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "BoardReply [board_reply_num=" + board_reply_num + ", board_reply_content=" + board_reply_content
				+ ", board_reply_date=" + board_reply_date + ", board_num=" + board_num + ", userid=" + userid + "]";
	}

}
