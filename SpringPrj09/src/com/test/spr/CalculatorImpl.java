/* =========================================
	CalculatorImpl.java
	- Calculator 인터페이스를 구현한 클래스
	- 주 업무만 처리되는 형태
========================================= */
package com.test.spr;


public class CalculatorImpl implements Calculator
{

	@Override
	public int add(int x, int y)
	{
		int result = 0;
		
		// ※ 주 업무(core concern) 에서 예외 상황을 만들기 위해
		//    예외 객체 생성
		//    - try ~ catch ~ finally : 예외 발생 시, 자체적으로 처리
		//    - thorows 				  : 예외 발생 시, 자신을 호출한 객체에 예외를 넘기는 처리
		//    - thorow 				  : 예외를 인위적으로 발생시키는 처리
		if (x>100 || y>100)
		{
			throw new IllegalArgumentException("100 보다 큰 인자를 전달한 예외 발생");
		}
		
		
		
		
		//주 업무(core concern) 실행 내용
		result = x + y;
		System.out.printf("%d + %d = %d \n", x,y,result);
		
		return result;
	}

	@Override
	public int sub(int x, int y)
	{
		int result = 0;
		
		// 주 업무(cord concern) 실행 내용
		result = x - y;
		System.out.printf("%d - %d = %d \n",x, y, result);
		
		return result;
	}

	@Override
	public int multi(int x, int y)
	{
		int result = 0;
		
		// 주 업무(cord concern) 실행 내용
		result = x * y;
		System.out.printf("%d * %d = %d \n",x, y, result);
		
		return result;
	}

	@Override
	public int div(int x, int y)
	{
		int result = 0;
		
		// 주 업무(cord concern) 실행 내용
		result = x / y;
		System.out.printf("%d / %d = %d \n",x, y, result);
		
		return result;
	}
	
}
