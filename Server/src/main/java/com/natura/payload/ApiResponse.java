package com.natura.payload;



public class ApiResponse {

    private String Message;

	public ApiResponse(String M) {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	@Override
	public String toString() {
		return "ApiResponse [Message=" + Message + "]";
	}

	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}   


}
