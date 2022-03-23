package multi.kdt.seven.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multi.kdt.seven.login.dao.MemberDAO;
import multi.kdt.seven.login.dto.MemberDTO;


@Service("memberservice")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDAO memberdao;
	
	@Override
	public MemberDTO loginmember(MemberDTO dto) {
		return memberdao.loginmember(dto);
	}

}
