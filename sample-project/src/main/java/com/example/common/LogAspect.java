package com.example.common;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("@annotation(com.example.annotation.Log)")
    public void logAnnotationPointcut() {
    }

    @Before("logAnnotationPointcut()")
    public void startMethod(JoinPoint joinPoint) {
        if (log.isDebugEnabled()) {
            log.debug("<<<<<<< {}", joinPoint.getSignature());
        }
    }

    @AfterReturning("logAnnotationPointcut()")
    public void endMethod(JoinPoint joinPoint) {
        if (log.isDebugEnabled()) {
            log.debug("{} >>>>>>",joinPoint.getSignature());
        }
    }


}
