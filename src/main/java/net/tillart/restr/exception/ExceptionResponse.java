package net.tillart.restr.exception;

import java.util.Date;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
public class ExceptionResponse {
	
	@Getter
	private Date timestamp;
	@Getter
	private String message;
	@Getter
	private String details;

}
