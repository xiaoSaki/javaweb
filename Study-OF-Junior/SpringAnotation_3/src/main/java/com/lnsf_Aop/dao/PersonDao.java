package com.lnsf_Aop.dao;

import com.lnsf_Aop.entiities.Person;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PersonDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    //插入方法
   public int  add(Person person){
       String sql = "insert into person(name,id) VALUES(?,?)";
       Object[] object = new Object[]{person.getName(),person.getId()};
      int result =  jdbcTemplate.update(sql,object);
     // int i = 10/0;
      return result;
   }

}

