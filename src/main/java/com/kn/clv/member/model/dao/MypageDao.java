package com.kn.clv.member.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;
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
	
	
	
}