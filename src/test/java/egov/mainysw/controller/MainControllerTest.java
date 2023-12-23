package egov.mainysw.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({
	"file:src/main/resources/egovframework/spring/context-datasource.xml",
	"file:src/main/resources/egovframework/spring/context-common.xml",
	"file:src/main/webapp/WEB-INF/config/egovframework/springmvc/dispatcher-servlet.xml",
})
public class MainControllerTest {
	
	
	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	public void setWebApplicationContext(WebApplicationContext webApplicationContext){
		this.wac = webApplicationContext;
	}
	
	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void  selectMain() throws Exception {
		//MainServiceImpl mainServiceImpl = new MainServiceImpl();
		
		System.out.println(
				"selectMain: " + 
//				this.mockMvc.perform(get("/main5.do").accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
				this.mockMvc.perform(post("/main5.do").accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
				.andExpect(status().isOk())
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
		
		
		
		
	}
	
	
	@Test
	public void  LoginCheck() throws Exception {
		//MainServiceImpl mainServiceImpl = new MainServiceImpl();
		
		System.out.println(
				"selectMain: " + 
//				this.mockMvc.perform(get("/main5.do").accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
				this.mockMvc.perform(post("/loginSubmissionYsw.do")
						.param("userIdYsw", "user1")
						.accept(MediaType.parseMediaType("application/html;charset=UTF-8")))
				.andExpect(status().isOk())
				.andReturn()
				.getModelAndView()
				.getModelMap()
				);
		
		
		
		
	}
	
}