package board.spring.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import board.spring.test.domain.MemberVO;
import board.spring.test.service.MemberService;

@Controller
@RequestMapping
public class MemberController {

	@Autowired
	private MemberService memberservice;

	// private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	// 1. 회원목록
	@RequestMapping(value = "/member/list.do")
	public ModelAndView selectList() {
		List<MemberVO> memberList = memberservice.memberList();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member_list");
		mav.addObject("list", memberList);
		return mav;
	}

	// 2-1. 회원가입하러 가기
	@RequestMapping(value = "/member/join.do")
	public String memberJoinGo() {
		return "member_join";
	}

	// 2-2. 회원가입하기
	@RequestMapping(value = "/member/insert.do", method = RequestMethod.POST)
	public String memberJoin(@ModelAttribute MemberVO membervo) {
		memberservice.memberInsert(membervo);
		return "redirect:list.do";
	}

	// 3. 회원 상세정보
	@RequestMapping(value = "/member/memberInfo.do", method = RequestMethod.GET)
	public ModelAndView memberInfo(@RequestParam String userid) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member_info");
		mav.addObject("membervo", memberservice.memberInfo(userid));

		return mav;
	}

	// 4. 회원정보 수정
	@RequestMapping(value = "/member/memberUpdate.do", method = RequestMethod.POST)
	public String memberUpdate(@ModelAttribute MemberVO membervo, Model model) {

		boolean result = memberservice.checkPWD(membervo.getUserid(), membervo.getUserpwd());
		if (result) {
			memberservice.memberUpdate(membervo);
			return "redirect:list.do";
		} else {
			MemberVO vo2 = memberservice.memberInfo(membervo.getUserid());
			membervo.setUserregdate(vo2.getUserregdate());
			membervo.setUserupdatedate(vo2.getUserupdatedate());
			model.addAttribute("membervo", membervo);
			model.addAttribute("message", "비밀번호 불일치");
			return "member_info";
		}

	}

	// 5. 회원 삭제
	@RequestMapping(value="/member/delete.do", method = RequestMethod.POST)
    public String memberDelete(@RequestParam String userid, @RequestParam String userpwd, Model model){
        // 비밀번호 체크
        boolean result = memberservice.checkPWD(userid, userpwd);
        if(result){ // 비밀번호가 맞다면 삭제 처리후, 전체 회원 목록으로 리다이렉트
            memberservice.memberDelete(userid);
            return "redirect:list.do";
        } else { // 비밀번호가 일치하지 않는다면, div에 불일치 문구 출력, viwe.jsp로 포워드
            model.addAttribute("message", "비밀번호 불일치");
            model.addAttribute("membervo", memberservice.memberInfo(userid));
            return "member_info";
        }
    }
}
