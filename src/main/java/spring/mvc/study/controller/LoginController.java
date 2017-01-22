package spring.mvc.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.study.user.UserDAO;
import spring.mvc.study.user.UserVO;

@Controller
public class LoginController {
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	//보통은 클래스이름의 첫글자를 소문자로 한 뒤, EL태그를 이용하나, 특정명으로 지정하고싶으면
	//ModelAttribute를 이용한다.이렇게 바꿀 꼉우 login.jsp에서 EL태그 이용시 userVO가 아니라 user로 변경해야 한다.
	//첫화면에 id와 password가 셋팅된다. 
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test");
		return "login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("로그인 인증 처리...");	
		if(userDAO.getUser(vo) != null) return "getBoardList.do";
		else return "login";
	}

}






