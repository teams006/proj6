package com.administratorCompanyMessage.model;

import java.util.List;

public interface AdministratorCompanyMessageDAO_interface {
	public void insert(AdministratorCompanyMessageBean administrator_company_messageBean);
	public void update(AdministratorCompanyMessageBean administrator_company_messageBean);
	public void delete(Integer administrator_company_message_id);
	public AdministratorCompanyMessageBean findByPrimaryKey(Integer administrator_company_message_id);
	public List<AdministratorCompanyMessageBean> getAll();
}
