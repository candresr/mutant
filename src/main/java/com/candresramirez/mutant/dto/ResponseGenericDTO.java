package com.candresramirez.mutant.dto;

import org.springframework.http.HttpStatus;

public class ResponseGenericDTO {
	
	private boolean success;
	private String message;
	private HttpStatus status;
	
	
	
	public ResponseGenericDTO() {
		super();
	}

	public ResponseGenericDTO(boolean success, String message, HttpStatus status) {
		super();
		this.success = success;
		this.message = message;
		this.status = status;
	}


	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
