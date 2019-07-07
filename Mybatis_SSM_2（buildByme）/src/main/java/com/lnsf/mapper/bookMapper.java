package com.lnsf.mapper;

import com.lnsf.entities.book;
import com.lnsf.entities.bookExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface bookMapper {
    int countByExample(bookExample example);

    int deleteByExample(bookExample example);

    int deleteByPrimaryKey(String bookid);

    int insert(book record);

    int insertSelective(book record);

    List<book> selectByExample(bookExample example);

    book selectByPrimaryKey(String bookid);

    int updateByExampleSelective(@Param("record") book record, @Param("example") bookExample example);

    int updateByExample(@Param("record") book record, @Param("example") bookExample example);

    int updateByPrimaryKeySelective(book record);

    int updateByPrimaryKey(book record);
}