package com.klee.DoAlibaba.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@Aspect
public class MyAspect {
    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    @Pointcut("execution(* com.klee..*.*(..))")
    private void MyPointCut(){}
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    @Before("MyPointCut()")
    public void before(){
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println("************模拟权限检查*************");
    }
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,readOnly = false)
    @After("MyPointCut()")
    public void after(){
        System.out.println(simpleDateFormat.format(new Date()));
        System.out.println("************模拟记录日志*************");
    }
}
