package com.school.assessment.exceptions;

import com.school.assessment.exceptions.enums.AssessmentExceptionType;

public class AssessmentException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private final AssessmentExceptionType type;
	private final String requestData;
	private final String responseData;
	private final String headers;
	private final String baseURL;
	private final String messageAR;
	private final String messageEN;
	public AssessmentException(AssessmentExceptionType type, String requestData, String responseData, String headers,
			String baseURL, String messageAR, String messageEN) {
		super();
		this.type = type;
		this.requestData = requestData;
		this.responseData = responseData;
		this.headers = headers;
		this.baseURL = baseURL;
		this.messageAR = messageAR;
		this.messageEN = messageEN;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public AssessmentExceptionType getType() {
		return type;
	}
	public String getRequestData() {
		return requestData;
	}
	public String getResponseData() {
		return responseData;
	}
	public String getHeaders() {
		return headers;
	}
	public String getBaseURL() {
		return baseURL;
	}
	public String getMessageAR() {
		return messageAR;
	}
	public String getMessageEN() {
		return messageEN;
	}
	
	

	
}
