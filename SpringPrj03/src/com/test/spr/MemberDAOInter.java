package com.test.spr;

import java.sql.SQLException;
import java.util.List;

public interface MemberDAOInter
{
	public List<MemberDTO> list() throws ClassNotFoundException, SQLException;
}
