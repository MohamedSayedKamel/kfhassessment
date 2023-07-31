package com.school.assessment.exceptions.enums;

public enum AssessmentExceptionType {
	
	BAD_REQUEST("BAD_REQUEST","Bad Request");
	
	
	private String errorCode;
	private String errorMessage;

	private AssessmentExceptionType(String errorCode, String message) {
		this.errorCode = errorCode;
		this.errorMessage = message;
	}
	
	private AssessmentExceptionType() {
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	
}
