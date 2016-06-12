package org.mengyun.tcctransaction.api.base;

import java.io.Serializable;

public class BaseResponse implements Serializable {

	private static final long serialVersionUID = 3270815371187593767L;

	private String errorCode;

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
}
