package per.ljh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import per.ljh.bean.Enterprise;
import per.ljh.bean.plugin.Message;
import per.ljh.service.EnterpriseService;

/**
 * 
 * @author Ljh
 *
 */
@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {

	@Autowired
	private EnterpriseService enterpriseService;
	
	/**
	 * 分页加载企业信息列表
	 * @param curPage
	 * @param pageSize
	 * @return
	 */
	public List<Enterprise> loadEnterprises(Integer curPage, Integer pageSize) {
		if(curPage == null) {
			return null;
		}
		if(pageSize == null) {
			pageSize = 10;
		}
		return enterpriseService.loadEnterprisesByParams(curPage, pageSize);
	}
	
	/**
	 * 录入企业信息
	 * @param name
	 * @param address
	 * @return
	 */
	public Message insertEnterprise(String name, String address) {
		Enterprise enterprise = new Enterprise();
		enterprise.setName(name);
		enterprise.setAddress(address);
		if(enterpriseService.insertEnterprise(enterprise)) {
			return new Message(1, "企业信息录入成功！");
		} else {
			return new Message(0, "企业信息录入失败！");
		}
	}
	
}
