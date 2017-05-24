package per.ljh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.ljh.bean.Situation;
import per.ljh.mapper.SituationMapper;

/**
 * 
 * @author Ljh
 *
 */
@Service
@Transactional
public class SituationService {

	@Autowired
	private SituationMapper situationMapper;
	
	/**
	 * 加载全列表
	 * @return
	 */
	public List<Situation> loadSituations() {
		return situationMapper.loadSituations();
	}
	
	/**
	 * 分页加载
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	public List<Situation> loadSituationsByParams(int curPage, int pageSize) {
		return situationMapper.loadSituationsByParams(serviceFilter1(curPage, pageSize));
	}
	
	/**
	 * 添加违法行为
	 * @param situation
	 * @return
	 */
	public boolean insertSituation(Situation situation) {
		situation.setId(UUID.randomUUID().toString());
		return situationMapper.insertSituation(situation) > 0 ? true : false;
	}
	
	/**
	 * 删除违法行为
	 * @param id
	 * @return
	 */
	public boolean delSituationById(String id) {
		return situationMapper.delSituationById(id) > 0 ? true :false;
	}
	
	/**
	 * start、pageSize
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	private static Map<String, Object> serviceFilter1(int curPage, int pageSize) {
		Map<String, Object> params = new HashMap<String, Object>();
		int start = (curPage - 1) * pageSize;
		params.put("start", start);
		params.put("pageSize", pageSize);
		return params;
	}
	
}
