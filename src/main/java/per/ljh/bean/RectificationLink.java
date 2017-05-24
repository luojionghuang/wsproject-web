package per.ljh.bean;

/**
 * 整改信息
 * @author Ljh
 *
 */
public class RectificationLink {

	private String id;
	//检查记录表ID
	private String rectificationMainId;
	//situation表对应ID，违法行为或隐患情况
	private String situationId;
	//整改落实情况或处置措施
	private String method;
	//违法行为或隐患所在部位
	private String part;
	//备注
	private String remark;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRectificationMainId() {
		return rectificationMainId;
	}
	public void setRectificationMainId(String rectificationMainId) {
		this.rectificationMainId = rectificationMainId;
	}
	public String getSituationId() {
		return situationId;
	}
	public void setSituationId(String situationId) {
		this.situationId = situationId;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getPart() {
		return part;
	}
	public void setPart(String part) {
		this.part = part;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}
