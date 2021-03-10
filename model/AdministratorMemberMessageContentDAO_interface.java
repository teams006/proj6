package com.administratorMemberMessageContent.model;

import java.util.List;

public interface AdministratorMemberMessageContentDAO_interface {
	public void insert(AdministratorMemberMessageContentBean administrator_member_message_contentBean);
	public void update(AdministratorMemberMessageContentBean administrator_member_message_contentBean);
	public void delete(Integer administrator_member_message_content_id);
	public AdministratorMemberMessageContentBean findByPrimaryKey(Integer administrator_member_message_content_id);
	public List<AdministratorMemberMessageContentBean> getAll();
}
