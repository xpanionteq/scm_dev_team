package com.xpanion.scm.model;
/*
 * @author : ASHLIN ABRAHAM
 * @date : 29.04.2019
 * 
 */

public class FileUploadModel {
	private String fileName;
	private String fileDownloadUri;
	private String fileType;

	public FileUploadModel(String fileName, String fileDownloadUri, String fileType) {
		this.fileName = fileName;
		this.fileDownloadUri = fileDownloadUri;
		this.fileType = fileType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileDownloadUri() {
		return fileDownloadUri;
	}

	public void setFileDownloadUri(String fileDownloadUri) {
		this.fileDownloadUri = fileDownloadUri;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

}
