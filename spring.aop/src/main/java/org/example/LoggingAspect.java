package org.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    @Around("@annotation(Logging)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {

        var ref = new Object() {
            Object proceed;
        };

        executeWithLogging(joinPoint.toString(),  () -> {
            try {
                ref.proceed = joinPoint.proceed();
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        });

        return ref.proceed;
    }

    private void executeWithLogging(String methodName, Runnable task) {
        System.out.println("Starting "+methodName);
        try {
            task.run();
        }
        catch(Exception ignored){
            System.out.println("Exception "+methodName);
        }
        System.out.println("Exiting "+methodName);
    }
}
