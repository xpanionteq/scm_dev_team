package com.xpanion.scm.exception;
/*
 * @author : ASHLIN ABRAHAM
 * @date : 29.04.2019
 * 
 */

public class FileStorageException extends RuntimeException {
	public FileStorageException(String message) {
		super(message);
	}

	public FileStorageException(String message, Throwable cause) {
		super(message, cause);
	}

}
