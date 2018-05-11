package board.spring.test.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import board.spring.test.domain.BoardVO;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	private static final String NAMESPACE = "board.spring.test.boardMapper";

	@Override
	public void boardInsert(BoardVO boardvo) {
		sqlSession.insert(NAMESPACE + ".boardInsert", boardvo);
	}

	@Override
	public List<BoardVO> boardList(int start, int end, String searchOption, String keyword) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		// BETWEEN #{start}, #{end}에 입력될 값을 맵에 
	    map.put("start", start);
	    map.put("end", end);
		return sqlSession.selectList(NAMESPACE + ".boardList", map);
	}

	@Override
	public BoardVO boardInfo(int bno) {
		return sqlSession.selectOne(NAMESPACE + ".boardInfo", bno);
	}

	@Override
	public void boardUpdate(BoardVO boardvo) {
		sqlSession.update(NAMESPACE + ".boardUpdate", boardvo);
	}

	@Override
	public void boardDelete(int bno) {
		sqlSession.delete(NAMESPACE + ".boardDelete", bno);
	}

	@Override
	public void boardViewCnt(int bno) throws Exception {
		sqlSession.update(NAMESPACE + ".boardViewcnt", bno);
	}

	@Override
	public int countBoard(String searchOption, String keyword) throws Exception {
		Map<String, String> map = new HashMap<>();
	    map.put("searchOption", searchOption);
	    map.put("keyword", keyword);
	    return sqlSession.selectOne(NAMESPACE + ".countBoard", map);
	}

}
