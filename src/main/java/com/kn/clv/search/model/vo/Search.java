package com.kn.clv.search.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Search implements Serializable{
	private static final long serialVersionUID = 1003L;
	
	private int board_num;
	private String board_writer;
	private int board_suspectNo;
	private String board_category;
	private String board_title;
	private String board_content;
	private String board_original_filename;
	private String board_rename_filename;
	private int board_readcount;
	private Date board_date;
	
	public Search() {}

	public Search(int board_num, String board_writer, int board_suspectNo, String board_category, String board_title,
			String board_content, String board_original_filename, String board_rename_filename, int board_readcount,
			Date board_date) {
		super();
		this.board_num = board_num;
		this.board_writer = board_writer;
		this.board_suspectNo = board_suspectNo;
		this.board_category = board_category;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_original_filename = board_original_filename;
		this.board_rename_filename = board_rename_filename;
		this.board_readcount = board_readcount;
		this.board_date = board_date;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getBoard_writer() {
		return board_writer;
	}

	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}

	public int getBoard_suspectNo() {
		return board_suspectNo;
	}

	public void setBoard_suspectNo(int board_suspectNo) {
		this.board_suspectNo = board_suspectNo;
	}

	public String getBoard_category() {
		return board_category;
	}

	public void setBoard_category(String board_category) {
		this.board_category = board_category;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_original_filename() {
		return board_original_filename;
	}

	public void setBoard_original_filename(String board_original_filename) {
		this.board_original_filename = board_original_filename;
	}

	public String getBoard_rename_filename() {
		return board_rename_filename;
	}

	public void setBoard_rename_filename(String board_rename_filename) {
		this.board_rename_filename = board_rename_filename;
	}

	public int getBoard_readcount() {
		return board_readcount;
	}

	public void setBoard_readcount(int board_readcount) {
		this.board_readcount = board_readcount;
	}

	public Date getBoard_date() {
		return board_date;
	}

	public void setBoard_date(Date board_date) {
		this.board_date = board_date;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Search [board_num=" + board_num + ", board_writer=" + board_writer + ", board_suspectNo="
				+ board_suspectNo + ", board_category=" + board_category + ", board_title=" + board_title
				+ ", board_content=" + board_content + ", board_original_filename=" + board_original_filename
				+ ", board_rename_filename=" + board_rename_filename + ", board_readcount=" + board_readcount
				+ ", board_date=" + board_date + "]";
	}
	
	
}
