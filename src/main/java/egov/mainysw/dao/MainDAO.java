package egov.mainysw.dao;

import java.util.ArrayList;
import java.util.HashMap;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper(value="MainDAO")
public interface MainDAO {
	HashMap<String, Object> selectMain(HashMap<String,Object> hashMap) throws Exception;

	HashMap<String, Object> selectLoginYsw(HashMap<String, Object> paramMapYsw) throws Exception;

	ArrayList<HashMap<String, Object>> selectLogin2(HashMap<String, Object> param);
}