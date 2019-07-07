package com.lnsf.mapper;

import com.lnsf.entities.bookstore;
import com.lnsf.entities.bookstoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface bookstoreMapper {
    int countByExample(bookstoreExample example);

    int deleteByExample(bookstoreExample example);

    int deleteByPrimaryKey(String bookid);

    int insert(bookstore record);

    int insertSelective(bookstore record);

    List<bookstore> selectByExample(bookstoreExample example);

    bookstore selectByPrimaryKey(String bookid);

    int updateByExampleSelective(@Param("record") bookstore record, @Param("example") bookstoreExample example);

    int updateByExample(@Param("record") bookstore record, @Param("example") bookstoreExample example);

    int updateByPrimaryKeySelective(bookstore record);

    int updateByPrimaryKey(bookstore record);
}