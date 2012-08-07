package com.rack;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "error")
public class ApplicationError {
	private String code;
	private String message;

	public ApplicationError() {
		super();
	}

	public ApplicationError(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
