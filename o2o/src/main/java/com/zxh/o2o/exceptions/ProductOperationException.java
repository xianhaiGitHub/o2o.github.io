package com.zxh.o2o.exceptions;

public class ProductOperationException extends RuntimeException{
	
	private static final long serialVersionUID = 6224591432062897740L;
	
	public ProductOperationException(String msg){
		super(msg);
	}
}
