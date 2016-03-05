package com.voyagerproject.model;
// Generated Feb 27, 2016 12:34:42 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * UserTypePermission generated by hbm2java
 */
@Entity
@Table(name = "usertypepermission", catalog = "Voyager")
public class UserTypePermission implements java.io.Serializable {

	private static final long serialVersionUID = -565238122294309571L;
	private int idUserTypePermission;
	private UserType userType;
	private Permission permission;
	private String value;
	private Date createdOn;
	private String createdBy;

	public UserTypePermission() {
	}

	public UserTypePermission(int idUserTypePermission, UserType userType, Permission permission, Date createdOn,
			String createdBy) {
		this.idUserTypePermission = idUserTypePermission;
		this.userType = userType;
		this.permission = permission;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}

	public UserTypePermission(int idUserTypePermission, UserType userType, Permission permission, String value, Date createdOn,
			String createdBy) {
		this.idUserTypePermission = idUserTypePermission;
		this.userType = userType;
		this.permission = permission;
		this.value = value;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}
	
	public UserTypePermission(UserType userType, Permission permission, String value, Date createdOn,
			String createdBy) {
		this.userType = userType;
		this.permission = permission;
		this.value = value;
		this.createdOn = createdOn;
		this.createdBy = createdBy;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idUserTypePermission", unique = true, nullable = false)
	public int getIdUserTypePermission() {
		return this.idUserTypePermission;
	}

	public void setIdUserTypePermission(int idUserTypePermission) {
		this.idUserTypePermission = idUserTypePermission;
	}

	@OneToOne
    @JoinColumn(name = "userType", nullable = false)
	public UserType getUserType() {
		return this.userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}

	@OneToOne
    @JoinColumn(name = "permission", nullable = false)
	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	@Column(name = "value", length = 45)
	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
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
