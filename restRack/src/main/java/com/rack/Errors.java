package com.rack;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "errors")
public class Errors {
	private Collection<ApplicationError> errors = new ArrayList<ApplicationError>();

	@XmlElement(name = "error")
	public Collection<ApplicationError> getErrors() {
		return errors;
	}

	public void setErrors(Collection<ApplicationError> errors) {
		this.errors = errors;
	}

	public void add(ApplicationError e) {
		if (getErrors() == null) {
			errors = new ArrayList<ApplicationError>();
		}
		getErrors().add(e);
	}

}
