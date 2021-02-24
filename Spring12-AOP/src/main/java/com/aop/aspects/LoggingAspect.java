package com.aop.aspects;

import com.aop.controller.ProductController;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

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


    //execution

    @Pointcut("execution(* com.aop.controller.ProductController.up*(..))")
    private void anyUpdateOperation() {
    }

    @Pointcut("execution(* com.aop.repository.ProductRepository.findById(Long))")
    private void anyProductRepository() {
    }
}
