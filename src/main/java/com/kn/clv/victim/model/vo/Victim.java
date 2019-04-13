package com.kn.clv.victim.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class Victim implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int boardnum;
	private String boardwriter;
	private String boardsuspect;
	private String boardcategory;
	private String boardtitle;
	private String boardcontent;
	private String original_filepath;
	private String rename_filepath;
	private int boardreadcount; 
	private Date boarddate;   
	private String boardphone;
	private String boardaccount;
	
	public Victim() {}

	public Victim(int boardnum, String boardwriter, String boardsuspect, String boardcategory, String boardtitle,
			String boardcontent, String original_filepath, String rename_filepath, int boardreadcount,
			Date boarddate, String boardphone, String boardaccount) {
		super();
		this.boardnum = boardnum;
		this.boardwriter = boardwriter;
		this.boardsuspect = boardsuspect;
		this.boardcategory = boardcategory;
		this.boardtitle = boardtitle;
		this.boardcontent = boardcontent;
		this.original_filepath = original_filepath;
		this.rename_filepath = rename_filepath;
		this.boardreadcount = boardreadcount;
		this.boarddate = boarddate;
		this.boardphone = boardphone;
		this.boardaccount = boardaccount;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getBoardwriter() {
		return boardwriter;
	}

	public void setBoardwriter(String boardwriter) {
		this.boardwriter = boardwriter;
	}

	public String getBoardsuspect() {
		return boardsuspect;
	}

	public void setBoardsuspect(String boardsuspect) {
		this.boardsuspect = boardsuspect;
	}

	public String getBoardcategory() {
		return boardcategory;
	}

	public void setBoardcategory(String boardcategory) {
		this.boardcategory = boardcategory;
	}

	public String getBoardtitle() {
		return boardtitle;
	}

	public void setBoardtitle(String boardtitle) {
		this.boardtitle = boardtitle;
	}

	public String getBoardcontent() {
		return boardcontent;
	}

	public void setBoardcontent(String boardcontent) {
		this.boardcontent = boardcontent;
	}

	public String getOriginal_filepath() {
		return original_filepath;
	}

	public void setOriginal_filepath(String original_filepath) {
		this.original_filepath = original_filepath;
	}

	public String getRename_filepath() {
		return rename_filepath;
	}

	public void setRename_filepath(String rename_filepath) {
		this.rename_filepath = rename_filepath;
	}

	public int getBoardreadcount() {
		return boardreadcount;
	}

	public void setBoardreadcount(int boardreadcount) {
		this.boardreadcount = boardreadcount;
	}

	public Date getBoarddate() {
		return boarddate;
	}

	public void setBoarddate(Date boarddate) {
		this.boarddate = boarddate;
	}

	public String getBoardphone() {
		return boardphone;
	}

	public void setBoardphone(String boardphone) {
		this.boardphone = boardphone;
	}

	public String getBoardaccount() {
		return boardaccount;
	}

	public void setBoardaccount(String boardaccount) {
		this.boardaccount = boardaccount;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Victim [boardnum=" + boardnum + ", boardwriter=" + boardwriter + ", boardsuspect=" + boardsuspect
				+ ", boardcategory=" + boardcategory + ", boardtitle=" + boardtitle + ", boardcontent="
				+ boardcontent + ", original_filepath=" + original_filepath + ", rename_filepath=" + rename_filepath
				+ ", boardreadcount=" + boardreadcount + ", boarddate=" + boarddate + ", boardphone=" + boardphone
				+ ", boardaccount=" + boardaccount + "]";
	}
	
	
	
	
	
}
