package com.administratorMemberMessage.model;

public class AdministratorMemberMessageBean implements java.io.Serializable {
	private Integer administrator_member_message_id;  
	private Integer administrator_id;
	private Integer member_id;
	
	public Integer getAdministrator_member_message_id() {
		return administrator_member_message_id;
	}
	public void setAdministrator_member_message_id(Integer administrator_member_message_id) {
		this.administrator_member_message_id = administrator_member_message_id;
	}
	public Integer getAdministrator_id() {
		return administrator_id;
	}
	public void setAdministrator_id(Integer administrator_id) {
		this.administrator_id = administrator_id;
	}
	public Integer getMember_id() {
		return member_id;
	}
	public void setMember_id(Integer member_id) {
		this.member_id = member_id;
	}
	
}
