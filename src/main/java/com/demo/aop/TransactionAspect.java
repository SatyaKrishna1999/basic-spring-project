package com.demo.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * Created by skoppart on 5/14/2021
 */
@Aspect
@Component
public class TransactionAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(TransactionAspect.class);
    // In Spring AOP, advising aspects is not possible. If a class is annotated with @Aspect, then spring  excludes it from auto-proxying.
    @Pointcut("execution(public * com.demo.persistency.impl.*.getNewTx(..)) " +
            " || execution(public * com.demo.persistency.impl.*.saveNewTx(..))" +
            " || execution(public * com.demo.persistency.impl.*.deleteNewTx(..))" +
            " || execution(public * com.demo.persistency.impl.*.updateNewTx(..))")
    public void txAdvicePointCut() {
        // Pointcut annotated method must have an empty body.
    }

    @Pointcut("execution(public * com.demo.service.impl.SampleServiceImpl.*(..))" +
            " || execution(public * com.demo.persistency.impl.*.*(..))")
    public void txServiceAdvicePointCut() {

    }

    @Before("txAdvicePointCut()")
    @Order(1)
    public void logBeforeNewTx(JoinPoint joinPoint) {
        System.out.println("New Transaction has started for " + joinPoint.getSignature());
    }

    @After("txAdvicePointCut()")
    public void logAfterNewTx(JoinPoint joinPoint) {
        System.out.println("New Transaction has ended for " + joinPoint.getSignature());
    }



    @Before("txServiceAdvicePointCut() && !txAdvicePointCut()")
    @Order(1) // Lower numbers will have higher precedence.
    public void logBeforeTx(JoinPoint joinPoint) {
        System.out.println("Transaction has started for " + joinPoint.getSignature());
    }

    @Before("txServiceAdvicePointCut()")
    public void logAfterTx(JoinPoint joinPoint) {
        System.out.println("Transaction has ended for " + joinPoint.getSignature());
    }
}
