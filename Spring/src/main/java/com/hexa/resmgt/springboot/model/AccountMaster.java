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
@Table(name="t001_account_master")
public class AccountMaster  implements Serializable{
	
	private static final long serialVersionUID = -2380428494507380773L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ACCT_ID")
	private long id;
	
	@Column(name="ACCT_CODE")
	private String code;
	
	@Column(name="ACCT_NME")
	private String name;
	
	@Column(name="ACCT_STAT")
	private String stat;
	
	@Column(name="CRTD_TSP")
	private Date crtdTsp;
	
	@Column(name="UPDT_TSP")
	private Date updtTsp;
	
	@Column(name="CRTD_USR")
	private String crtdUsr;
	
	@Column(name="UPDT_USR")
	private String updtUsr;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
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
}
