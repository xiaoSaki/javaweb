package com.accountService.impl;
import com.accountDao.account;
import com.accountIservice.Iserviceaccount;

public class AccountServieImpl implements Iserviceaccount {
	private account dao;

	public account getDao() {
		return dao;
	}

	public void setDao(account dao) {
		this.dao = dao;
	}

	@Override
	// @Transactional(propagation=Propagation.REQUIRED)
	public void transfer(String outer, String inner, Integer money) {
		dao.in(inner, money);
		//System.out.println(1 / 0);
		dao.out(outer, money);

	}

}
