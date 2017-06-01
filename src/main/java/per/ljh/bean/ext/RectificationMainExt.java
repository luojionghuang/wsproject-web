package per.ljh.bean.ext;

import java.util.List;

import per.ljh.bean.RectificationLink;
import per.ljh.bean.RectificationMain;

/**
 * RectificationMain拓展类
 * @author Geniux
 *
 */
public class RectificationMainExt extends RectificationMain {

	//企业名称
	private String enterpriseName;
	//企业地址
	private String enterpriseAddress;
	//明细表关联
	private List<RectificationLink> links;
	
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public String getEnterpriseAddress() {
		return enterpriseAddress;
	}
	public void setEnterpriseAddress(String enterpriseAddress) {
		this.enterpriseAddress = enterpriseAddress;
	}
	public List<RectificationLink> getLinks() {
		return links;
	}
	public void setLinks(List<RectificationLink> links) {
		this.links = links;
	}
	
}
