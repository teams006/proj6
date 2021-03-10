package com.administratorMemberMessageContent.model;

import java.sql.Timestamp;

public class AdministratorMemberMessageContentBean implements java.io.Serializable {
	private Integer administrator_member_message_content_id;  
	private Integer administrator_member_message_id; 
	private Timestamp administrator_member_published_time; 
	private String administrator_member_sender;
	private String administrator_member_message_content;
	
	public Integer getAdministrator_member_message_content_id() {
		return administrator_member_message_content_id;
	}
	public void setAdministrator_member_message_content_id(Integer administrator_member_message_content_id) {
		this.administrator_member_message_content_id = administrator_member_message_content_id;
	}
	public Integer getAdministrator_member_message_id() {
		return administrator_member_message_id;
	}
	public void setAdministrator_member_message_id(Integer administrator_member_message_id) {
		this.administrator_member_message_id = administrator_member_message_id;
	}
	public Timestamp getAdministrator_member_published_time() {
		return administrator_member_published_time;
	}
	public void setAdministrator_member_published_time(Timestamp administrator_member_published_time) {
		this.administrator_member_published_time = administrator_member_published_time;
	}
	public String getAdministrator_member_sender() {
		return administrator_member_sender;
	}
	public void setAdministrator_member_sender(String administrator_member_sender) {
		this.administrator_member_sender = administrator_member_sender;
	}
	public String getAdministrator_member_message_content() {
		return administrator_member_message_content;
	}
	public void setAdministrator_member_message_content(String administrator_member_message_content) {
		this.administrator_member_message_content = administrator_member_message_content;
	} 

	

}
