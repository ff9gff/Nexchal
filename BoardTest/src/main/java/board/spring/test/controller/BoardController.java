package board.spring.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.spring.test.domain.BoardPager;
import board.spring.test.domain.BoardVO;
import board.spring.test.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardservice;
	
	@RequestMapping(value = "/board/list.do")
	public ModelAndView boardList(@RequestParam(defaultValue="title") String searchOption, @RequestParam(defaultValue="") String keyword, @RequestParam(defaultValue="1") int curPage) throws Exception {
		
		
		int count = boardservice.countBoard(searchOption, keyword);
		
		// 페이지 나누기 관련 처리
	    BoardPager boardPager = new BoardPager(count, curPage);
	    int start = boardPager.getPageBegin();
	    int end = boardPager.getPageEnd();
		
		List<BoardVO> boardList = boardservice.boardList(start, end, searchOption, keyword);
		ModelAndView mav = new ModelAndView();
		Map<String, Object> map = new HashMap<>();
		
	    map.put("list", boardList); // list
	    map.put("count", count); // 레코드의 갯수
	    map.put("searchOption", searchOption); // 검색옵션
	    map.put("keyword", keyword); // 검색키워드
	    map.put("boardPager", boardPager);
	    
		mav.setViewName("board_list");
		mav.addObject("map", map);
		
		return mav;
	}
	
	@RequestMapping(value = "/board/boardWrite.do")
	public String boardWrite() {
		return "board_write";
	}
	
	@RequestMapping(value = "/board/boardInsert.do")
	public String boardInsert(@ModelAttribute BoardVO boardvo, HttpSession session) {
		
		String writer = (String) session.getAttribute("userid");
		boardvo.setWriter(writer);
		
		boardservice.boardInsert(boardvo);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/board/boardInfo.do")
	public ModelAndView boardInfo(@RequestParam int bno, HttpSession session) throws Exception {
		boardservice.boardViewCnt(bno, session);
        // 모델(데이터)+뷰(화면)를 함께 전달하는 객체
		BoardVO boardvo = boardservice.boardInfo(bno);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board_info");
		mav.addObject("boardvo", boardvo);
		return mav;
	}
	
	@RequestMapping(value = "/board/boardUpdate.do") 
	public String boardUpdate(@ModelAttribute BoardVO boardvo) {		
		boardservice.boardUpdate(boardvo);
		return "redirect:list.do";
	}
	
	@RequestMapping(value = "/board/boardDelete.do") 
	public String boardDelete(@RequestParam int bno) {	
		System.out.println("삭제할 글번호: " + bno);
		boardservice.boardDelete(bno);
		return "redirect:list.do";
	}

}
