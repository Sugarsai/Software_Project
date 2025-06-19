package com.example.registration_service.aspect;

import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TransactionAspect {

    private static final Logger logger = LoggerFactory.getLogger("TransactionLogger");

    // Pointcut for any method annotated with @Transactional
    @Pointcut("@annotation(org.springframework.transaction.annotation.Transactional)")
    public void transactionalMethods() {}

    @Before("transactionalMethods()")
    public void beforeTransaction() {
        logger.info("[TransactionLogger] Transaction STARTED");
    }

    @AfterReturning("transactionalMethods()")
    public void afterTransactionCommit() {
        logger.info("[TransactionLogger] Transaction COMMITTED");
    }

    @AfterThrowing("transactionalMethods()")
    public void afterTransactionRollback() {
        logger.info("[TransactionLogger] Transaction ROLLED BACK due to exception");
}
}