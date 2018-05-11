package board.spring.test.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.spring.test.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	private static final String NAMESPACE = "board.spring.test.memberMapper";

	@Override
	public List<MemberVO> memberList() {
		return sqlSession.selectList(NAMESPACE + ".memberList");
	}

	@Override
	public void memberInsert(MemberVO membervo) {
		sqlSession.insert(NAMESPACE + ".memberInsert", membervo);
	}

	@Override
	public MemberVO memberInfo(String userid) {
		return sqlSession.selectOne(NAMESPACE + ".memberInfo", userid);
	}

	@Override
	public void memberUpdate(MemberVO membervo) {
		sqlSession.update(NAMESPACE + ".memberUpdate", membervo);
	}

	@Override
	public void memberDelete(String userid) {
		sqlSession.delete(NAMESPACE + ".memberDelete", userid);
	}

	@Override
	public boolean checkPWD(String userid, String userpwd) {
		boolean result = false;
		Map<String, String> map = new HashMap<>();
		map.put("userid", userid);
		map.put("userpwd", userpwd);
		int count = sqlSession.selectOne(NAMESPACE + ".checkPWD", map);
		if (count == 1) {
			result = true;
		}
		return result;
	}

	@Override
	public boolean loginCheck(MemberVO membervo) {
		String username = sqlSession.selectOne(NAMESPACE + ".loginCheck", membervo);
		return (username == null) ? false : true;
	}

	@Override
	public MemberVO loginInfo(MemberVO membervo) {
		return sqlSession.selectOne(NAMESPACE + ".loginInfo", membervo);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

}
