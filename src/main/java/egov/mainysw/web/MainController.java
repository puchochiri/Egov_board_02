package egov.mainysw.web;

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
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Resource(name="MainService")
	MainService mainService;
	
	
	@RequestMapping(value="/main.do")
	public String main(HttpServletRequest request, ModelMap model)
	{
		return "main/main";
		
	}
	

	
	
	@RequestMapping(value="/main2.do")
	public String main2(HttpServletRequest request, Model model)
	{
		return "main/main2";
	}
	
	//form으로부터 데이트를 
	@RequestMapping(value="/main3.do")
	public String main3(@RequestParam("pw") String pw,HttpServletRequest request, ModelMap model)
	{
		int userNo =  Integer.parseInt(request.getParameter("userNo").toString());
		String id = request.getParameter("id").toString();
		if(id.equals("ysw")){
			model.addAttribute("userid", pw);
		} else 
		{
			model.addAttribute("userid", pw);
		}
		
		userNo = userNo + 5;
		model.addAttribute("userNo", userNo);
		
		return "main/main3";
	}
	
	
	@RequestMapping(value="/main4/{userNo}.do")
	public String main4(@PathVariable String userNo, HttpServletRequest request, ModelMap model)
	{
		model.addAttribute("userNo", userNo);
		return "main/main3";
	}
	
	@RequestMapping(value="/main5.do")
	public String main5(HttpServletRequest request, ModelMap model) throws Exception
	{
		String userid ="";
		//vo
		HashMap<String, Object> paramMap =  new HashMap<String, Object>();
		HashMap<String, Object> resultMap = new HashMap<String, Object>();
		resultMap = mainService.selectMain(paramMap);
		userid = resultMap.get("USER_ID").toString();
		model.addAttribute("serverId",userid);
			
		
		return "main/main3";
		
	}
	
	@RequestMapping(value = "/login.do")
	public String login_ysw(HttpServletRequest request,ModelMap model)
	{
		return "login/login_ysw";
	}
	
	@RequestMapping(value = "/loginSubmissionYsw.do")
	public String loginCheck(HttpServletRequest request, ModelMap model) throws Exception
	{
		String userIdYsw = request.getParameter("id").toString();
		if(userIdYsw.length()>10){
			return "redirect:/login.do";
		}
		
		HashMap<String,Object> paramMapYsw = new HashMap<String, Object>();
		HashMap<String,Object> resultMapYsw = new HashMap<String, Object>();
		
		paramMapYsw.put("userIdYsw", userIdYsw);
		resultMapYsw = mainService.selectLoginYsw(paramMapYsw);
		if(null == resultMapYsw){
			return "redirect:/login.do";
		}
		logger.info("접속 시작 ===============");
		logger.info("debug ysw = {}", resultMapYsw);
		logger.info("접속 끝 ===============");
		request.getSession().setAttribute("USER_ID_YSW", userIdYsw);			
		
		return "main/main4";
	}
	
	@RequestMapping(value = "/login_procedure.do")
	public String login_procedure(HttpServletRequest request,ModelMap model)
	{
		return "login/login_procedure";
	}
	
	@RequestMapping(value = "/loginProcedureResult.do")
	public String loginProcedureCheck(HttpServletRequest request, ModelMap model) throws Exception
	{
		
		String userId = request.getParameter("id").toString();
		//1차하고, javascript로 유효성 체크로 2차 체크
		if(userId.length() > 10)
		{
			return "redirect:/login_procedure.do";
		}
		
		HashMap<String,Object> paramMap = new HashMap<String,Object>();
		
		paramMap.put("userId", userId);
		paramMap.put("ref_cursor", null);
		
		
		mainService.selectLogin2(paramMap);
		ArrayList<HashMap<String,Object>> listBitnal = new ArrayList<HashMap<String,Object>>();
		//ArrayList<HashMap<String,Object>> listBitnal = mainService.selectLogin2(paramMap);
		listBitnal = (ArrayList<HashMap<String,Object>>)paramMap.get("ref_cursor");
		
		
		
		if(listBitnal.size() == 0)
		{
			return "redirect:/login_procedure.do";
		}
		else
		{
			userId = listBitnal.get(0).get("USER_ID").toString();
		}
		
		
		request.getSession().setAttribute("USER_ID", userId);
		
		
		return "main/main6";
	
	}
	
	@RequestMapping(value="/exception.do")
	public String exception(HttpServletRequest request, ModelMap model) throws Exception {
//		return "main/main4";
		
		throw new Exception("사용자 임의 에러발생");
		
	}

}
