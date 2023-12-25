package egov.example.board.web;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import egov.mainysw.service.MainService;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
//	@Resource(name="MainService")
//	MainService mainService;
	
	
	@RequestMapping(value="/boardWriter.do")
	public String main(HttpServletRequest request, ModelMap model)
	{
		return "board/boardWrite";
		
	}
	

	
}
