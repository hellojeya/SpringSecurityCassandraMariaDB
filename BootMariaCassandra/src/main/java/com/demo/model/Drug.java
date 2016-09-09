package com.demo.model;


import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

@Table
public class Drug 
{
	@PrimaryKeyColumn( name="drugid", ordinal=1, type=PrimaryKeyType.PARTITIONED)
	private String drugid;
	
	@Column
	private String drugname;
	
	@Column
	private String drugtype;

	public String getDrugid() {
		return drugid;
	}

	public void setDrugid(String drugid) {
		this.drugid = drugid;
	}

	public String getDrugname() {
		return drugname;
	}

	public void setDrugname(String drugname) {
		this.drugname = drugname;
	}

	public String getDrugtype() {
		return drugtype;
	}

	public void setDrugtype(String drugtype) {
		this.drugtype = drugtype;
	}
	

}
