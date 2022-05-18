/* ==============================================
	Main.java
	- main() 메소드를 포함하는 테스트 클래스
============================================== */
package com.test.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	public static void main(String[] args)
	{
		//MemberList member = new MemberList();
		//member.print();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		MemberList list = context.getBean("list", MemberList.class);
		
		list.print();
	}
}
