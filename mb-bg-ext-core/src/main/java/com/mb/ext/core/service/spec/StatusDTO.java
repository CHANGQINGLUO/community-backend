package com.mb.ext.core.service.spec;

import com.mb.framework.service.spec.AbstractBaseDTO;

public class StatusDTO extends AbstractBaseDTO {

	private static final long serialVersionUID = 7308629992968567471L;

	private String statuscode;
	private String statusdesc;

	public String getStatuscode() {
		return statuscode;
	}

	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

	public String getStatusdesc() {
		return statusdesc;
	}

	public void setStatusdesc(String statusdesc) {
		this.statusdesc = statusdesc;
	}

}
