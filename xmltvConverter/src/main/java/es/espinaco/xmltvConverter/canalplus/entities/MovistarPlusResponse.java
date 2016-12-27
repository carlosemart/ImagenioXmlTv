package es.espinaco.xmltvConverter.canalplus.entities;

public class MovistarPlusResponse {

	private String success;
	private String msg;
	private ListCanales data;
	public String getSuccess() {
		return success;
	}
	public void setSuccess(String success) {
		this.success = success;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public ListCanales getData() {
		return data;
	}
	public void setData(ListCanales data) {
		this.data = data;
	}

}
