package com.kn.clv.victim.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.clv.victim.model.dao.VictimDao;
import com.kn.clv.victim.model.vo.Victim;
import com.kn.clv.suspect.model.vo.Suspect;

@Service("victimService")
public class VictimServiceImpl implements VictimService {
	
	@Autowired
	private VictimDao victimDao;

	@Override
	public List<Victim> selectVictimList(HashMap<String, Object> map) {
		return victimDao.selectVictimList(map);
	}

	@Override
	public int listCount(HashMap<String, Object> map) {
		return victimDao.listCount(map);
	}
	
	@Override
	public List<Victim> victimAll(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return victimDao.selectVictimList(map);
	}

	@Override
	public Victim victimDetail(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return victimDao.selectVictim(map);
	}

	@Override
	public int insertVictim(Victim victim) {
		return victimDao.insertVictim(victim);
	}

	@Override
	public void addReadCount(int boardnum) {
		victimDao.addReadcount(boardnum);
	}

	// ---------
	@Override
	public Suspect suspectDuplicate(Suspect suspect) {
		return victimDao.suspectDuplicate(suspect);
	}
	
	@Override
	public void suspectDuplicateUpdate(int suspect_no) {
		victimDao.suspectDuplicateUpdate(suspect_no);
	}
	
	@Override
	public int suspectDuplicateNotInsert(Suspect suspect){
		return victimDao.suspectDuplicateNotInsert(suspect);
	}



}
