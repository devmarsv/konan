package com.kn.clv.board.model.service;

import java.util.*;

import com.kn.clv.board.model.vo.Board;


public interface BoardService {
	List<Board> boardAll(HashMap<String, Object> map);
	int listCount();
	void addReadcount(int board_num);
	Board boarddetail(HashMap<String, Object> map);

}
