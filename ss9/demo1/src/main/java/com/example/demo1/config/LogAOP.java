package com.example.demo1.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Aspect
public class LogAOP {

    @Pointcut("within(com.example.demo1.controller.BookController*)")
    public void allMethod() {
    }

    private int count = 0;

    @After("allMethod()")
    public void afterAllMethod(JoinPoint joinPoint) {
        count++;
        System.out.println("Method name:" + joinPoint.getSignature().getName()
                + " Số lượt vào xem: " + count);
    }

    @Pointcut("execution(* com.example.borrow_book.controller.BookController.get*(..))")
    public void borrowMethod() {
    }

    @After("borrowMethod()")
    public void afterBorrowMethod(JoinPoint joinPoint) {
        System.out.println("Method name: " + joinPoint.getSignature().getName()
                + "Time: " + LocalDateTime.now());
    }
}
