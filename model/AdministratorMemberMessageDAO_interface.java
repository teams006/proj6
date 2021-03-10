package com.administratorMemberMessage.model;

import java.util.List;

public interface AdministratorMemberMessageDAO_interface {
	public void insert(AdministratorMemberMessageBean administrator_member_messageBean);
	public void update(AdministratorMemberMessageBean administrator_member_messageBean);
	public void delete(Integer administrator_member_message_id);
	public AdministratorMemberMessageBean findByPrimaryKey(Integer administrator_member_message_id);
	public List<AdministratorMemberMessageBean> getAll();
	
	

}


