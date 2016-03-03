package com.voyagerproject.model;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * BugSystemType generated by hbm2java
 */
@Entity
@Table(name = "bugsystemtype", catalog = "Voyager")
public class BugSystemType implements java.io.Serializable {

	private static final long serialVersionUID = 2908259411074500774L;
	private int idBugSystemType;
	private String name;
	private Date createdOn;
	private String createdBy;

	public BugSystemType() {
	}

	public BugSystemType(int idBugSystemType, String name, Date createdOn, String createdBy) {
		this.idBugSystemType = idBugSystemType;
		this.name = name;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}

	@Id
	@Column(name = "idBugSystemType", unique = true, nullable = false)
	public int getIdBugSystemType() {
		return this.idBugSystemType;
	}

	public void setIdBugSystemType(int idBugSystemType) {
		this.idBugSystemType = idBugSystemType;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdOn", length = 19, insertable = false)
	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	@Column(name = "createdBy", nullable = false, length = 100)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
