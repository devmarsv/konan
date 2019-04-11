package com.kn.clv.board.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kn.clv.board.model.vo.Board;

@Repository("BoardDao")
public class BoardDao {

	@Autowired
	private SqlSessionTemplate session;
	
	public List<Board> selectBoardList(HashMap<String, Object> map) {
		return session.selectList("boardMapper.selectList", map);
	}

	public int listCount() {
		return session.selectOne("boardMapper.listCount");
	}

	public void addReadCount(int board_num) {
		session.selectOne("boardMapper.addReadCount", board_num);
		
	}

	public Board selectBoard(HashMap<String, Object> map) {
		return session.selectOne("boardMapper.selectBoard", map);
	}
}
