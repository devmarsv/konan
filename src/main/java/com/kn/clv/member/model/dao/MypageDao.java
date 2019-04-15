package com.kn.clv.member.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;
import com.kn.clv.member.model.vo.FindBoardAndReply;
import com.kn.clv.member.model.vo.Member;

@Repository("mypageDao")
public class MypageDao {
	
	@Autowired
	SqlSessionTemplate mybatis;
	
	@Autowired
	BCryptPasswordEncoder bcryptPasswordEncoder;

	public int updateInfo(Member member) {
		member.setUserpwd(bcryptPasswordEncoder.encode(member.getUserpwd()));
		return mybatis.update("mypage.updateInfo",member);
	}

	public ArrayList<Board> findBoard(String userid) {
		ArrayList<Board> board = (ArrayList)mybatis.selectList("mypage.findBoard", userid);
		return board;
	}

	public ArrayList<BoardReply> findReply(String userid) {
		ArrayList<BoardReply> board = (ArrayList)mybatis.selectList("mypage.findReply", userid);
		return board;
	}

	public ArrayList<Board> findAllBoard(FindBoardAndReply member) {
		ArrayList<Board> board = (ArrayList)mybatis.selectList("mypage.findAllBoard", member);
		return board;
	}

	public int countBoardList(String userid) {
		return mybatis.selectOne("mypage.countBoardList", userid);
	}

	public int countReplyList(String userid) {
		return mybatis.selectOne("mypage.countReplyList", userid);
	}

	public ArrayList<BoardReply> findAllReply(FindBoardAndReply member) {
		ArrayList<BoardReply> board = (ArrayList)mybatis.selectList("mypage.findAllReply", member);
		return board;
	}

	public int dropInfo(String userid) {
		return mybatis.update("mypage.dropInfo", userid);
	}
	
}