package com.kn.clv.victim.model.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kn.clv.victim.model.vo.Victim;

@Repository("vdao")
public class VictimDao {

	@Autowired
	private SqlSessionTemplate session;

	
	public List<Victim> selectVictimList(HashMap<String, Object> map){
		return session.selectList("victimMapper.selectList", map);

	}

	public int listCount(HashMap<String, Object> map) {
		return session.selectOne("victimMapper.listCount", map);
	}

	public Victim selectVictim(HashMap<String, Object> map) {
		// TODO Auto-generated method stub
		return session.selectOne("victimMapper.selectVictim", map);
	}

	public void addReadcount(int boardnum) {
		session.selectOne("victimMapper.addReadCount", boardnum);
	}

	public int insertVictim(Victim victim) {
		return session.insert("victimMapper.insertVictim", victim);
	}

	
}
