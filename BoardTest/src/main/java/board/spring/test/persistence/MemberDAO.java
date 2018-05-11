package board.spring.test.persistence;

import java.util.List;

import javax.servlet.http.HttpSession;

import board.spring.test.domain.MemberVO;

public interface MemberDAO {

	// 1. 회원 전체 목록
	// 2. 회원 가입
	// 3. 회원정보 상세보기
	// 4. 회원정보 수정
	// 5. 회원 탈퇴
	// 6. 비번 체크
	// 7. 로그인 체크
	// 8. 로그인 정보
	// 9. 로그아웃

	public List<MemberVO> memberList();

	public void memberInsert(MemberVO membervo);

	public MemberVO memberInfo(String userid);

	public void memberUpdate(MemberVO membervo);

	public void memberDelete(String userid);

	public boolean checkPWD(String userid, String userpwd);

	public boolean loginCheck(MemberVO vo);

	public MemberVO loginInfo(MemberVO vo);

	public void logout(HttpSession session);

}
