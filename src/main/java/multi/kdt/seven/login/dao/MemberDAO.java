package multi.kdt.seven.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import multi.kdt.seven.login.dto.MemberDTO;

@Repository
public class MemberDAO {
	
	@Autowired
	SqlSession session;

	public MemberDTO loginmember(MemberDTO dto) {
		MemberDTO dto2 = session.selectOne("loginmember", dto);
		return dto2;
	}
}
