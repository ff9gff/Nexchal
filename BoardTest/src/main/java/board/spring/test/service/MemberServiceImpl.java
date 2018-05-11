package board.spring.test.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.spring.test.domain.MemberVO;
import board.spring.test.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberdao;

	@Override
	public List<MemberVO> memberList() {
		return memberdao.memberList();
	}

	@Override
	public void memberInsert(MemberVO membervo) {
		memberdao.memberInsert(membervo);
	}

	@Override
	public MemberVO memberInfo(String userid) {
		return memberdao.memberInfo(userid);
	}

	@Override
	public void memberUpdate(MemberVO membervo) {
		memberdao.memberUpdate(membervo);
	}

	@Override
	public void memberDelete(String userid) {
		memberdao.memberDelete(userid);
	}

	@Override
	public boolean checkPWD(String userid, String userpwd) {
		return memberdao.checkPWD(userid, userpwd);
	}

	@Override
	public boolean loginCheck(MemberVO membervo, HttpSession session) {
		boolean result = memberdao.loginCheck(membervo);
		if (result) { 
			MemberVO membervo2 = loginInfo(membervo);
			session.setAttribute("userid", membervo2.getUserid());
			session.setAttribute("username", membervo2.getUsername());
		}
		return result;
	}

	@Override
	public MemberVO loginInfo(MemberVO vo) {
		return memberdao.loginInfo(vo);
	}

	@Override
	public void logout(HttpSession session) {
		memberdao.logout(session);
	}

}
