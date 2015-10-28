package com.lemania.sis.client.form.branches;

import com.gwtplatform.mvp.client.UiHandlers;
import com.lemania.sis.shared.branche.BrancheProxy;

public interface FrmBrancheListUiHandler extends UiHandlers {
	//
	public void updateBranche(BrancheProxy branche, String brancheName, String brancheName2, String brancheCoef, Boolean isActive);
}