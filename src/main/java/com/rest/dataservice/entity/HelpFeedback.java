package com.rest.dataservice.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "help_feedback")
public class HelpFeedback implements Serializable{

	/**
	 * @Kamal
	 * @Date-29/09/2020
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user_name", nullable=false)
	private String  userName;
	
	@Column(name = "email", nullable=false)
	private String  email;
	
	@Column(name = "mob_no")
	private String  mobNo;
	
	@Column(name = "query")
	private String  query;
	
	@Column(name = "comment")
	private String  comment;
	
	@Column(name="feedback_status")
	private Boolean feedbackStatus;
	
	@Column(name = "created_by")
	private String  createdBy;
	
	@Column(name = "created_dt")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date  createdDt;
	
	@Column(name = "last_modified_by")
	private String  lastModifiedBy;
	
	@Column(name="last_modified_dt")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private String lastModifiedDt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Boolean getFeedbackStatus() {
		return feedbackStatus;
	}

	public void setFeedbackStatus(Boolean feedbackStatus) {
		this.feedbackStatus = feedbackStatus;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getLastModifiedDt() {
		return lastModifiedDt;
	}

	public void setLastModifiedDt(String lastModifiedDt) {
		this.lastModifiedDt = lastModifiedDt;
	}

	@Override
	public String toString() {
		return "HelpFeedback [id=" + id + ", userName=" + userName + ", email=" + email + ", mobNo=" + mobNo
				+ ", query=" + query + ", comment=" + comment + ", feedbackStatus=" + feedbackStatus + ", createdBy="
				+ createdBy + ", createdDt=" + createdDt + ", lastModifiedBy=" + lastModifiedBy + ", lastModifiedDt="
				+ lastModifiedDt + "]";
	}

	
	
    
}
