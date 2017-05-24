package per.ljh.bean.plugin;

/**
 * 消息类
 * @author Ljh
 *
 */
public class Message {

	//0-失败；1-成功
	private int status;
	//提示信息
	private String msg;
	//返回对象模型
	private Object data;
	
	public Message() {}
	
	public Message(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}
	
	public Message(int status, Object data) {
		this.status = status;
		this.data = data;
	}
	
	public Message(int status, String msg, Object data) {
		this(status, msg);
		this.data = data;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
