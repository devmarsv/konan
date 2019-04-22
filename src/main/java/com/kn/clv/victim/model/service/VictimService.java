package com.kn.clv.victim.model.service;

import java.util.HashMap;
import java.util.List;

import com.kn.clv.victim.model.vo.Victim;
import com.kn.clv.suspect.model.vo.Suspect;

public interface VictimService {

	List<Victim> selectVictimList(HashMap<String, Object> map);

	int listCount(HashMap<String, Object> map);

	void addReadCount(int boardnum);

	/*Victim selectBoard(int boardNum);*/
	
	List<Victim> victimAll(HashMap<String, Object> map);
	
	Victim victimDetail(HashMap<String, Object> map);
	
	int insertVictim(Victim victim);
	
	//피해게시판 글쓰기시 용의자 중복 검색
	Suspect suspectDuplicate(Suspect suspect);
	
	//피해게시판 등록시 피의자 중복일 경우 누적 증가
	void suspectDuplicateUpdate(int suspect_no);
	
	//피해게시판 등록시 피의자 중복이 아닐 경우 새 데이터 추가
	int suspectDuplicateNotInsert(Suspect suspect);
}
