package com.heymom.backend.dto;

public class APIResult<T> {
	private T body;
	private int returnCode = 0;
	private String trackId;

	public APIResult() {
		super();
	}

	public APIResult(T body) {
		super();
		this.body = body;
	}

	public T getBody() {
		return body;
	}

	public int getReturnCode() {
		return returnCode;
	}

	public String getTrackId() {
		return trackId;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public void setReturnCode(int returnCode) {
		this.returnCode = returnCode;
	}

	public void setTrackId(String trackId) {
		this.trackId = trackId;
	}

}
