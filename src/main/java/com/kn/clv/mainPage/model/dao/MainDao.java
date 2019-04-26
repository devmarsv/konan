package com.kn.clv.mainPage.model.dao;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kn.clv.mainPage.model.vo.MainSuspect;

@Repository("mainDao")
public class MainDao {

	@Autowired
	SqlSessionTemplate mybatis;
	
	public int searchNumber(String num) {
		return mybatis.selectOne("searchCount", num);
	}

	public ArrayList<MainSuspect> searchSuspect(String searchValue) {
		ArrayList<MainSuspect> list = (ArrayList)mybatis.selectList("searchSuspect", searchValue);
		return list;
	}

}
