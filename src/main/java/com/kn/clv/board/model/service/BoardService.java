package com.kn.clv.board.model.service;

import java.util.*;

import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;


public interface BoardService {
	List<Board> boardAll(HashMap<String, Object> map);
	int listCount(HashMap<String, Object> map);
	void addReadcount(int board_num);
	Board boarddetail(HashMap<String, Object> map);
	int insertBoard(Board board);
	int addBreply(BoardReply boardReply);
	List<BoardReply> selectReply(BoardReply boardReply);
	

}
