package com.lnsf_Aop.service;
import com.lnsf_Aop.Filter.MyApplicationListener;
import com.lnsf_Aop.dao.PersonDao;
import com.lnsf_Aop.entiities.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonDao personDao;
    @EventListener(classes = {ApplicationEvent.class})
    public void listen(ApplicationEvent event) {
        System.out.println("PersonService监听的事件"+event);
    }

    @Transactional
  public int addPerson(Person person){
        System.out.println("插入完成...");
        return personDao.add(person);

    }

}
