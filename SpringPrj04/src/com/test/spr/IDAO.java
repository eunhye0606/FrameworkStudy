/* ==================
	IDAO.java
	- 인터페이스
	- 추상 메소드 list() 선언만!
	- 예외는 오버라이딩 후, 추가 못하니까
	  같이 선언!
================== */
package com.test.spr;

import java.sql.SQLException;
import java.util.List;

public interface IDAO
{
	public List<MemberDTO> list() throws ClassNotFoundException, SQLException;
}
