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

	//BoardService 타입으로 메모리에 선언된 객체의 주소를 따라감
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IllegalStateException, IOException {
		//파일 업로드 처리
		
		/*MultipartFile uploadFile = vo.getUploadFile();
		//업로드 정보가 있는지 체크
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
	/* 리턴타입을 ModelAndView로 할 경우
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, ModelAndView mav) {
		
		mav.addObject("board", boardService.getBoard(vo)); // Model 정보 저장
		mav.setViewName("getBoard.jsp");   // View  정보 저장
		
		return mav;
	}
	
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, ModelAndView mav) {

		if(vo.getSearchCondition() == null) vo.setSearchCondition("TITLE");
		if(vo.getSearchKeyword() == null) vo.setSearchKeyword("");
		
		mav.addObject("boardList", boardService.getBoardList(vo)); // Model 정보 저장
		mav.setViewName("getBoardList.jsp");   // View  정보 저장
		
		return mav;
	}
*/
	//리턴타입을 String으로 하고 싶으면서, DAO에서 추출한 정보를 Model에 담는법 (많이씀)
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







