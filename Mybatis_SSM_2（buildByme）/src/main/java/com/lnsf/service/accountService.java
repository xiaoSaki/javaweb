package com.lnsf.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lnsf.entities.account;
import com.lnsf.entities.accountExample;

public interface accountService {
	List<account> selectByExample(accountExample example);

    account selectByPrimaryKey(String account);
    void insert(account at);

}
