package board.spring.test.persistence;

import java.util.List;

import board.spring.test.domain.BoardVO;

public interface BoardDAO {
	// 1. 게시글 작성
	// 2. 게시글 전체목록 검색옵션, 키워드 매개변수 추가
	// 3. 게시글 열람
	// 4. 게시글 수정
	// 5. 게시글 삭제
	// 6. 조회수 증가
	// 7. 게시글 갯수 메서드 추가

	public void boardInsert(BoardVO boardvo);

	public List<BoardVO> boardList(int start, int end, String searchOption, String keyword) throws Exception;

	public BoardVO boardInfo(int bno);

	public void boardUpdate(BoardVO boardvo);

	public void boardDelete(int bno);

	public void boardViewCnt(int bno) throws Exception;

	public int countBoard(String searchOption, String keyword) throws Exception;
}
