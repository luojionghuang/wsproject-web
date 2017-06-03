package per.ljh.bean.plugin;

import java.util.List;

/**
 * 分页插件
 * @author Administrator
 *
 * @param <T>
 */
public class PagePlugin<T> {

	private int curPage;
	private int total;
	private List<T> list;
	
	public int getCurPage() {
		return curPage;
	}
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	
}
