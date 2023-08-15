package com.example.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class TransactionAspect {

    @Pointcut("@annotation(com.example.annotation.Transaction)")
    public void transactionAnnotationPointcut(){}

    public TransactionAspect(){
        log.info("TransactionAspect bean created...");
    }

    @Before("transactionAnnotationPointcut()")
    public void startTransaction(){
        log.info("Transaction started.....");
    }

    @AfterReturning("transactionAnnotationPointcut()")
    public void commitTransaction(){
        log.info("Transaction committed....");
    }

    @AfterThrowing("transactionAnnotationPointcut()")
    public void rollbackTransaction(){
        log.info("Transaction rollback....");
    }

}
