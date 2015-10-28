package com.lemania.sis.shared.branche;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.lemania.sis.server.ObjectifyLocator;
import com.lemania.sis.server.bean.branche.Branche;

@ProxyFor(value=Branche.class, locator=ObjectifyLocator.class)
public interface BrancheProxy extends EntityProxy {
	Long getId();
	
	public String getBrancheName();
	public void setBrancheName(String brancheName);
	
	public String getBrancheName2();
	public void setBrancheName2(String brancheName);
	
	public Double getDefaultCoef();
	public void setDefaultCoef(Double defaultCoef);
	
	public Boolean getIsActive();
	public void setIsActive(Boolean isActive);
}
