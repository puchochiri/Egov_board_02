package egov.mainysw.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import egov.mainysw.service.Impl.MainServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"file:src/main/resources/egovframework/spring/context-datasource.xml",
	"file:src/main/resources/egovframework/spring/context-common.xml"
	
})
public class MainServiceTest {
	
	

	//@Resource(name="MainService")
	@Autowired
	private MainServiceImpl mainServiceImpl;
	
	//@Test
	public void  selectMain() throws Exception {
		//MainServiceImpl mainServiceImpl = new MainServiceImpl();
		
		HashMap<String,Object> paramMap = new HashMap<>();
		
		
		HashMap<String,Object> hashMap = mainServiceImpl.selectMain(paramMap);
		
		System.out.println(hashMap);
		
		
	}
	//@Test
	public void selectLoginYsw() {
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("userIdYsw", "user1");
			
			HashMap<String, Object> hashMap = mainServiceImpl.selectLoginYsw(param);
			
			System.out.println("yswHashMap1:" + hashMap);
		} catch (Exception e) {
			e.printStackTrace();

		}
	
		
		
		
		
	}
	
	@Test
	public void selectLogin2Ysw() {
		try {
			HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("userIdYsw", "user1");

			param.put("ref_cursor", null);
			mainServiceImpl.selectLogin2(param);
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
	
