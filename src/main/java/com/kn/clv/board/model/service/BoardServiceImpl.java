package com.kn.clv.board.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.clv.board.model.dao.BoardDao;
import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;

@Service("boardService")
public class BoardServiceImpl 
implements BoardService{

	@Autowired
	private BoardDao boardDao;
	

	@Override
	public List<Board> boardAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.selectBoardList(map);
	}

	@Override
	public int listCount(HashMap<String, Object> map) {
		return boardDao.listCount(map);
	}

	@Override
	public void addReadcount(int board_num) {
		boardDao.addReadCount(board_num);
	}

	@Override
	public Board boarddetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return boardDao.selectBoard(map);
	}

	@Override
	public int insertBoard(Board board) {
		// TODO Auto-generated method stub
		return boardDao.insertBoard(board);
	}

	@Override
	public int addBreply(BoardReply boardReply) {
		return boardDao.addBreply(boardReply);
		
	}

	@Override
	public List<BoardReply> selectReply(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return boardDao.selectBreplyList(boardReply);
	}
	
}

