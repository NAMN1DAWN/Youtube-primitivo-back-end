package com.youpri.rest.error.exceptions;

public class NewUserWithDifferentPasswordsException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6164880407281883804L;
	
	public NewUserWithDifferentPasswordsException() 
	{
		super("Las contraseñas no coinciden");
	}
	

}
