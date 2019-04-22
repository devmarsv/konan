package com.kn.clv.admin.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kn.clv.board.model.vo.Board;
import com.kn.clv.board.model.vo.BoardReply;
import com.kn.clv.member.model.vo.Member;
import com.kn.clv.notice.model.vo.Notice;
import com.kn.clv.suspect.model.vo.Suspect;
import com.kn.clv.victim.model.vo.Victim;

@Repository("adminDao")
public class AdminDao {
	@Autowired
	private SqlSessionTemplate session;

	// 1) 전체회원 조회
	public List<Member> adminMemberList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub

		return session.selectList("adminMapper.adminMemberList", map);
	}

	// 2) 전체회원 수 조회
	public int adminMemberListCount() {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminMemberListCount");
	}

	// 3) 전체회원 조회 Default
	public List<Member> adminMemberSearchDefault() {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminMemberSearchDefault");
	}

	// 4) 회원 수정 시 ajax 회원 선택
	public Member adminMemberSelect(String userid) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminMemberSelect", userid);
	}

	// 5) 회원 이름 수정
	public int adminMemberUpdateName(Member member) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.adminMemberUpdateName", member);
	}

	// 6) 회원 번호 수정
	public int adminMemberUpdatePhone(Member member) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.adminMemberUpdatePhone", member);
	}

	// 7) 회원 상태 수정
	public int adminMemberUpdateState(Member member) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.adminMemberUpdateState", member);
	}

	// 8) 회원 검색 전체
	public List<Member> adminMemberSearchAll(String all) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminMemberSearchAll", all);
	}

	// 9) 회원 검색 이름
	public List<Member> adminMemberSearchName(String name) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminMemberSearchName", name);
	}

	// 10) 회원 검색 아이디
	public List<Member> adminMemberSearchId(String id) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminMemberSearchId", id);
	}

	// 11) 회원 업데이트 삭제
	public int adminMemberUpdateDelete(String userid) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.adminMemberUpdateDelete", userid);
	}

	// 12) 회원 삭제
	public int adminDeleteMember(String userid) {
		// TODO Auto-generated method stub
		return session.delete("adminMapper.adminDeleteMember", userid);
	}

	// 13) 공지 리스트
	public List<Notice> adminNoticeList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminNoticeList", map);
	}

	// 14) 공지 리스트 수
	public int adminNoticeListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminNoticeListCount", map);
	}

	// 15) 공지 조회 수
	public void adminNoticeReadCount(int noticeno) {
		// TODO Auto-generated method stub
		session.selectOne("adminMapper.adminNoticeReadCount", noticeno);
	}

	// 16) 공지 상세보기
	public Notice adminNoticeDetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminNoticeDetail", map);
	}

	// 17) 공지 삭제
	public int adminNoticeDelete(int boardNum) {
		// TODO Auto-generated method stub
		return session.delete("adminMapper.adminNoticeDelete", boardNum);
	}

	// 18) 용의자 리스트
	public List<Suspect> adminSuspectList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminSuspectList", map);
	}

	// 19) 용의자 리스트 수
	public int adminSuspectListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminSuspectListCount", map);
	}

	// 20) 피의자 ajax 수정 시 선택
	public Suspect adminSuspectSelect(int suspect_no) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminSuspectSelect", suspect_no);
	}
	// 21) 피의자 ajax 수정 이름 승인

	public int adminSuspectUpdateName(Suspect suspect) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.adminSuspectUpdateName", suspect);
	}

	// 22) 피의자 ajax 수정 계좌 승인
	public int adminSuspectUpdateAccount(Suspect suspect) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.adminSuspectUpdateAccount", suspect);
	}

	// 23) 피의자 ajax 수정 번호 승인
	public int adminSuspectUpdatePhone(Suspect suspect) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.adminSuspectUpdatePhone", suspect);
	}

	// 24) 피의자 ajax 수정 은행 승인
	public int adminSuspectUpdateBank(Suspect suspect) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.adminSuspectUpdateBank", suspect);
	}
	
	// 25) 피의자 ajax 수정 신고 승인
	public int adminSuspectUpdateDate(Suspect suspect) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.adminSuspectUpdateDate", suspect);
	}
	
	// 26) 피의자 ajax 수정 횟수 승인
	public int adminSuspectUpdateCount(Suspect suspect) {
		// TODO Auto-generated method stub
		return session.update("adminMapper.adminSuspectUpdateCount", suspect);
	}

	// 26) 피의자 삭제
	public int adminSuspectDelete(int suspect_no) {
		// TODO Auto-generated method stub
		return session.delete("adminMapper.adminSuspectDelete", suspect_no);
	}

	// 26) 피의자 검색 Default
	public List<Suspect> adminSuspectSearchDefault() {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminSuspectSearchDefault");
	}

	// 27) 피의자 검색 전체
	public List<Suspect> adminSuspectSearchAll(String all) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminSuspectSearchAll", all);
	}

	// 28) 피의자 검색 이름
	public List<Suspect> adminSuspectSearchName(String name) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminSuspectSearchName", name);
	}

	// 29) 피의자 검색 번호
	public List<Suspect> adminSuspectSearchPhone(String id) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminSuspectSearchPhone", id);
	}

	// 30) 피의자 검색 은행
	public List<Suspect> adminSuspectSearchBank(String bank) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminSuspectSearchBank", bank);
	}

	// 31) 피의자 검색 계좌
	public List<Suspect> adminSuspectSearchAccount(String account) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminSuspectSearchAccount", account);
	}

	// 32) 자유게시판 리스트 수
	public int adminFreeListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminFreeListCount", map);
	}
	
	
	// 31) 자유게시판 리스트
	public List<Board> adminFreeList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminFreeList", map);
	}

	// 32) 자유게시판 조회수 
	public void adminFreeReadCount(int board_num) {
		// TODO Auto-generated method stub
		session.selectOne("adminMapper.adminFreeReadCount", board_num);
	}

	// 33) 자유게시판 상세보기
	public Board adminFreeDetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminFreeDetail", map);
	}

	// 34) 자유게시판 글쓰기
	public int adminFreeInsert(Board board) {
		// TODO Auto-generated method stub
		return session.insert("adminMapper.adminFreeInsert", board);
	}

	// 35) 자유게시판 댓글 글쓰기
	public int adminFreeReplyInsert(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return session.insert("adminMapper.adminFreeReplyInsert", boardReply);
	}

	// 36) 자유게시판 댓글 선택
	public List<BoardReply> adminFreeReplySelect(BoardReply boardReply) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminFreeReplySelect", boardReply);
	}

	// 37) 자유게시판 삭제
	public int adminFreeDelete(int board_num) {
		// TODO Auto-generated method stub
		return session.delete("adminMapper.adminFreeDelete", board_num);
	}

	// 38) 피해게시판 리스트 수
	public int adminVictimListCount(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminVictimListCount", map);
	}

	// 39) 피해게시판 리스트
	public List<Board> adminVictimList(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectList("adminMapper.adminVictimList", map);
	}

	// 40) 피해게시판 조회수
	public void adminVictimReadCount(int board_num) {
		// TODO Auto-generated method stub
		session.selectOne("adminMapper.adminVictimReadCount", board_num);
	}

	// 41) 피해게시판 상세보기
	public Victim adminVictimDetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminVictimDetail", map);
	}

	// 42) 피해게시판 글쓰기
	public int adminVictimInsert(Victim victim) {
		// TODO Auto-generated method stub
		return session.insert("adminMapper.adminVictimInsert", victim);
	}

	// 43) 피해게시판 삭제
	public int adminVictimDelete(int board_num) {
		// TODO Auto-generated method stub
		return session.delete("adminMapper.adminVictimDelete", board_num);
	}

	// 44) 피해게시판 글쓰기시 용의자 중복 검색
	public Suspect adminSuspectDuplicate(Suspect suspect) {
		// TODO Auto-generated method stub
		return session.selectOne("adminMapper.adminSuspectDuplicate", suspect);
	}

	// 45) 피해게시판 등록시 피의자 중복일 경우 누적 증가
	public void adminSuspectDuplicateUpdate(int suspect_no) {
		// TODO Auto-generated method stub
		session.selectOne("adminMapper.adminSuspectDuplicateUpdate", suspect_no);
	}

	// 46) 피해게시판 등록시 피의자 중복이 아닐 경우 새 데이터 추가
	public int adminSuspectDuplicateNotInsert(Suspect suspect) {
		// TODO Auto-generated method stub
		return session.insert("adminMapper.adminSuspectDuplicateNotInsert", suspect);
	}

	
	





}
