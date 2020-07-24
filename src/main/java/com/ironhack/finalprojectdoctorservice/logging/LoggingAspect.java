package com.ironhack.finalprojectdoctorservice.logging;

import com.ironhack.finalprojectdoctorservice.client.LogClient;
import com.ironhack.finalprojectdoctorservice.model.logging.Error;
import com.ironhack.finalprojectdoctorservice.model.logging.Log;
import com.ironhack.finalprojectdoctorservice.model.logging.StatusLog;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    LogClient logClient;

    @AfterReturning(pointcut="execution(* com.ironhack.finalprojectdoctorservice.controller.DoctorController.*(..))")
    public void loggingOk() {
        logClient.postLog(createError(StatusLog.OK, Optional.ofNullable(null)));
    }

    @AfterThrowing(
            pointcut="execution(* com.ironhack.finalprojectdoctorservice.controller.DoctorController.*(..))",
            throwing="exception"
    )
    public void loggingFail(Throwable exception) {
        logClient.postLog(createError(StatusLog.FAIL, Optional.ofNullable(exception)));
    }

    private Log createError(StatusLog status, Optional<Throwable> exception) {
        Log log = new Log();
        if (exception.isPresent()) {
            Error error = new Error();
                error.setMessage(exception.get().getMessage());
            log.setError(error);
        }
            log.setMicroservice("doctor-service");
            log.setTimestamp(LocalDateTime.now().toString());
            log.setStatus(status);
        return log;
    }
}
