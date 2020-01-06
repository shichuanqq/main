package com.example.service.database;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {

    private static Logger log = LoggerFactory.getLogger(ReadOnlyConnectionInterceptor.class);


    @Around("@annotation(readOnlyAnnotation)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint , ReadOnlyAnnotation readOnlyAnnotation) throws Throwable{
       try {
           DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.READ);
           return proceedingJoinPoint.proceed(); // 让你的方法执行完毕
       }finally {
           DataBaseContextHolder.clearDataBaseType();
       }
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
