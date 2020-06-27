package com.eSmartHire.common;


public abstract class AbstractMessage {
	
	public enum Severity{
		INFO,
		VALIDATION,
		ERROR,
		FATAL;
		
		public boolean isInfo() {return this == INFO;}
		public boolean isValidation() {return this == VALIDATION;}
		public boolean isError() {return this == ERROR;}
		public boolean isFatal() {return this == FATAL;}
	}
	
	private final Severity severity;
	
	protected AbstractMessage(Severity severity) {
		this.severity = severity;
	}
	
	public Severity getSeverity() {
		return severity;
	}
}
