package App.Aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;


@Aspect
@Configuration
public class LoggingAspect {
   private  final Logger log = LoggerFactory.getLogger(this.getClass());

   @Before("execution (* App.Controller.*.*(..))")

   public void logBefore(JoinPoint joinpoint){
     log.info("Intercepted method call of {}",joinpoint.getSignature().getName());
   }
    @After("execution (* App.Controller.*.*(..))")

    public void logAfter(JoinPoint joinpoint){
         log.info("Intercepted method call of {}",joinpoint.getSignature().getName());
    }
//    @Around("execution (* App.Controller.*.*(..))")
//    public void logMethodExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        pjp.proceed();
//
//        long end =  System.currentTimeMillis();
//        log.info("Method {} to complete", pjp.getSignature().getName(),(end-start));
//
//    }
}

