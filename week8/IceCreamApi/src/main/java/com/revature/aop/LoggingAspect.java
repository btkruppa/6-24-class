package com.revature.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	

	@Around(value = "execution(* com.revature.*..*(..))")
	public Object log(ProceedingJoinPoint pjp) throws Throwable {
		Signature signature = pjp.getSignature();
		logger.trace("method called with signature: " + signature);
		logger.trace("\t and parameters: " + Arrays.toString(pjp.getArgs()));

		try {
			Object returned = pjp.proceed(); // allow the method we are targeting to continue
			logger.trace("method with signature: " + signature);
			logger.trace("\t returned: " + returned);
			return returned;
		} catch (Throwable e) {
			logger.trace(Arrays.toString(e.getStackTrace()));
			throw e;
		}
	}

}
