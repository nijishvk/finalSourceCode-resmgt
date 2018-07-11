package com.hexa.resmgt.springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="t010_res_monthly_count")
public class ResourceMonthlyCount implements Serializable{
	
	private static final long serialVersionUID = -2380428494507380773L;

	@Id
	@Column(name="ID")
	private long id;

	@Column(name="DATA_TYPE_CD")
	private String dataTypeCd;
	
	@Column(name="DATA_TYPE")
	private String dataType;
	
	@Column(name="MONTH_NAME")
	private String monthName;
	
	@Column(name="MONTH_COUNT")
	private String monthCount;
	
	@Column(name="UPDATED_DATE")
	private Date updatedDate;

	public long getId() {
		return id;
	}

	public String getDataTypeCd() {
		return dataTypeCd;
	}

	public String getDataType() {
		return dataType;
	}

	public String getMonthName() {
		return monthName;
	}

	public String getMonthCount() {
		return monthCount;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}
}
