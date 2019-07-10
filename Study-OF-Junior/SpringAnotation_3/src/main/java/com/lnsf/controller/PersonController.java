package com.lnsf.controller;

import com.lnsf.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

@Controller
public class PersonController {
    @Autowired
    PersonService personService;

}



