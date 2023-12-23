package egov.mainysw.mapper;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egov.mainysw.dao.MainDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/egovframework/spring/context-datasource.xml")
public class MainDaoTest {
	
	
	/*@Resource(name="MainDAO")
	MainDAO mainDAO;*/
	
	@Resource(name="MainDAO")
	private MainDAO maindao;
	
	@Test
	public void  selectMain() throws Exception {
		
		HashMap<String,Object> paramMap = new HashMap<>();
		
		
		
		HashMap<String,Object> hashMap = maindao.selectMain(paramMap);
		
		System.out.println(hashMap);
		
		
	}
	
	@Test
	public void selectLoginYsw() {
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("userIdYsw", "user1");
			
			HashMap<String, Object> hashMap = maindao.selectLoginYsw(param);
			
			System.out.println("yswHashMap:" + hashMap);
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	
	//@Test
	public void selectLogin2Ysw() {
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("userIdYsw", "user1");

			param.put("ref_cursor", null);
			maindao.selectLogin2(param);
			ArrayList<HashMap<String,Object>> listBitnal = new ArrayList<HashMap<String,Object>>();
			listBitnal = (ArrayList<HashMap<String,Object>>)param.get("ref_cursor");

			
			//ArrayList<HashMap<String, Object>> listBitnal = maindao.selectLogin2(param);
			String userId = null;
			if(!listBitnal.isEmpty()){
				userId = listBitnal.get(0).get("USER_ID").toString();
			}
			
			System.out.println("selectLogin2: " + userId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}