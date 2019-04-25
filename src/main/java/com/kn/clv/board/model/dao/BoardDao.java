package com.kn.clv.board.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;

@Repository("BoardDao")
public class BoardDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public List<Board> selectBoardList(HashMap<String, Object> map) {
		return session.selectList("boardMapper.selectList", map);
	}

	public int listCount(HashMap<String, Object> map) {
		return session.selectOne("boardMapper.listCount", map);
	}

	public void addReadCount(int board_num) {
		session.selectOne("boardMapper.addReadCount", board_num);	
	}

	public Board selectBoard(HashMap<String, Object> map) {
		return session.selectOne("boardMapper.selectBoard", map);
	}

	public int insertBoard(Board board) {
		return session.insert("boardMapper.insertBoard", board);
	}

	public int addBreply(BoardReply boardReply) {
		return session.insert("boardMapper.addBreply", boardReply);
	}

	public List<BoardReply> selectBreplyList(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return session.selectList("boardMapper.selectBreplyList", boardReply);
	}
	

}
