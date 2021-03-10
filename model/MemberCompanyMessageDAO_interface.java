package com.memberCompanyMessage.model;

import java.util.List;


public interface MemberCompanyMessageDAO_interface {
	public void insert(MemberCompanyMessageBean member_company_messageBean);
	public void update(MemberCompanyMessageBean member_company_messageBean);
	public void delete(Integer member_company_message_id);
	public MemberCompanyMessageBean findByPrimaryKey(Integer member_company_message_id);
	public List<MemberCompanyMessageBean> getAll();
}
