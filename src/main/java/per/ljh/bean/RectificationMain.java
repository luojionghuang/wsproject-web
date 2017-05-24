package per.ljh.bean;


/**
 * 检查记录
 * @author Ljh
 *
 */
public class RectificationMain {

	private String id;
	//企业ID
	private String enterpriseId;
	//执法检查日期
	private String checkDate;
	//执法检查人员
	private String checkPerson;
	//责任单位
	private String dutyUnit;
	//责任人
	private String dutyPerson;
	//整改完成期限
	private String finishDate;
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
	public String getEnterpriseId() {
		return enterpriseId;
	}
	public void setEnterpriseId(String enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getCheckPerson() {
		return checkPerson;
	}
	public void setCheckPerson(String checkPerson) {
		this.checkPerson = checkPerson;
	}
	public String getDutyUnit() {
		return dutyUnit;
	}
	public void setDutyUnit(String dutyUnit) {
		this.dutyUnit = dutyUnit;
	}
	public String getDutyPerson() {
		return dutyPerson;
	}
	public void setDutyPerson(String dutyPerson) {
		this.dutyPerson = dutyPerson;
	}
	public String getFinishDate() {
		return finishDate;
	}
	public void setFinishDate(String finishDate) {
		this.finishDate = finishDate;
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
