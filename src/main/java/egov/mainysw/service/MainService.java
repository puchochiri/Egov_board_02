package egov.mainysw.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface MainService {
	HashMap<String, Object> selectMain(HashMap<String,Object> hashMap) throws Exception;

	HashMap<String, Object> selectLoginYsw(HashMap<String, Object> paramMapYsw) throws Exception;

	ArrayList<HashMap<String, Object>> selectLogin2(HashMap<String, Object> paramMap);
}