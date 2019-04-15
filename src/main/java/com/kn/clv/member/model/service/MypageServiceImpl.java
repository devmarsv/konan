package com.kn.clv.member.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;
import com.kn.clv.member.model.dao.MypageDao;
import com.kn.clv.member.model.vo.FindBoardAndReply;
import com.kn.clv.member.model.vo.Member;

@Service("mypageService")
public class MypageServiceImpl implements MypageService {

	@Autowired
	MypageDao mypageDao;
	
	@Override
	public int updateInfo(Member member) {
		return mypageDao.updateInfo(member);
	}

	@Override
	public ArrayList<Board> findBoard(String userid) {
		return mypageDao.findBoard(userid);
	}

	@Override
	public ArrayList<BoardReply> findReply(String userid) {
		return mypageDao.findReply(userid);
	}

	@Override
	public ArrayList<Board> findAllBoard(FindBoardAndReply member) {
		return mypageDao.findAllBoard(member);
	}

	@Override
	public int countBoardList(String userid) {
		return mypageDao.countBoardList(userid);
	}

	@Override
	public int countReplyList(String userid) {
		return mypageDao.countReplyList(userid);
	}

	@Override
	public ArrayList<BoardReply> findAllReply(FindBoardAndReply member) {
		return mypageDao.findAllReply(member);
	}

	@Override
	public int dropInfo(String userid) {
		return mypageDao.dropInfo(userid);
	}

}
