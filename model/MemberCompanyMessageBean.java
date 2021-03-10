package com.memberCompanyMessage.model;

public class MemberCompanyMessageBean implements java.io.Serializable {
	private Integer member_company_message_id;
	private Integer company_id;
	private Integer member_id;
	
	public Integer getMember_company_message_id() {
		return member_company_message_id;
	}
	public void setMember_company_message_id(Integer member_company_message_id) {
		this.member_company_message_id = member_company_message_id;
	}
	public Integer getCompany_id() {
		return company_id;
	}
	public void setCompany_id(Integer company_id) {
		this.company_id = company_id;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	

}
