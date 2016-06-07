package com.mb.ext.core.service.spec;

import com.mb.framework.service.spec.AbstractBaseDTO;

public class ResponseDTO<T> extends AbstractBaseDTO {

	private static final long serialVersionUID = 5069755318813643726L;

	private HeaderDTO header;

	private T body;

	private StatusDTO status;

	public HeaderDTO getHeader() {
		return header;
	}

	public void setHeader(HeaderDTO header) {
		this.header = header;
	}

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	public StatusDTO getStatus() {
		return status;
	}

	public void setStatus(StatusDTO status) {
		this.status = status;
	}

}
