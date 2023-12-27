package egov.mainysw.mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egov.example.board.dao.BoardDAO;
import egov.mainysw.dao.MainDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/egovframework/spring/context-datasource.xml")
public class BoardDaoTest {
	
	
	/*@Resource(name="MainDAO")
	MainDAO mainDAO;*/
	
	@Resource(name="BoardDAO")
	private BoardDAO boardDAO;
	
	@Test
	public void  selectBoard() throws Exception {
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		List<Map<String,Object>> listMap = new ArrayList<Map<String, Object>>(); 
		
		
		
		listMap = boardDAO.selectBoard(paramMap);
		
		System.out.println("selectBoard listMap: " + listMap);
		
		for (Map<String, Object> map : listMap) {
			System.out.println("selectBoard map:" + map);
		}
		
		
	}
	
	
}