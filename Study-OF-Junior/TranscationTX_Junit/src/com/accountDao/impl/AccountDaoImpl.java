package com.accountDao.impl;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.accountDao.account;

public class AccountDaoImpl extends JdbcDaoSupport implements account {

	@Override
	public void out(String outer, Integer money) {
		this.getJdbcTemplate().update("update account set money = money - ? where username = ?", money,outer);
	}

	@Override
	public void in(String inner, Integer money) {
		this.getJdbcTemplate().update("update account set money = money + ? where username = ?", money,inner);
	}

}
