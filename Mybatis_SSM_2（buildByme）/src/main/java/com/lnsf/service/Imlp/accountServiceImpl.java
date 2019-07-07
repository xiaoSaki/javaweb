package com.lnsf.service.Imlp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lnsf.entities.account;
import com.lnsf.entities.accountExample;
import com.lnsf.mapper.accountMapper;
import com.lnsf.service.accountService;
@Service
public class accountServiceImpl implements accountService{
 
	@Resource
	private accountMapper accMapper;
	@Override
	public List<account> selectByExample(accountExample example) {
		// TODO Auto-generated method stub
		List<account> accounts = accMapper.selectByExample(null);
		System.out.println(accounts);
		return accounts;
	}

	@Override
	public account selectByPrimaryKey(String account) {
		// TODO Auto-generated method stub
		account ac = accMapper.selectByPrimaryKey(account);
		System.out.println(ac);
		return ac;
	}

	@Override
	public void insert(account at) {
		// TODO Auto-generated method stub
		accMapper.insert(at);
		
	}
	

}
