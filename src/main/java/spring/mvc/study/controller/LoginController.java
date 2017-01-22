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
	//������ Ŭ�����̸��� ù���ڸ� �ҹ��ڷ� �� ��, EL�±׸� �̿��ϳ�, Ư�������� �����ϰ������
	//ModelAttribute�� �̿��Ѵ�.�̷��� �ٲ� �b�� login.jsp���� EL�±� �̿�� userVO�� �ƴ϶� user�� �����ؾ� �Ѵ�.
	//ùȭ�鿡 id�� password�� ���õȴ�. 
	public String loginView(@ModelAttribute("user") UserVO vo) {
		System.out.println("�α��� ȭ������ �̵�");
		vo.setId("test");
		vo.setPassword("test");
		return "login";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("�α��� ���� ó��...");	
		if(userDAO.getUser(vo) != null) return "getBoardList.do";
		else return "login";
	}

}






