package multi.kdt.seven.signup.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multi.kdt.seven.signup.dao.SignupDAO;
import multi.kdt.seven.signup.dto.SignupDTO;

@Service("signupservice")
public class SignupServiceImpl implements SignupService{
	
	@Autowired
	SignupDAO signupdao;
	
	@Override
	public int insertmember(SignupDTO dto) {
		return signupdao.insertmember(dto);
	}
	
}
