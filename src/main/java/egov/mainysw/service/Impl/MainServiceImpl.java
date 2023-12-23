package egov.mainysw.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import egov.mainysw.dao.MainDAO;
import egov.mainysw.service.MainService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

//@Mapper(value="MainDAO")

@Service("MainService")
public class MainServiceImpl extends EgovAbstractServiceImpl implements MainService{

	
	@Resource(name="MainDAO")
	MainDAO mainDAO;

	@Override
	public HashMap<String, Object> selectMain(HashMap<String, Object> hashMap) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("MainServiceImpl");
		return mainDAO.selectMain(hashMap);
	}

	@Override
	public HashMap<String, Object> selectLoginYsw(HashMap<String, Object> paramMapYsw) throws Exception  {
		// TODO Auto-generated method stub
		return mainDAO.selectLoginYsw(paramMapYsw);
	}

	@Override
	public ArrayList<HashMap<String, Object>> selectLogin2(HashMap<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return mainDAO.selectLogin2(paramMap);
	}
	
}