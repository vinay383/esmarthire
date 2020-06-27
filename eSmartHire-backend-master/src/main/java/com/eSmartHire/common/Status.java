package com.eSmartHire.common;

import org.slf4j.MDC;

import lombok.Data;


@Data
public class Status {

	private String statusMessage;
	private String messageKey;
	private String statusCode;
	private StatusLevel statusLevel;
	private String uniqueId;
	
	public static enum StatusLevel{
		Warning, Exception,Info;
	}
	
	public Status() {}
	
	public Status(StatusLevel statusLevel, String statusCode, String messageKey, Object... messageParams) {
		this.messageKey = messageKey;
		this.statusMessage = MessageManager.getMessage(statusLevel, messageKey, messageParams);
		this.statusLevel = statusLevel;
		this.statusCode = statusCode;
		this.uniqueId = MDC.get("UUID");
	}
}
