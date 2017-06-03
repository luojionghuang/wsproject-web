package per.ljh.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.ljh.bean.RectificationLink;
import per.ljh.bean.RectificationMain;
import per.ljh.bean.branch.RectificationMainBranch;
import per.ljh.bean.ext.RectificationMainExt;
import per.ljh.mapper.RectificationLinkMapper;
import per.ljh.mapper.RectificationMainMapper;

/**
 * 
 * @author Ljh
 *
 */
@Service
public class RectificationMainService {

	@Autowired
	private RectificationMainMapper rectificationMainMapper;
	@Autowired
	private RectificationLinkMapper rectificationLinkMapper;
	
	/**
	 * 根据id加载
	 * @param id
	 * @return
	 */
	public RectificationMainExt loadRectificationMainById(String id) {
		return rectificationMainMapper.loadRectificationMainById(id);
	}
	
	/**
	 * 分页总数
	 * @return
	 */
	public int loadCountByParams() {
		return rectificationMainMapper.loadCountByParams(new HashMap<String, Object>());
	}
	
	/**
	 * 分页加载
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	public List<RectificationMainBranch> loadRectificationMainBranchsByParams(int curPage, int pageSize) {
		return rectificationMainMapper.loadRectificationMainBranchsByParams(serviceFilter1(curPage, pageSize));
	}
	
	/**
	 * 添加检查记录
	 * @param record
	 * @return
	 */
	@Transactional
	public boolean insertRectificationMain(RectificationMain main) {
		main.setId(UUID.randomUUID().toString());
		return rectificationMainMapper.insertRectificationMain(main) > 0 ? true : false;
	}
	
	/**
	 * 修改
	 * @param main
	 * @return
	 */
	@Transactional
	public boolean modifyRectification(RectificationMainExt main) {
		try {
			//修改主表信息
			rectificationMainMapper.modifyRectificationMain(main);
			//获取明细
			List<RectificationLink> links = main.getLinks();
			if(links != null) {
				//先删除明细行
				List<String> noDelIds = new ArrayList<String>();
				for(RectificationLink link : links) {
					if(!StringUtils.isBlank(link.getId())) {
						noDelIds.add(link.getId());
					}
				}
				if(noDelIds.size() > 0) {
					rectificationLinkMapper.delRectificationLinkNotIn(serviceFilter2(main.getId(), noDelIds));
				}
				//做添加修改
				for(RectificationLink link : links) {
					if(StringUtils.isBlank(link.getId())) {//如果id为空，则添加
						link.setId(UUID.randomUUID().toString());
						link.setRectificationMainId(main.getId());
						rectificationLinkMapper.insertRectificationLink(link);
					} else {
						rectificationLinkMapper.modifyRectificationLink(link);
					}
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
	
	private static Map<String, Object> serviceFilter2(String mainId, List<String> list) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("mainId", mainId);
		params.put("list", list);
		return params;
	}
	
}
