package com.kn.clv.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.clv.member.model.dao.MypageDao;
import com.kn.clv.member.model.vo.Member;

@Service("mypageService")
public class MypageServiceImpl implements MypageService {

	@Autowired
	MypageDao mypageDao;
	
	@Override
	public int updateInfo(Member member) {
		return mypageDao.updateInfo(member);
	}

}
