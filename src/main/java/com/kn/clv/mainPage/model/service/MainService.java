package com.kn.clv.mainPage.model.service;

import java.util.ArrayList;

import com.kn.clv.mainPage.model.vo.MainSuspect;

public interface MainService {

	int searchNumber(String num);

	ArrayList<MainSuspect> searchSuspect(String searchValue);

}
