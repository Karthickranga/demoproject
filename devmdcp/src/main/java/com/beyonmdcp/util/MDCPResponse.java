package com.beyonmdcp.util;

public class MDCPResponse<T> { 
	private Integer code;
	
	private String message;
	
	private T data;
	
	public MDCPResponse(Integer code, String message, T data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}
	
public MDCPResponse(Integer code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

public MDCPResponse() {
	
}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
}

