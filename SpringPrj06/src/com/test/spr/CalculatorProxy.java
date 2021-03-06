/* ============================================
	CalculatorProxy.java
	- 프록시 클래스
	- 보조 업무 적용 및 주 업무 호출 과정.
============================================ */
// 서블릿 상속 받는 방법 -- 상속

// ※ Proxy 클래스를 만드는 여러가지 방법들 중
//    비교적 쉽고 직관적인 방법은
//    InvocationHandler 인터페이스를 구현하는 클래스를 만드는 것이다.


package com.test.spr;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StopWatch;

public class CalculatorProxy implements InvocationHandler
{
	// 주요 속성 구성
	
	// target → 가짜가... 진짜 행세를 하게 될 대상
	private Object target;
	
	// 생성자 정의
	public CalculatorProxy(Object target)
	{
		this.target = target;
	}

	// 보조 업무 적용 및 주 업무 호출 과정 추가
	// invoke() 활용 어떻게 하는지 지금은 우리가 알 필요가 없음.
	// -------- 우리가 호출하지 않음, 파라미터값도 우리가 넘긴게 아님

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		//보조 업무(cross-cutting concern) 설정
		//-- 시간 측정(Around Advice)
		Log log = LogFactory.getLog(this.getClass());
		StopWatch sw = new StopWatch();
		sw.start();
		log.info("처리 시간 측정 ---------------------");
		
		//주 업무(core concern) 실행 내용
		Object result = method.invoke(target, args);
		
		sw.stop();
		log.info("처리시간 측정 종료 -----------------");
		log.info(String.format("경과시간 : %s/1000초"
				, sw.getTotalTimeMillis()));
		
		return result;
	}
	
}
