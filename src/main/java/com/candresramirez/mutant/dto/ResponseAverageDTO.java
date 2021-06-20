package com.candresramirez.mutant.dto;

import org.springframework.http.HttpStatus;

public class ResponseAverageDTO {

	private Object data;
	private boolean success;
	private HttpStatus status;
	
	public ResponseAverageDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResponseAverageDTO(Object data, boolean success, HttpStatus status) {
		super();
		this.data = data;
		this.success = success;
		this.status = status;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
