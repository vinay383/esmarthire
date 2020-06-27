package com.eSmartHire.common;


public class Message extends AbstractMessage{
	
	private final String message;
	
	private Message(String message, Severity severity) {
		super(severity);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}
	
	public static Message as(String message, Severity severity) {return new Message(message, severity);}
	
	public static Message info(String message) {return new Message(message, Severity.INFO);}
	
	public static Message validation(String message) {return new Message(message, Severity.VALIDATION);}
	
	public static Message error(String message) {return new Message(message, Severity.ERROR);}
	
	public static Message fatal(String message) {return new Message(message, Severity.FATAL);}

}
