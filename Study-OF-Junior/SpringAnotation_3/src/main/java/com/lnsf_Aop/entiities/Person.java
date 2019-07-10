package com.lnsf_Aop.entiities;

import lombok.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@ToString
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Person {
    private String name;
    private  Integer id;

}
