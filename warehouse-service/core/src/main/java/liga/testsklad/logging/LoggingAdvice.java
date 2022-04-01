package liga.testsklad.logging;

import liga.testsklad.model.LogEntity;
import liga.testsklad.repository.LogRepository;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {

    private final LogRepository logRepository;

    public LoggingAdvice(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    @Pointcut("@annotation(liga.testsklad.logging.Loggable)")
    public void loggableControllerMethod() {}

    @Pointcut("within(@liga.testsklad.logging.Loggable *)")
    public void loggableControllerClass() {}

    @Around("loggableControllerClass() || loggableControllerMethod()")
    public Object applicationLogger(ProceedingJoinPoint pjp) throws Throwable {

        String className = pjp.getTarget().getClass().toString();
        String methodName = pjp.getSignature().getName();
        Object[] array = pjp.getArgs();
        LogEntity logEntity = new LogEntity();
        logEntity.setActionTime(LocalDateTime.now());
        logEntity.setMethodName(methodName);
        logEntity.setClassName(className);
        //logEntity.setUserName();
        logRepository.add(logEntity);
        log.info("Вызван метод: " + className + ":" + methodName + " ()" + " с аргументами" + array.toString());

        return pjp.proceed();
    }
}
