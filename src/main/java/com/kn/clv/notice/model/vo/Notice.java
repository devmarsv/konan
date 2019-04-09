package com.kn.clv.notice.model.vo;

import java.sql.Date;

import org.springframework.stereotype.Component;

@Component
public class Notice implements java.io.Serializable{
	private static final long serialVersionUID = 1000L;
	
	private int noticeno;
	private String noticetitle;
	private Date noticedate;
	private String noticewriter;
	private String noticecontent;
	private int noticereadcount;
	private String orignal_filepath;
	private String rename_filepath;
	
	public Notice() {}


	public Notice(int noticeno, String noticetitle, Date noticedate, String noticewriter, String noticecontent,
			int noticereadcount, String orignal_filepath, String rename_filepath) {
		super();
		this.noticeno = noticeno;
		this.noticetitle = noticetitle;
		this.noticedate = noticedate;
		this.noticewriter = noticewriter;
		this.noticecontent = noticecontent;
		this.noticereadcount = noticereadcount;
		this.orignal_filepath = orignal_filepath;
		this.rename_filepath = rename_filepath;
	}



	public int getNoticeno() {
		return noticeno;
	}

	public void setNoticeno(int noticeno) {
		this.noticeno = noticeno;
	}

	public String getNoticetitle() {
		return noticetitle;
	}

	public void setNoticetitle(String noticetitle) {
		this.noticetitle = noticetitle;
	}

	public Date getNoticedate() {
		return noticedate;
	}

	public void setNoticedate(Date noticedate) {
		this.noticedate = noticedate;
	}

	public String getNoticewriter() {
		return noticewriter;
	}

	public void setNoticewriter(String noticewriter) {
		this.noticewriter = noticewriter;
	}

	public String getNoticecontent() {
		return noticecontent;
	}

	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}

	public String getOrignal_filepath() {
		return orignal_filepath;
	}

	public void setOrignal_filepath(String orignal_filepath) {
		this.orignal_filepath = orignal_filepath;
	}

	public String getRename_filepath() {
		return rename_filepath;
	}

	public void setRename_filepath(String rename_filepath) {
		this.rename_filepath = rename_filepath;
	}

	
	public int getLeadcount() {
		return noticereadcount;
	}



	public void setLeadcount(int leadcount) {
		this.noticereadcount = noticereadcount;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Notice [noticeno=" + noticeno + ", noticetitle=" + noticetitle + ", noticedate=" + noticedate
				+ ", noticewriter=" + noticewriter + ", noticecontent=" + noticecontent + ", noticereadcount=" + noticereadcount
				+ ", orignal_filepath=" + orignal_filepath + ", rename_filepath=" + rename_filepath + "]";
	}
	
	
}
