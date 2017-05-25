package per.ljh.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import per.ljh.bean.RectificationMain;
import per.ljh.bean.branch.RectificationMainBranch;
import per.ljh.bean.ext.RectificationMainExt;

/**
 * 
 * @author Ljh
 *
 */
public interface RectificationMainMapper {

	/**
	 * 根据id加载
	 * @param id
	 * @return
	 */
	public RectificationMainExt loadRectificationMainById(String id);
	/**
	 * 分页加载
	 * @param params
	 * @return
	 */
	public List<RectificationMainBranch> loadRectificationMainBranchsByParams(Map<String, Object> params);
	/**
	 * 插入检查结果
	 * @param record
	 * @return
	 */
	public int insertRectificationMain(@Param("main")RectificationMain main);
	
}
