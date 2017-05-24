package per.ljh.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import per.ljh.bean.Enterprise;

/**
 * 
 * @author Ljh
 *
 */
public interface EnterpriseMapper {

	/**
	 * start#pageSize
	 * @param params
	 * @return
	 */
	List<Enterprise> loadEnterprisesByParams(Map<String, Object> params);
	/**
	 * 添加企业信息
	 * @param enterprise
	 * @return
	 */
	int insertEnterprise(@Param("enterprise")Enterprise enterprise);
	/**
	 * 根据id删除企业信息
	 * @param id
	 * @return
	 */
	int delEnterpriseById(String id);
	
}
