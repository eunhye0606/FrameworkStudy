/* ========================================
	Main.java
	- main() 메소드가 포함된 테스트 클래스
======================================== */
package com.test.spr;

import java.lang.reflect.Proxy;

public class Main
{
	public static void main(String[] args)
	{
		// 주 업무 실행을 할 수 있는 객체 준비
		// 인터페이스 변수 = new 인터페이스구현클래스();
		// List list = new ArrayList();
		
		Calculator cal = new CalculatorImpl();
		
		// 주 업무 실행에 대한 테스트 → AOP 기법 적용 전
		/*
		int add = cal.add(10, 20);
		System.out.println(add);
		
		int sub = cal.sub(10, 20);
		System.out.println(sub);
		
		int multi = cal.multi(10, 20);
		System.out.println(multi);
		
		int div = cal.div(10, 20);
		System.out.println(div);
		*/
		
		// 주 업무 실행에 대한 테스트 → AOP 기법 적용 후
		//                                   ----------------- Oject 반환 → 형변환(다운캐스팅?)
		Calculator proxy = (Calculator)Proxy.newProxyInstance(
				cal.getClass().getClassLoader()	  // 주 업무 실행 클래스에 대한 정보 전달(제공)
				, cal.getClass().getInterfaces()  // 주 업무 실행 클래스의 인터페이스에 대한 정보 전달(제공)
				, new CalculatorProxy(cal)        // 보조 업무 실행 클래스에 대한 정보 전달(제공)
				);
		
		int add = proxy.add(10, 20);
		System.out.println(add);
		
		int sub = proxy.sub(10, 20);
		System.out.println(sub);
		
		int multi = proxy.multi(10, 20);
		System.out.println(multi);
		
		int div = proxy.div(10, 20);
		System.out.println(div);
		
		
		
		//1. CalculatorImpl.java에서 주 업무/ 보조 업무 분할
		//2. CalculatorProxy.java에서 보조업무/주업무 호출
		//   --------------- 얘가 따라하려는애는 CalculatorImpl.java
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
