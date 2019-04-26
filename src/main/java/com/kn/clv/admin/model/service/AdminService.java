package com.kn.clv.admin.model.service;

import java.util.HashMap;
import java.util.List;

import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;
import com.kn.clv.member.model.vo.Member;
import com.kn.clv.notice.model.vo.Notice;
import com.kn.clv.suspect.model.vo.Suspect;
import com.kn.clv.victim.model.vo.Victim;



public interface AdminService{
	
	// 1) 전체회원 조회
	List<Member> adminMemberList(HashMap<String, Object> map);
	// 2) 전체회원 수 조회
	int adminMemberListCount(HashMap<String, Object> map);
	// 3) 회원 수정 시 ajax 회원 선택
	Member adminMemberSelect(String userid);
	// 4) 회원 이름 수정
	int adminMemberUpdateName(Member member);
	// 5) 회원 번호 수정
	int adminMemberUpdatePhone(Member member);
	// 6) 회원 상태 수정
	int adminMemberUpdateState(Member member);
    // 7) 회원 업데이트 삭제
	int adminMemberUpdateDelete(String userid);
	// 8) 회원 삭제
	int adminMemberDelete(String userid);
	// 9) 공지 리스트
	List<Notice> adminNoticeList(HashMap<String, Object> map);
	// 10) 공지 리스트 수
	int adminNoticeListCount(HashMap<String, Object> map);
	// 11) 공지 조회수
	void adminNoticeReadCount(int noticeno);
	// 12) 공지 상세보기
	Notice adminNoticeDetail(HashMap<String, Object> map);
	// 13) 공지 삭제
	int adminNoticeDelete(int boardNum);
	// 14) 피의자 리스트
	List<Suspect> adminSuspectList(HashMap<String, Object> map);
	// 15) 피의자 리스트 수
	int adminSuspectListCount(HashMap<String, Object> map);
	// 16) 피의자 ajax 수정 시 선택
	Suspect adminSuspectSelect(int suspect_no);
	// 17) 피의자 ajax 수정 이름 승인 
	int adminSuspectUpdateName(Suspect command);
	// 18) 피의자 ajax 수정 계좌 승인 
	int adminSuspectUpdateAccount(Suspect command);
	// 19) 피의자 ajax 수정 번호 승인 
	int adminSuspectUpdatePhone(Suspect command);
	// 20) 피의자 ajax 수정 은행 승인 
	int adminSuspectUpdateBank(Suspect command);
	// 21) 피의자 ajax 수정 신고 승인 
	int adminSuspectUpdateDate(Suspect command);
	// 22) 피의자 ajax 수정 횟수 승인 
	int adminSuspectUpdateCount(Suspect command);
	// 23) 피의자 삭제
	int adminSuspectDelete(int suspect_no);
	// 24) 자유게시판 수
	int adminFreeListCount(HashMap<String, Object> map);
	// 25) 자유게시판 리스트
	List<Board> adminFreeList(HashMap<String, Object> map);
	// 26) 자유게시판 조회 수
	void adminFreeReadCount(int board_num);
	// 27) 자유게시판 상세보기
	Board adminFreeDetail(HashMap<String, Object> map);
	// 28) 자유게시판 글쓰기
	int adminFreeInsert(Board board);
	// 29) 자유게시판 댓글 글쓰기
	int adminFreeReplyInsert(BoardReply boardReply);
	// 30) 자유게시판 댓글 선택
	List<BoardReply> adminFreeReplySelect(BoardReply boardReply);
	// 31) 자유게시판 삭제
	int adminFreeDelete(int board_num);
	// 32) 피해게시판 수
	int adminVictimListCount(HashMap<String, Object> map);
	// 33) 피해게시판 리스트
	List<Board> adminVictimList(HashMap<String, Object> map);
	// 34) 피해게시판 조회 수
	void adminVictimReadCount(int board_num);
	// 35) 피해게시판 상세보기
	Victim adminVictimDetail(HashMap<String, Object> map);
	// 36) 피해게시판 글쓰기
	int adminVictimInsert(Victim board);
	// 37) 피해게시판 삭제
	int adminVictimDelete(int board_num);
	// 38) 피해게시판 글쓰기시 용의자 중복 검색
	Suspect adminSuspectDuplicate(Suspect suspect);
	// 39) 피해게시판 등록시 피의자 중복일 경우 누적 증가
	void adminSuspectDuplicateUpdate(int suspect_no);
	// 40) 피해게시판 등록시 피의자 중복이 아닐 경우 새 데이터 추가
	int adminSuspectDuplicateNotInsert(Suspect suspect);
	
}
