package board.spring.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import board.spring.test.domain.MemberVO;
import board.spring.test.service.MemberService;

@Controller
public class LoginController {
	
	@Autowired
	private MemberService memberservice;
	
	@RequestMapping(value = "/member/login.do")
	public String loginGO() {
		return "login";
	}
	
	@RequestMapping(value = "/member/loginCheck.do")
	public String loginCheck(@ModelAttribute MemberVO membervo, HttpSession session, Model model) {
		boolean result = memberservice.loginCheck(membervo, session);
		
        if (result == true) { // 로그인 성공
            // main.jsp로 이동
            return "redirect:../";
           
        } else {    // 로그인 실패
            return "redirect:/member/login.do";
        }
	}
	
	@RequestMapping(value = "/member/logout.do")
	public String loginout(HttpSession session) {
		memberservice.logout(session);
        return "redirect:../";
	}

}
