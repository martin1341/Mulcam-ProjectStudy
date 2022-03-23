package multi.kdt.seven.signup.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import multi.kdt.seven.signup.dto.SignupDTO;



@Repository
public class SignupDAO {
	
	@Autowired
	SqlSession session;
	
	public int insertmember(SignupDTO dto) {
		return session.insert("signupmember", dto);
	}
}
