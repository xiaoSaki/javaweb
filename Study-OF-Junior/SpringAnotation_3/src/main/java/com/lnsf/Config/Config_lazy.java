package com.lnsf.Config;


import com.lnsf_Aop.entiities.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
@Configuration
public class Config_lazy {
     //懒加载：作用于单例，并且在启动容器时不创建对象，而是第一次获取对象时创对象
        @Scope
        @Bean("person")
        @Lazy
        public Person person() {
            System.out.println("给IOC容器中添加Person...");
            return new Person();
        }
}
