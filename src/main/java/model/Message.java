package model;

public class Message {
	
	private String code;
	private String message;
	private String error;
	
	public final String getCode() {
		return code;
	}
	public final void setCode(String code) {
		this.code = code;
	}
	public final String getMessage() {
		return message;
	}
	public final void setMessage(String message) {
		this.message = message;
	}
	public final String getError() {
		return error;
	}
	public final void setError(String error) {
		this.error = error;
	}

}
