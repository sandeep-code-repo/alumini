package com.rest.dataservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "file_doc")
public class FilePath {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "file_id")
	private Integer fileId;
	
	@Column(name = "file_Name")
	private String fileName;
	
	@Column(name = "file_path")
	private String docPath;
	
	

	public Integer getFileId() {
		return fileId;
	}
	
	

	public void setFileId(Integer fileId) {
		this.fileId = fileId;
	}

	

	public String getDocPath() {
		return docPath;
	}

	public void setDocPath(String docPath) {
		this.docPath = docPath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	
	

}
