package per.ljh.mapper;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import per.ljh.bean.RectificationLink;

/**
 * 
 * @author Ljh
 *
 */
public interface RectificationLinkMapper {

	/**
	 * 添加
	 * @param link
	 * @return
	 */
	int insertRectificationLink(@Param("link")RectificationLink link);
	/**
	 * 修改
	 * @param link
	 * @return
	 */
	int modifyRectificationLink(@Param("link")RectificationLink link);
	/**
	 * not in删除
	 * @param params mainId  list
	 * @return
	 */
	int delRectificationLinkNotIn(Map<String, Object> params);
	
}
