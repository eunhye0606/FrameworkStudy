/* =================================================
	Main.java
	- main() 메소드를 포함하고 있는 테스트 클래스
=================================================*/
package com.test.spr;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
	public static void main(String[] args)
	{
		// [스프링이 처리하고 관리하게 될 영역] → 스프링 컨테이너 안에서 벌어지게 될 상황
		//--------------------------------------------------------------------------------
		/*
		// ① RecordImpl1(Reord) 객체 생성 과정
		//    업캐스팅
		//    인터페이스는 직접적으로 인스턴스 생성이 불가능하니까.
		// 실제 생성된 객체는 RecordImpl1인데 형태는 Record이다.
		// 그것이 업캐스팅
		Record rec1 = new RecordImpl1();		//-- 직접적인 Record 객체는 없고, dependency(의존 객체)
		
		// ② RecordImpl2(Record) 객체 생성 과정
		Record rec2 = new RecordImpl2();		//-- dependency(의존 객체)
		
		// RecordViewImpl(RecordView) 객체 생성 과정
		// -- Record(의존 객체 - RecordImpl1 / RecordImpl2) 객체 필요
		
		RecordView view = new RecordViewImpl();
		
		// check~!!
		// 의존 객체 주입
		// -- 의존 객체 주입 방법을 사용하게 되면
		//    느슨한 결합을 구성할 수 있게 되고
		//    한 쪽의 변동 상황이 다른 쪽에 영향을 덜 줄 수 있게 된다.
		//                                         -------- setter injection
		//                                                  (setter 를 통한 주입)
		view.setRecord(rec1);
		*/
		
		//--------------------------------------------------------------------------------
		
		
		// ※ 스프링 프레임워크에서는
		//    객체 생성 과정 및 DI(의존객체 주입)에 대한 설정은
		//    스프링 환경 설정 파일로 대체된다. (→ applicationContext.xml)
		
		// 스프링 프레임워크에서 『applicationContext.xml』 파일을 읽어서
		// 생성 및 관리할 객체에 대한 정보를 얻어내야 한다.
		
		//---------------- → 빌드패스에 jar파일중 context어쩌고가 있어야 이거 사용 가능
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// 『getBean()』 메소드를 이용하여 사용자가 원하는 객체를 얻어낸다.
		// 메소드 인자값으로 id 속성값을 지정하게 된다.
		// 타입 캐스팅해서 생성.
		
		
		//방법 1.
		//RecordView view  = (RecordViewImpl)context.getBean("view");
		
		//방법 2.
		// 스프링 3.0 이후 버전부터 사용 가능한 코드(설계도를 직접 넘김)
		RecordView view  = context.getBean("view", RecordViewImpl.class);
		
		
		// xml은 컴파일 x 수정 가능
		// java는 컴파일 후 수정 불가
		
		// xml만 수정하면 record1, record2 변경 가능
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		view.input();
		view.output();
	}
}
