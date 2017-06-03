package per.ljh.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import per.ljh.bean.Enterprise;
import per.ljh.mapper.EnterpriseMapper;

/**
 * 
 * @author Ljh
 *
 */
@Service
@Transactional
public class EnterpriseService {

	@Autowired
	private EnterpriseMapper enterpriseMapper;
	
	/**
	 * 分页企业信息
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	public List<Enterprise> loadEnterprisesByParams(int curPage, int pageSize) {
		return enterpriseMapper.loadEnterprisesByParams(serviceFilter1(curPage, pageSize));
	}
	
	public List<Enterprise> loadEnterprises() {
		return enterpriseMapper.loadEnterprises();
	}
	
	/**
	 * 添加企业信息
	 * @param enterprise
	 * @return
	 */
	public boolean insertEnterprise(Enterprise enterprise) {
		enterprise.setId(UUID.randomUUID().toString());
		return enterpriseMapper.insertEnterprise(enterprise) > 0 ? true : false;
	}
	
	/**
	 * 根据id删除企业信息
	 * @param id
	 * @return
	 */
	public boolean delEnterpriseById(String id) {
		return enterpriseMapper.delEnterpriseById(id) > 0 ? true : false;
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
