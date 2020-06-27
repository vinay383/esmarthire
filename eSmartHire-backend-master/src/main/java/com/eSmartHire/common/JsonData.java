package com.eSmartHire.common;

public class JsonData {

	private boolean validation;
	private String message;
	//private long offerId;
	private Object data;
	private int totalCount;
	private boolean success;
	
	//private List<Object> additionalData;
	
	//private Object children;
	private Status status;
	private String pageNumber;
	
	private static final ThreadLocal<Integer> errorFlag = new ThreadLocal<Integer>();
	private static final ThreadLocal<String> errorMessage = new ThreadLocal<String>();
	
	public JsonData(boolean success, Status status, Object data) {
		this.success = success;
		this.status = status;
		this.data = data;
	}
	
	public JsonData(boolean success, Object data) {
		this(success, null, data);
	}
	
	public JsonData() { this(true, null);}
	
	public void setValidation(boolean validation) {
		this.validation = validation;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*
	 * public long getOfferId() { return offerId; }
	 * 
	 * public void setOfferId(long offerId) { this.offerId = offerId; }
	 */

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public String getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}

	public boolean isValidation() {
		return validation;
	}

	public Status getStatus() {
		return status;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	
	/*
	 * public List<Object> getAdditionalData() { return additionalData; }
	 * 
	 * public void setAdditionalData(List<Object> additionalData) {
	 * this.additionalData = additionalData; }
	 * 
	 * public Object getChildren() { return children; }
	 * 
	 * public void setChildren(Object children) { this.children = children; }
	 */

	public static JsonData STATUS_401() {
		JsonData jsonData = new JsonData();
		jsonData.setSuccess(false);
		Status exception = new Status(Status.StatusLevel.Exception,"401", "UnauthorisedUser");
		jsonData.setMessage(exception.getStatusMessage());
		return jsonData;
	}
	
	public static JsonData INTERNAL_SERVER_ERROR(String messageKey) {
		JsonData jsonData = new JsonData();
		jsonData.setSuccess(false);
		Status exception = new Status(Status.StatusLevel.Exception,"500", messageKey);
		jsonData.setMessage(exception.getStatusMessage());
		errorFlag.set(1);
		errorMessage.set(jsonData.getMessage());
		return jsonData;
	}
	
	public static JsonData INTERNAL_SERVER_ERROR_WITH_TEXT(String messageText) {
		JsonData jsonData = new JsonData();
		jsonData.setSuccess(false);
		Status exception = new Status(Status.StatusLevel.Exception,"500", "Unexpected.Error");
		exception.setStatusMessage(messageText);
		jsonData.setMessage(exception.getStatusMessage());
		errorFlag.set(1);
		errorMessage.set(jsonData.getMessage());
		return jsonData;
	}
	
	public static JsonData ERRORSTATUS_WITH_DIRECT_MESSAGE(String messageKey) {
		JsonData jsonData = new JsonData();
		jsonData.setSuccess(false);
		Status exception = new Status(Status.StatusLevel.Exception,"500", messageKey);
		jsonData.setMessage(exception.getStatusMessage());
		errorFlag.set(1);
		errorMessage.set(jsonData.getMessage());
		return jsonData;
	}
	
	public static JsonData ERROR_WITH_DIRECT_MESSAGE(String messageText) {
		JsonData jsonData = new JsonData();
		jsonData.setSuccess(false);
		jsonData.setMessage(messageText);
		errorFlag.set(1);
		errorMessage.set(jsonData.getMessage());
		return jsonData;
	}
	
	public static JsonData SUCCESS_RESPONSE_WITH_DIRECT_MESSAGE(String messageText) {
		JsonData jsonData = new JsonData();
		jsonData.setSuccess(true);
		jsonData.setMessage(messageText);
		return jsonData;
	}
	
	public static JsonData SUCCESS_RESPONSE(String messageKey) {
		JsonData jsonData = new JsonData();
		jsonData.setSuccess(true);
		Status success = new Status(Status.StatusLevel.Info,"200", messageKey);
		jsonData.setMessage(success.getStatusMessage());
		jsonData.setStatus(success);
		return jsonData;
	}
	
	public static JsonData SUCCESS_RESPONSE_WITH_STATUS() {
		JsonData jsonData = new JsonData();
		jsonData.setSuccess(true);
		return jsonData;
	}
	
	public static JsonData SUCCESS_RESPONSE() {
		return SUCCESS_RESPONSE("successful");
	}
	
	public JsonData withData(Object data) {
		this.data = data;
		return this;
	}
	
	/*
	 * public JsonData withAdditionalData(Object data) { if(this.additionalData ==
	 * null) { this.additionalData = new ArrayList<Object>(); }
	 * this.additionalData.add(data); return this; }
	 */
}
