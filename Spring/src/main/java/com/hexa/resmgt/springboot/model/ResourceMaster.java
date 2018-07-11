package com.hexa.resmgt.springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="t004_resource_master")
public class ResourceMaster implements Serializable{
	
	private static final long serialVersionUID = -2380428494507380773L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="RES_ID")
	private long id;
	
	@Column(name="RES_STAT")
	private long resStat;
	
	@Column(name="RES_USR_NME")
	private String userName;
	
	@Column(name="RES_USR_PWD")
	private String userPwd;
		
	@Column(name="RES_FIRST_NME")
	private String firstName;
	
	@Column(name="RES_LAST_NME")
	private String lastName;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RES_TYP")
	private GeneralData resType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RES_BILL_TYP")
	private GeneralData billType;
	    
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RES_BDGT_TYP")
	private GeneralData bdgtType;
	    
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RES_BILL_ROLE")
	private GeneralData billRole;
	
	@Column(name="RES_RATE")
	private long rate;
	
	@ManyToOne
	@JoinColumn(name="T001_ACCT_ID")
	private AccountMaster accountMaster;
	
	@Column(name="RES_PSID")
	private String psId;
	
	@Column(name="RES_GNDR", length=1)
	private String gender;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RES_LOC")
	private GeneralData location;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RES_STE_LOC")
	private GeneralData steLoc;
	
	@Column(name="RES_SKILL_SET")
	private String skillSet;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RES_ROLE")
	private GeneralData role;
	
	@Column(name="RES_SOW")
	private String sow;
	
	@Column(name="RES_HEX_POC")
	private long hexPoc;
	
	@Column(name="RES_OFF_NO")
	private String officeNo;
	
	@Column(name="RES_MOBL_NO")
	private String mobileNo;
	
	@Column(name="RES_HEX_EMP_ID")
	private long hexEmployeeId;
	
	@Column(name="RES_HEX_EXP")
	private long hexExp;
	
	@Column(name="RES_OUTSD_EXP")
	private long outsideExp;
	
	@Column(name="RES_TOT_EXP")
	private long totalExp;
	
	@Column(name="RES_HEX_MGR")
	private String hexManager;
	
	@Column(name="RES_DEV_LDR")
	private String devLdr;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "T002_ROLE_ID")
	private RoleMaster roleMaster;
	
	@Temporal(TemporalType.DATE)
	@Column(name="RES_JOIN_DT")
	private Date joiningDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="RES_END_DT")
	private Date endDate;
	
	@Column(name="RES_GRD")
	private long grd;
	
	@Column(name="RES_LED_CON")
	private long ledCon;
	
	@Column(name="RES_UNIT")
	private long unit;
	
	@Column(name="CRTD_TSP")
	private Date crtdTsp;
	
	@Column(name="UPDT_TSP")
	private Date updtTsp;
	
	@Column(name="CRTD_USR")
	private String crtdUsr;
	
	@Column(name="UPDT_USR")
	private String updtUsr;

	public long getResStat() {
		return resStat;
	}

	public void setResStat(long resStat) {
		this.resStat = resStat;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public GeneralData getResType() {
		return resType;
	}

	public void setResType(GeneralData resType) {
		this.resType = resType;
	}

	public GeneralData getBillType() {
		return billType;
	}

	public void setBillType(GeneralData billType) {
		this.billType = billType;
	}

	public GeneralData getBdgtType() {
		return bdgtType;
	}

	public void setBdgtType(GeneralData bdgtType) {
		this.bdgtType = bdgtType;
	}

	public GeneralData getBillRole() {
		return billRole;
	}

	public void setBillRole(GeneralData billRole) {
		this.billRole = billRole;
	}

	public long getRate() {
		return rate;
	}

	public void setRate(long rate) {
		this.rate = rate;
	}

	public AccountMaster getAccountMaster() {
		return accountMaster;
	}

	public void setAccountMaster(AccountMaster accountMaster) {
		this.accountMaster = accountMaster;
	}

	public String getPsId() {
		return psId;
	}

	public void setPsId(String psId) {
		this.psId = psId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public GeneralData getLocation() {
		return location;
	}

	public void setLocation(GeneralData location) {
		this.location = location;
	}

	public GeneralData getSteLoc() {
		return steLoc;
	}

	public void setSteLoc(GeneralData steLoc) {
		this.steLoc = steLoc;
	}

	public String getSkillSet() {
		return skillSet;
	}

	public void setSkillSet(String skillSet) {
		this.skillSet = skillSet;
	}

	public GeneralData getRole() {
		return role;
	}

	public void setRole(GeneralData role) {
		this.role = role;
	}

	public String getSow() {
		return sow;
	}

	public void setSow(String sow) {
		this.sow = sow;
	}

	public long getHexPoc() {
		return hexPoc;
	}

	public void setHexPoc(long hexPoc) {
		this.hexPoc = hexPoc;
	}

	public String getOfficeNo() {
		return officeNo;
	}

	public void setOfficeNo(String officeNo) {
		this.officeNo = officeNo;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getHexEmployeeId() {
		return hexEmployeeId;
	}

	public void setHexEmployeeId(long hexEmployeeId) {
		this.hexEmployeeId = hexEmployeeId;
	}

	public long getHexExp() {
		return hexExp;
	}

	public void setHexExp(long hexExp) {
		this.hexExp = hexExp;
	}

	public long getOutsideExp() {
		return outsideExp;
	}

	public void setOutsideExp(long outsideExp) {
		this.outsideExp = outsideExp;
	}

	public long getTotalExp() {
		return totalExp;
	}

	public void setTotalExp(long totalExp) {
		this.totalExp = totalExp;
	}

	public String getHexManager() {
		return hexManager;
	}

	public void setHexManager(String hexManager) {
		this.hexManager = hexManager;
	}

	public String getDevLdr() {
		return devLdr;
	}

	public void setDevLdr(String devLdr) {
		this.devLdr = devLdr;
	}

	public RoleMaster getRoleMaster() {
		return roleMaster;
	}

	public void setRoleMaster(RoleMaster roleMaster) {
		this.roleMaster = roleMaster;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public long getGrd() {
		return grd;
	}

	public void setGrd(long grd) {
		this.grd = grd;
	}

	public long getLedCon() {
		return ledCon;
	}

	public void setLedCon(long ledCon) {
		this.ledCon = ledCon;
	}

	public long getUnit() {
		return unit;
	}

	public void setUnit(long unit) {
		this.unit = unit;
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
