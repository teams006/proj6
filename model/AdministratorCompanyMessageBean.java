package com.administratorCompanyMessage.model;

public class AdministratorCompanyMessageBean implements java.io.Serializable {
	private Integer administrator_company_message_id;
	private Integer administrator_id;
	private Integer company_id;
	
	public Integer getAdministrator_company_message_id() {
		return administrator_company_message_id;
	}
	public void setAdministrator_company_message_id(Integer administrator_company_message_id) {
		this.administrator_company_message_id = administrator_company_message_id;
	}
	public Integer getAdministrator_id() {
		return administrator_id;
	}
	public void setAdministrator_id(Integer administrator_id) {
		this.administrator_id = administrator_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	} 
	
}
