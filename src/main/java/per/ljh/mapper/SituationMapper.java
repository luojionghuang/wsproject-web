package per.ljh.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import per.ljh.bean.Situation;

/**
 * 
 * @author Ljh
 *
 */
public interface SituationMapper {

	/**
	 * 加载全列表
	 * @return
	 */
	public List<Situation> loadSituations();
	/**
	 * 分页加载违法行为
	 * @param params
	 * @return
	 */
	public List<Situation> loadSituationsByParams(Map<String, Object> params);
	/**
	 * 添加违法行为
	 * @param situation
	 * @return
	 */
	public int insertSituation(@Param("situation")Situation situation);
	/**
	 * 根据id删除违法行为
	 * @param id
	 * @return
	 */
	public int delSituationById(String id);
	
}
