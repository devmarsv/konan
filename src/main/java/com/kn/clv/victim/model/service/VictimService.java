package com.kn.clv.victim.model.service;

import java.util.HashMap;
import java.util.List;

import com.kn.clv.victim.model.vo.Victim;

public interface VictimService {

	List<Victim> selectVictimList(HashMap<String, Object> map);

	int listCount(HashMap<String, Object> map);

	void addReadCount(int boardnum);

	Victim selectBoard(int boardNum);
	
	List<Victim> victimAll(HashMap<String, Object> map);
	
	Victim victimDetail(HashMap<String, Object> map);
	
	int insertVictim(Victim victim);

}
