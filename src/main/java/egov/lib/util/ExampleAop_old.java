package egov.lib.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleAop_old {

	private static final Logger logger = LoggerFactory.getLogger(ExampleAop_old.class);

    @Before("aspectMethod()")
	public void beforeMethod(JoinPoint joinPoint) throws Exception {
		logger.info("사용자 요청" + joinPoint.getTarget());
		System.out.println("beforeMethod 사용자 요청" + joinPoint.getTarget());
	}
//	aop:after-throwing
    @AfterThrowing(pointcut = "aspectMethod()", throwing = "exception")

	public void exceptionMethod(JoinPoint joinPoint,Exception exception) throws Exception
	{
		logger.error("ST에러발생=====================");
		logger.error("에러위치:" + exception.getClass());
		logger.error("에러내용:" + exception.getMessage());
		logger.error("ED에러발생=====================");
	}

	
	// aroundMethod
	public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable
	{
		// 시간
		long st = System.currentTimeMillis();
		System.out.println("공통기능1");
		// 핵심기능
		Object rtn = joinPoint.proceed();
		// 시간
		long ed = System.currentTimeMillis();
		System.out.println("공통기능2");
		
		System.out.println("걸린시간" + (ed - st));
		return rtn;
		
		
	}
	
	



	
	public void afterMethod(JoinPoint joinPoint)  throws Exception{
		logger.info("메소드 종료");
	}





}
