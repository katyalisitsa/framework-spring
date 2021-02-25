package com.aop.aspects;

import com.aop.controller.ProductController;
import com.aop.entity.Product;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Aspect
@Configuration
public class LoggingAspect {
    Logger logger = LoggerFactory.getLogger(ProductController.class);

//    @Pointcut("execution(* com.aop.controller.ProductController.*(..))")
//    public void pointcut() {
//    }
//
//    @Before("pointcut()")
//    public void log() {
//        logger.info("--------------");
//    }
//
//    @Before("execution(* com.aop.controller.ProductController.*(..))")
//    public void beforeAdvice() {
//        logger.info("--------------");
//    }


    //===========================EXECUTION===========================

    @Pointcut("execution(* com.aop.controller.ProductController.up*(..))")
    private void anyUpdateOperation() {
    }

    @Pointcut("execution(* com.aop.repository.ProductRepository.findById(Long))")
    private void anyProductRepositoryFindById() {
    }

    @Before("anyProductRepositoryFindById()")
    public void beforeProductRepoAdvice(JoinPoint joinPoint) {
        logger.info("Before(findById) -> Method {} - Arguments : {} - Target : {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    @Before("anyUpdateOperation()")
    public void beforeControllerAdvice(JoinPoint joinPoint) {
        logger.info("Before -> Method {} - Arguments : {} - Target : {}", joinPoint, joinPoint.getTarget());
    }

    //===========================WITHIN===========================

    @Pointcut("within(com.aop.controller..*)")
    private void anyControllerOperation() {
    }

    @Pointcut("@within(org.springframework.stereotype.Service)")
    private void anyServiceAnnotatedOperation() {
    }

    @Before("anyServiceAnnotatedOperation() || anyControllerOperation() ")
    public void beforeControllerAdvice2(JoinPoint joinPoint) {
        logger.info("Before -> Method {} - Arguments : {} - Target : {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());
    }

    //===========================ANNOTATION===========================

    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
    private void anyDeleteProductOperation() {
    }

    @Before("anyDeleteProductOperation()")
    public void beforeControllerAdvice3(JoinPoint joinPoint) {
        logger.info("Before -> Method {} - Arguments : {} - Target : {}", joinPoint, joinPoint.getArgs(), joinPoint.getTarget());

    }

    //===========================AFTER RETURNING===========================

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetProductOperation() {
    }

    @AfterReturning(pointcut = "anyGetProductOperation()", returning = "results")
    public void afterReturningControllerAdvice(JoinPoint joinPoint, ResponseEntity<Product> results) {
        logger.info("After Returning(Mono Result) -> Method : {} - results : {}", joinPoint.getSignature().toShortString());
    }

    @AfterReturning(pointcut = "anyGetProductOperation()", returning = "results")
    public void afterReturningControllerAdvice2(JoinPoint joinPoint, List<Product> results) {
        logger.info("After Returning(List Results) -> Method : {} - results : {}", joinPoint.getSignature().toShortString());
    }

    //===========================AFTER THROWING===========================

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation() {
    }

    @AfterThrowing(pointcut = "anyGetPutProductOperation()", throwing = "exception")
    public void afterThrowingControllerAdvice(JoinPoint joinPoint, RuntimeException exception) {
        logger.info("After Throwing(Send error email) -> Method : {} - Exception : {}", joinPoint.getSignature().toShortString(), exception.getMessage());
    }

    //===========================AFTER===========================

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    private void anyGetPutProductOperation2() {
    }

    @After("anyGetPutProductOperation2()")
    public void afterControllerAdvice(JoinPoint joinPoint) {
        logger.info("After finally -> Method : {} - Exception : {}", joinPoint.getSignature().toShortString());
    }

    //===========================AROUND===========================

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    private void anyPostProductOperation() {
    }

    @Around("anyPostProductOperation()")
    public Object anyPostControllerAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("Before(Method : {} - Parameters : {})", proceedingJoinPoint.toShortString(), proceedingJoinPoint.getArgs());

        List<Product> results = new ArrayList<>();
        results = (List<Product>) proceedingJoinPoint.proceed();

        logger.info("After(Method: {} - Results : {})", proceedingJoinPoint.getSignature().toShortString(), results);

        return results;
    }


}
