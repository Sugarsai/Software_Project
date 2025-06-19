package com.example.SE_Project.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    private static final Logger logger = LoggerFactory.getLogger("MethodLogger");

    // Apply logging to all methods in your project
    @Around("execution(* com.example.SE_Project..*(..))")
    public Object logExecutionDetails(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().toShortString();
        Object[] args = joinPoint.getArgs();

        logger.info("Entering method: {} | Args: {}", methodName, args);

        long start = System.currentTimeMillis();
        try {
            Object result = joinPoint.proceed();  // proceed with the method
            long duration = System.currentTimeMillis() - start;

            logger.info("Method completed: {} | Result: {} | Duration: {} ms", methodName, result, duration);
            return result;

        } catch (Throwable ex) {
            long duration = System.currentTimeMillis() - start;
            logger.error("Exception in method: {} | Message: {} | Duration: {} ms", methodName, ex.getMessage(), duration);
            throw ex;
 }
}
}