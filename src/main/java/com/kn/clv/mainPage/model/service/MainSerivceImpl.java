package com.kn.clv.mainPage.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kn.clv.mainPage.model.dao.MainDao;
import com.kn.clv.mainPage.model.vo.MainSuspect;

@Service("mainService")
public class MainSerivceImpl implements MainService {

	@Autowired
	MainDao mainDao;

	@Override
	public int searchNumber(String num) {
		return mainDao.searchNumber(num);
	}

	@Override
	public ArrayList<MainSuspect> searchSuspect(String searchValue) {
		return mainDao.searchSuspect(searchValue);
	}

}
