package per.ljh.bean;

import java.util.Date;

/**
 * 企业信息
 * @author Ljh
 *
 */
public class Enterprise {

	//唯一标识
	private String id;
	//执法检查（或复查）企业（场所）名称
	private String name;
	//企业地址
	private String address;
	//创建时间
	private Date createTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
