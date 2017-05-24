package per.ljh.bean.branch;


/**
 * RectificationMain分支
 * @author Ljh
 *
 */
public class RectificationMainBranch {

	private String id;
	//执法检查日期
	private String checkDate;
	//企业名称
	private String enterpriseName;
	//是否复查
	private int reviewed;
	//是否立案
	private int recorded;
	//备注
	private String remark;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getEnterpriseName() {
		return enterpriseName;
	}
	public void setEnterpriseName(String enterpriseName) {
		this.enterpriseName = enterpriseName;
	}
	public int getReviewed() {
		return reviewed;
	}
	public void setReviewed(int reviewed) {
		this.reviewed = reviewed;
	}
	public int getRecorded() {
		return recorded;
	}
	public void setRecorded(int recorded) {
		this.recorded = recorded;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
