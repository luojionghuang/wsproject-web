package per.ljh.bean;

/**
 * 违法行为或隐患情况维护
 * @author Ljh
 *
 */
public class Situation {

	private String id;
	//违法行为或隐患情况
	private String name;
	//顺序，由低到高
	private Integer sort;
	
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
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	
}
