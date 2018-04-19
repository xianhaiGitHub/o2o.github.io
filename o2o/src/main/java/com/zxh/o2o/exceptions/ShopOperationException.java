package com.zxh.o2o.exceptions;

/**
 * 店铺异常消息
 * @author zhaoxianhai
 * 2018年4月3日
 * @version 1.0
 */
public class ShopOperationException extends RuntimeException {
	
	private static final long serialVersionUID = -1101550684542176328L;

	public ShopOperationException(String msg) {
		super(msg);
	}
}
