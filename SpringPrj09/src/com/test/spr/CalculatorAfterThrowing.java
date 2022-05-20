/* ================================
	CalculatorAfterThrowing.java
	- After Throwing Advice 구성
================================ */
package com.test.spr;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.ThrowsAdvice;

public class CalculatorAfterThrowing implements ThrowsAdvice
{
	// 오버라이딩 할 메소드 없다. 예외가 어떻게 발생할 지 몰라서
	// 한마디로 명시적으로 인터페이스 구현.
	// 예외발생하면 이게 작동.
	public void afterThrowing(IllegalArgumentException e) throws Throwable
	{
		Log log = LogFactory.getLog(this.getClass());
		log.info("After Throwing Advice 수행 ====================");
		log.info("주 업무 실행 과정에서 예외 발생 시, 처리되는 사후 업무");
		log.info(e.toString());
		log.info("After Throwing Advice 수행 ====================");
	}
}
