package com.lnsf_Aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;

//表面该类是切面类
@Aspect
//监视
public class LogAspect {
    //切入点表达式（指定在哪个方法切入）
    @Pointcut(value = "execution(public * com.lnsf_Aop.util.Calculate.*(..))")
    //表示定义哪些方法我们要拦截(用表达式的形式在定义第一个*代表的任何返回值，第二各*是任何方法)
    public void pointcut(){
        //声明一个切入点，pointcut()就是切入点的名称，括号也带上

    }
    //目标方法之前切入
    @Before(value = "pointcut()")
    public void logstart(JoinPoint joinPoint){
        //获得方法的名字
        String name = joinPoint.getSignature().getName();
        System.out.println("方法的名字"+name);
        //获取方法的参数
        System.out.println("方法的参数："+ Arrays.asList(joinPoint.getArgs()));
        System.out.println("log start.....");
    }

    @After("pointcut()")
    public void logEnd(){
        System.out.println("log end.....");
    }

    @AfterReturning("pointcut()")
    public void logreturn(){
        System.out.println("log logreturn.....");
    }

    @AfterThrowing("pointcut()")
   public void logException(){
        System.out.println("log logException....");
   }

 /*  @Around("pointcut()")
   public void logRound(){
        System.out.println("log run....");
   }*/


}
