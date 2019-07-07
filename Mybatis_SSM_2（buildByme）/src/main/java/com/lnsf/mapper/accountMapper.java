package com.lnsf.mapper;

import com.lnsf.entities.account;
import com.lnsf.entities.accountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface accountMapper {
    int countByExample(accountExample example);

    int deleteByExample(accountExample example);

    int deleteByPrimaryKey(String account);

    int insert(account record);

    int insertSelective(account record);

    List<account> selectByExample(accountExample example);

    account selectByPrimaryKey(String account);

    int updateByExampleSelective(@Param("record") account record, @Param("example") accountExample example);

    int updateByExample(@Param("record") account record, @Param("example") accountExample example);

    int updateByPrimaryKeySelective(account record);

    int updateByPrimaryKey(account record);
}