package com.lmig.gfc.wimp.api;

import com.lmig.gfc.wimp.models.Actor;
import com.lmig.gfc.wimp.models.Award;

public class AwardView {

	private Award award;

	public void setTitle(String title) {
		this.award.getTitle();
	}

	public AwardView(Award award) {
		this.award = award;
	}

	public String getOrganization() {
		return award.getOrganization();
	}

	public int getYear() {
		return award.getYear();
	}
}
