package com.sono.myproj.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyProjectAdvice {

	Logger logger = LoggerFactory.getLogger(MyProjectAdvice.class);

	/**
	 * プロセスの個別処理のロギング.
	 * 
	 * @param jp
	 */
	@Before("execution(* com.sono.myproj.proc..*.*(..))")
	public void startLogProcImpl(JoinPoint jp) {
		logger.info("method started. : {}", jp.getSignature());
	}

	@AfterReturning("execution(* com.sono.myproj.proc..*.*(..))")
	public void endLogProcImpl(JoinPoint jp) {
		logger.info("method ended successfully. : {}", jp.getSignature());
	}

	@AfterThrowing(value = "execution(* com.sono.myproj.proc..*.*(..))", throwing = "e")
	public void endLogProcImpl(JoinPoint jp, Exception e) {
		logger.error("method ended with Exception. : {}", jp.getSignature(), e);
	}

	/**
	 * プロセス実行クラスのロギング.
	 * 
	 * @param jp
	 */
	@Before("execution(* com.sono.myproj.execute..*.*(..))")
	public void startLogExecMainProc(JoinPoint jp) {
		logger.info("Main Process Execution Started. : {}", jp.getSignature());
	}

	@AfterReturning("execution(* com.sono.myproj.execute..*.*(..))")
	public void endLogExecMainProc(JoinPoint jp) {
		logger.info("Main Process Execution Ended Successfully. : {}", jp.getSignature());
	}

	@AfterThrowing(value = "execution(* com.sono.myproj.execute..*.*(..))", throwing = "e")
	public void endLogExecMainProc(JoinPoint jp, Exception e) {
		logger.error("Main Process Execution Ended with Exception. : {}", jp.getSignature(), e);
	}

}
