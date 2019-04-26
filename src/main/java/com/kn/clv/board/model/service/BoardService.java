package com.kn.clv.board.model.service;

import java.util.*;

import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;
import com.kn.clv.search.model.vo.Search;


public interface BoardService {
	List<Board> boardAll(HashMap<String, Object> map);
	int listCount(HashMap<String, Object> map);
	void addReadcount(int board_num);
	Board boarddetail(HashMap<String, Object> map);
	int insertBoard(Board board);
	int addBreply(BoardReply boardReply);
	List<BoardReply> selectReply(BoardReply boardReply);
	void deleteBreply(int br_num);
	void deleteBoard(int board_num);
	void deleteBreply2(int board_num);
	int boardupdate(HashMap<String, Object> map);
}
