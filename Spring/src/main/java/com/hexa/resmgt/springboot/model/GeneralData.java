package com.hexa.resmgt.springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t006_general_data")
public class GeneralData  implements Serializable{
	
	private static final long serialVersionUID = -2380428494507380773L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="GEN_ID")
	private long id;
	
	@Column(name="GEN_CDE")
	private String code;
	
	@Column(name="GEN_NME")
	private String name;
	
	@Column(name="GEN_STAT")
	private String stat;
	
	@Column(name="GEN_TYP")
	private String type;
	
	@Column(name="GEN_DESC")
	private String desc;
	
	@ManyToOne
	@JoinColumn(name="T001_ACCT_ID")
	private AccountMaster accountMaster;
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public AccountMaster getAccountMaster() {
		return accountMaster;
	}

	public void setAccountMaster(AccountMaster accountMaster) {
		this.accountMaster = accountMaster;
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
