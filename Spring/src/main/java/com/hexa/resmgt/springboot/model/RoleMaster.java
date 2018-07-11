package com.hexa.resmgt.springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t002_role_master")
public class RoleMaster implements Serializable{

	private static final long serialVersionUID = -2380428494507380773L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ROLE_ID")
	private long id;
		
	@Column(name="ROLE_CDE")
	private String code;
	
	@Column(name="ROLE_NME")
	private String name;
	
	@Column(name="VIEW_RGHT")
	private Boolean viewRight = false;
	
	@Column(name="EDIT_RGHT")
	private Boolean editRight = false;
	
	@Column(name="DELETE_RGHT")
	private Boolean deleteRight = false;
	
	@Column(name="CHKR_RGHT")
	private Boolean chkRight = false;
	
	@Column(name="ROLE_STAT")
	private String roleStat;
	
	@Column(name="CRTD_TSP")
	private Date crtdTsp;
	
	@Column(name="UPDT_TSP")
	private Date updtTsp;
	
	@Column(name="CRTD_USR")
	private String crtdUsr;
	
	@Column(name="UPDT_USR")
	private String updtUsr;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getViewRight() {
		return viewRight;
	}

	public void setViewRight(Boolean viewRight) {
		this.viewRight = viewRight;
	}

	public Boolean getEditRight() {
		return editRight;
	}

	public void setEditRight(Boolean editRight) {
		this.editRight = editRight;
	}

	public Boolean getDeleteRight() {
		return deleteRight;
	}

	public void setDeleteRight(Boolean deleteRight) {
		this.deleteRight = deleteRight;
	}

	public Boolean getChkRight() {
		return chkRight;
	}

	public void setChkRight(Boolean chkRight) {
		this.chkRight = chkRight;
	}

	public String getRoleStat() {
		return roleStat;
	}

	public void setRoleStat(String roleStat) {
		this.roleStat = roleStat;
	}

	public Date getCrtdTsp() {
		return crtdTsp;
	}

	public void setCrtdTsp(Date crtdTsp) {
		this.crtdTsp = crtdTsp;
	}

	public Date getUpdtTsp() {
		return updtTsp;
	}

	public void setUpdtTsp(Date updtTsp) {
		this.updtTsp = updtTsp;
	}

	public String getCrtdUsr() {
		return crtdUsr;
	}

	public void setCrtdUsr(String crtdUsr) {
		this.crtdUsr = crtdUsr;
	}

	public String getUpdtUsr() {
		return updtUsr;
	}

	public void setUpdtUsr(String updtUsr) {
		this.updtUsr = updtUsr;
	}

	public long getId() {
		return id;
	}
}