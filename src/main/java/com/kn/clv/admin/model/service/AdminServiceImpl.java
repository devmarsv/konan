package com.kn.clv.admin.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.clv.admin.model.dao.AdminDao;
import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;
import com.kn.clv.member.model.vo.Member;
import com.kn.clv.notice.model.vo.Notice;
import com.kn.clv.suspect.model.vo.Suspect;
import com.kn.clv.victim.model.vo.Victim;

@Service("adminService")
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDao adminDao;

	// 1) 전체회원 조회
	@Override
	public List<Member> adminMemberList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberList(map);
	}

	// 2) 전체회원 수 조회
	@Override
	public int adminMemberListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberListCount(map);
	}


	// 3) 회원 수정 시 ajax 회원 선택
	@Override
	public Member adminMemberSelect(String userid) {
	// TODO Auto-generated method stub
			return adminDao.adminMemberSelect(userid);
	}
	
	// 4) 회원 이름 수정
	@Override
	public int adminMemberUpdateName(Member member) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberUpdateName(member);
	}

	// 5) 회원 번호 수정
	@Override
	public int adminMemberUpdatePhone(Member member) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberUpdatePhone(member);
	}

	// 6) 회원 상태 수정
	@Override
	public int adminMemberUpdateState(Member member) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberUpdateState(member);
	}
	

	// 7) 회원 업데이트 삭제
	@Override
	public int adminMemberUpdateDelete(String userid) {
		// TODO Auto-generated method stub
		return adminDao.adminMemberUpdateDelete(userid);
	}

	// 8) 회원 삭제
	@Override
	public int adminMemberDelete(String userid) {
		// TODO Auto-generated method stub
		return adminDao.adminDeleteMember(userid);
	}

	// 9) 공지 리스트
	@Override
	public List<Notice> adminNoticeList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeList(map);

	}

	// 10) 공지 리스트 수
	@Override
	public int adminNoticeListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeListCount(map);
	}

	// 11) 공지 조회수
	@Override
	public void adminNoticeReadCount(int noticeno) {
		// TODO Auto-generated method stub
		adminDao.adminNoticeReadCount(noticeno);
	}

	// 12) 공지 상세보기
	@Override
	public Notice adminNoticeDetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeDetail(map);
	}

	// 13) 공지 삭제
	@Override
	public int adminNoticeDelete(int boardNum) {
		// TODO Auto-generated method stub
		return adminDao.adminNoticeDelete(boardNum);
	}

	// 14) 용의자 리스트
	@Override
	public List<Suspect> adminSuspectList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectList(map);
	}

	// 15) 용의자 리스트 수

	@Override
	public int adminSuspectListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectListCount(map);
	}
	
    // 16) 피의자 ajax 수정 시 선택
	@Override
	public Suspect adminSuspectSelect(int suspect_no) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectSelect(suspect_no);
	}

	
	// 17) 피의자 ajax 수정 이름 승인 
	@Override
	public int adminSuspectUpdateName(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectUpdateName(suspect);
	}

	// 18) 피의자 ajax 수정 계좌 승인 
	@Override
	public int adminSuspectUpdateAccount(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectUpdateAccount(suspect);
	}

	// 19) 피의자 ajax 수정 번호 승인 
	@Override
	public int adminSuspectUpdatePhone(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectUpdatePhone(suspect);
	}

	// 20) 피의자 ajax 수정 은행 승인 
	@Override
	public int adminSuspectUpdateBank(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectUpdateBank(suspect);
	}
	
	// 21) 피의자 ajax 수정 신고 승인 
	@Override
	public int adminSuspectUpdateDate(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectUpdateDate(suspect);
	}

	
	// 22) 피의자 ajax 수정 횟수 승인 
	@Override
	public int adminSuspectUpdateCount(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectUpdateCount(suspect);
	}

	// 23) 피의자 삭제
	@Override
	public int adminSuspectDelete(int suspect_no) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectDelete(suspect_no);
	}




	




	// 24) 자유게시판 리스트 수
	@Override
	public int adminFreeListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminFreeListCount(map);
	}

	// 25) 자유게시판 리스트
	@Override
	public List<Board> adminFreeList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminFreeList(map);
	}

	// 26) 자유게시판 조회수
	@Override
	public void adminFreeReadCount(int board_num) {
		// TODO Auto-generated method stub
		adminDao.adminFreeReadCount(board_num);
	}

	// 27) 자유게시판 상세보기
	@Override
	public Board adminFreeDetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminFreeDetail(map);
	}

	// 28) 자유게시판 글쓰기
	@Override
	public int adminFreeInsert(Board board) {
		// TODO Auto-generated method stub
		return adminDao.adminFreeInsert(board);
	}

	// 29) 자유게시판 댓글 쓰기
	@Override
	public int adminFreeReplyInsert(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return adminDao.adminFreeReplyInsert(boardReply);
	}

	// 30) 자유게시판 댓글 선택
	@Override
	public List<BoardReply> adminFreeReplySelect(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return adminDao.adminFreeReplySelect(boardReply);
	}

	// 31) 자유게시판 삭제
	@Override
	public int adminFreeDelete(int board_num) {
		// TODO Auto-generated method stub
		return adminDao.adminFreeDelete(board_num);
	}

	// 32) 피해게시판 수
	@Override
	public int adminVictimListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminVictimListCount(map);
	}

	// 33) 피해게시판 리스트
	@Override
	public List<Board> adminVictimList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminVictimList(map);
	}

	// 34) 피해게시판 조회 수
	@Override
	public void adminVictimReadCount(int board_num) {
		// TODO Auto-generated method stub
		adminDao.adminVictimReadCount(board_num);
	}

	// 35) 피해게시판 상세보기
	@Override
	public Victim adminVictimDetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return adminDao.adminVictimDetail(map);
	}

	// 36) 피해게시판 글쓰기
	@Override
	public int adminVictimInsert(Victim victim) {
		// TODO Auto-generated method stub
		return adminDao.adminVictimInsert(victim);
	}

	// 37) 피해게시판 삭제
	@Override
	public int adminVictimDelete(int board_num) {
		// TODO Auto-generated method stub
		return adminDao.adminVictimDelete(board_num);
	}

	// 38) 피해게시판 글쓰기시 용의자 중복 검색
	@Override
	public Suspect adminSuspectDuplicate(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectDuplicate(suspect);
	}

	// 39) 피해게시판 등록시 피의자 중복일 경우 누적 증가
	@Override
	public void adminSuspectDuplicateUpdate(int suspect_no) {
		// TODO Auto-generated method stub
		adminDao.adminSuspectDuplicateUpdate(suspect_no);
	}

	// 40) 피해게시판 등록시 피의자 중복이 아닐 경우 새 데이터 추가
	@Override
	public int adminSuspectDuplicateNotInsert(Suspect suspect) {
		// TODO Auto-generated method stub
		return adminDao.adminSuspectDuplicateNotInsert(suspect);
	}





	

	


}
