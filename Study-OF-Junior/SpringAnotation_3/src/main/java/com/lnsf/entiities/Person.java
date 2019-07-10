package com.lnsf.entiities;

import lombok.*;

@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
//@Repository
public class Person {
    private String name;
    private  Integer id;
    public  Person person(){
        Person person = new Person();
        person.setName("xiaoming");
        return person;
    }
}
