package com.lnsf.Config;

import com.lnsf.dao.PersonDao;
import com.lnsf.service.PersonService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.lnsf.controller","com.lnsf.service","com.lnsf.dao"})
public class PersonConfigOfAutowired {
    @Bean("personDao")
    public PersonDao personDao(){
        PersonDao personDao=new PersonDao();
        personDao.setLabel("2");
        return personDao;
    }

}
