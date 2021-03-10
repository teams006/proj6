 package com.administratorCompanyMessageContent.model;

import java.util.List;

public interface AdministratorCompanyMessageContentDAO_interface {
	public void insert(AdministratorCompanyMessageContentBean administrator_company_message_contentBean);
	public void update(AdministratorCompanyMessageContentBean administrator_company_message_contentBean);
	public void delete(Integer administrator_company_message_content_id);
	public AdministratorCompanyMessageContentBean findByPrimaryKey(Integer administrator_company_message_content_id);
	public List<AdministratorCompanyMessageContentBean> getAll();
}
