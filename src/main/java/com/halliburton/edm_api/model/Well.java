package com.halliburton.edm_api.model;

import org.hibernate.annotations.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "CD_WELL")
public class Well {
//	WELL_ID, SITE_ID, TIGHT_GROUP_ID, WELL_COMMON_NAME, WELL_LEGAL_NAME, WELL_UWI, FIELD_NAME
	
	@Id
	@Column(name = "WELL_ID")
	private String well_id;
	
	@Column(name = "SITE_ID")
	private String site_id;
	
	@Column(name = "TIGHT_GROUP_ID")
	private String tight_group_id;
	
	@Column(name = "WELL_COMMON_NAME")
	private String wellCommonName;
	
	@Column(name = "WELL_LEGAL_NAME")
	private String well_legal_name;
	
	@Column(name = "WELL_UWI")
	private String well_uwi;
	
	@Column(name = "FIELD_NAME")
	private String field_name;
	
	@Column(name = "IS_READONLY")
	private String is_readonly;

	public String getIs_readonly() {
		return is_readonly;
	}

	public void setIs_readonly(String is_readonly) {
		this.is_readonly = is_readonly;
	}

	public String getWell_id() {
		return well_id;
	}

	public String getSite_id() {
		return site_id;
	}

	public String getTight_group_id() {
		return tight_group_id;
	}

	public String getWellCommonName() {
		return wellCommonName;
	}

	public String getWell_legal_name() {
		return well_legal_name;
	}

	public String getWell_uwi() {
		return well_uwi;
	}

	public String getField_name() {
		return field_name;
	}
	
	
	
}
