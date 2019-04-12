package com.kn.clv.member.model.service;

import java.util.ArrayList;

import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;
import com.kn.clv.member.model.vo.FindBoardAndReply;
import com.kn.clv.member.model.vo.Member;

public interface MypageService {
	int updateInfo(Member member);
	ArrayList<Board> findBoard(String userid);
	ArrayList<BoardReply> findReply(String userid);
	int countBoardList(String userid);
	ArrayList<Board> findAllBoard(FindBoardAndReply findBoardAndReply);
	int countReplyList(String userid);
	ArrayList<BoardReply> findAllReply(FindBoardAndReply findBoardAndReply);
}
