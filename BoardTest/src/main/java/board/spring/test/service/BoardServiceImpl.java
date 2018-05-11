package board.spring.test.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.spring.test.domain.BoardVO;
import board.spring.test.persistence.BoardDAO;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO boarddao;

	@Override
	public void boardInsert(BoardVO boardvo) {
		boarddao.boardInsert(boardvo);
	}

	@Override
	public List<BoardVO> boardList(int start, int end, String searchOption, String keyword) throws Exception {
		return boarddao.boardList(start, end, searchOption, keyword);
	}

	@Override
	public BoardVO boardInfo(int bno) {
		return boarddao.boardInfo(bno);
	}

	@Override
	public void boardUpdate(BoardVO boardvo) {
		boarddao.boardUpdate(boardvo);
	}

	@Override
	public void boardDelete(int bno) {
		boarddao.boardDelete(bno);
	}

	@Override
	public void boardViewCnt(int bno, HttpSession session) throws Exception {
		long update_time = 0;

		// 세션에 저장된 조회시간 검색
		// 최초 조회의 경우 세션에 저장된 값X --> if문 실행X
		if (session.getAttribute("update_time_" + bno) != null) {
			update_time = (long) session.getAttribute("update_time_" + bno);
		}

		long current_time = System.currentTimeMillis();
		if (current_time - update_time > 5000) {
			boarddao.boardViewCnt(bno);
			// 세션에 시간을 저장 : "update_time_"+bno는 다른변수와 중복되지 않게 명명한 것
			session.setAttribute("update_time_" + bno, current_time);
		}
	}

	@Override
	public int countBoard(String searchOption, String keyword) throws Exception {
		return boarddao.countBoard(searchOption, keyword);
	}

}
