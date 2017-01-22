package spring.mvc.study.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.study.board.BoardService;
import spring.mvc.study.board.BoardVO;

@Controller
public class BoardController {

	//BoardService Ÿ������ �޸𸮿� ����� ��ü�� �ּҸ� ����
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		//���� ���ε� ó��
		
		/*MultipartFile uploadFile = vo.getUploadFile();
		//���ε� ������ �ִ��� üũ
		if(!uploadFile.isEmpty()){
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/"+fileName));
		}
		*/
		boardService.insertBoard(vo);
		return "getBoardList";
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
		return "getBoardList";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "getBoardList";
	}
	/* ����Ÿ���� ModelAndView�� �� ���
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, ModelAndView mav) {
		
		mav.addObject("board", boardService.getBoard(vo)); // Model ���� ����
		mav.setViewName("getBoard.jsp");   // View  ���� ����
		
		return mav;
	}
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, ModelAndView mav) {

		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		mav.addObject("boardList", boardService.getBoardList(vo)); // Model ���� ����
		mav.setViewName("getBoardList.jsp");   // View  ���� ����
		
		return mav;
	}
*/
	//����Ÿ���� String���� �ϰ� �����鼭, DAO���� ������ ������ Model�� ��¹� (���̾�)
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {		
		model.addAttribute("board", boardService.getBoard(vo)); 				
		return "getBoard";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo, Model model) {

		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		model.addAttribute("boardList", boardService.getBoardList(vo)); 				
		
		return "getBoardList";
	}


}







