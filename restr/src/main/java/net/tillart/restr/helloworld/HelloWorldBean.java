package net.tillart.restr.helloworld;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

public class HelloWorldBean {

	@Getter
	@Setter
	private String message;

	public HelloWorldBean(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "HelloWorldBean [message=" + message + "]";
	}

}
