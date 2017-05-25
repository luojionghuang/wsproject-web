package per.ljh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.ljh.bean.RectificationMain;
import per.ljh.bean.branch.RectificationMainBranch;
import per.ljh.bean.ext.RectificationMainExt;
import per.ljh.mapper.RectificationMainMapper;

/**
 * 
 * @author Ljh
 *
 */
@Service
@Transactional
public class RectificationMainService {

	@Autowired
	private RectificationMainMapper checkRecordMapper;
	
	/**
	 * 根据id加载
	 * @param id
	 * @return
	 */
	public RectificationMainExt loadRectificationMainById(String id) {
		return checkRecordMapper.loadRectificationMainById(id);
	}
	
	/**
	 * 分页加载
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	public List<RectificationMainBranch> loadRectificationMainBranchsByParams(int curPage, int pageSize) {
		return checkRecordMapper.loadRectificationMainBranchsByParams(serviceFilter1(curPage, pageSize));
	}
	
	/**
	 * 添加检查记录
	 * @param record
	 * @return
	 */
	public boolean insertCheckRecord(RectificationMain main) {
		main.setId(UUID.randomUUID().toString());
		return checkRecordMapper.insertRectificationMain(main) > 0 ? true : false;
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
