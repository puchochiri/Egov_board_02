package egov.example.board.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import egovframework.rte.psl.dataaccess.mapper.Mapper;

@Mapper(value="BoardDAO")
public interface BoardDAO {

	
	int insertBoard(Map<String,Object> param);
	
	List<Map<String, Object>> selectBoard(Map<String,Object> param);
	
	
}