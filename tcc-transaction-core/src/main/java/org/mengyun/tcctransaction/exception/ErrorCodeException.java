package org.mengyun.tcctransaction.exception;

import org.mengyun.tcctransaction.api.base.BaseResponse;

public class ErrorCodeException extends RuntimeException {

	private static final long serialVersionUID = 8884917484848018914L;
	
	private BaseResponse baseResponse;

	public ErrorCodeException(BaseResponse baseResponse) {
		super();
		this.baseResponse = baseResponse;
	}
	
	public ErrorCodeException(String msg, BaseResponse baseResponse) {
		super(msg);
		this.baseResponse = baseResponse;
	}

	public BaseResponse getBaseResponse() {
		return baseResponse;
	}
}
