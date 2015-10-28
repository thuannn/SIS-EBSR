package com.lemania.sis.server.bean.branche;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Index;
import com.lemania.sis.server.DatastoreObject;

@Entity
@Index
public class Branche extends DatastoreObject {
	//
	private String brancheName = "";
	private String brancheName2 = "";
	private Double defaultCoef;
	private Boolean isActive;
	
	public String getBrancheName() {
		return brancheName;
	}
	
	public void setBrancheName(String brancheName) {
		this.brancheName = brancheName;
	}
	
	public Double getDefaultCoef() {
		return defaultCoef;
	}
	
	public void setDefaultCoef(Double defaultCoef) {
		this.defaultCoef = defaultCoef;
	}
	
	public Boolean getIsActive() {
		return isActive;
	}
	
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getBrancheName2() {
		return brancheName2;
	}

	public void setBrancheName2(String brancheName2) {
		this.brancheName2 = brancheName2;
	}
}