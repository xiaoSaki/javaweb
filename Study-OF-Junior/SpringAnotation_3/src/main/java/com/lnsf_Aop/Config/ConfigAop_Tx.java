package com.lnsf_Aop.Config;

import com.lnsf_Aop.Filter.MyApplicationListener;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan("com.lnsf_Aop")
//启动事务管理
@EnableTransactionManagement
public class ConfigAop_Tx {
    //数据源
    @Bean
    public DataSource dataSource() throws PropertyVetoException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser("root");
        dataSource.setPassword("123");
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/person");
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate() throws PropertyVetoException {
        //Spring会的@Configuration类会做特殊的处理：给容器中添加组件，多次调用都是从容器中找组件
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
    @Bean
    public PlatformTransactionManager transactionManager() throws PropertyVetoException {
        PlatformTransactionManager platformTransactionManager =new DataSourceTransactionManager();
        ((DataSourceTransactionManager )platformTransactionManager).setDataSource(dataSource());
        return platformTransactionManager ;
    }

    @Bean
    public MyApplicationListener myApplicationListener(){
        return new MyApplicationListener();
    }

}
