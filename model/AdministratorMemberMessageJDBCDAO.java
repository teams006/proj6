package com.administratorMemberMessage.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.administratorMemberMessageContent.model.AdministratorMemberMessageContentBean;
import com.administratorMemberMessageContent.model.AdministratorMemberMessageContentJDBCDAO;

import Util.Util;



public class AdministratorMemberMessageJDBCDAO implements AdministratorMemberMessageDAO_interface {
	
	private static final String INSERT_STATEMENT = "INSERT INTO administrator_member_message (administrator_id, member_id) VALUES (?, ?)";
	private static final String GET_ALL_STATEMENT = "SELECT administrator_member_message_id, administrator_id, member_id FROM administrator_member_message";
	private static final String GET_ONE_STATEMENT = "SELECT administrator_member_message_id, administrator_id, member_id FROM administrator_member_message where administrator_member_message_id = ?";
	private static final String DELETE_ADMINISTRATOR_MEMBER_MESSAGE = "DELETE FROM administrator_member_message where administrator_member_message_id = ?";		
	private static final String UPDATE = "UPDATE administrator_member_message set administrator_id=?, member_id=? where administrator_member_message_id = ?";

	@Override
	public void insert(AdministratorMemberMessageBean administrator_member_messageBean) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(INSERT_STATEMENT);
			preparedstatement.setInt(1, administrator_member_messageBean.getAdministrator_id());
			preparedstatement.setInt(2, administrator_member_messageBean.getMember_id());
			preparedstatement.executeUpdate("set auto_increment_offset=1;");
			preparedstatement.executeUpdate("set auto_increment_increment=1;");
			preparedstatement.executeUpdate();

			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
			} finally {
				if (preparedstatement != null) {
					try {
						preparedstatement.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
		}

	@Override
	public void update(AdministratorMemberMessageBean administrator_member_messageBean) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(UPDATE);

			preparedstatement.setInt(3, administrator_member_messageBean.getAdministrator_member_message_id());
			preparedstatement.setInt(1, administrator_member_messageBean.getAdministrator_id());
			preparedstatement.setInt(2, administrator_member_messageBean.getMember_id());

			preparedstatement.executeUpdate();

			} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
						+ se.getMessage());
			} finally {
				if (preparedstatement != null) {
					try {
						preparedstatement.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}	
		}

	@Override
	public void delete(Integer administrator_member_message_id) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			
			connection.setAutoCommit(false);

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);

			preparedstatement = connection.prepareStatement(DELETE_ADMINISTRATOR_MEMBER_MESSAGE);
			preparedstatement.setInt(1, administrator_member_message_id);
			preparedstatement.executeUpdate();

			connection.commit();
			connection.setAutoCommit(true);
			
			} catch (SQLException se) {
				if (connection != null) {
					try {
					
						connection.rollback();
					} catch (SQLException excep) {
						throw new RuntimeException("rollback error occured. "
								+ excep.getMessage());
					}
				}
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
			} finally {
					if (preparedstatement != null) {
						try {
							preparedstatement.close();
						} catch (SQLException se) {
							se.printStackTrace(System.err);
						}
					}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}	
	}

	@Override
	public AdministratorMemberMessageBean findByPrimaryKey(Integer administrator_member_message_id) {
		AdministratorMemberMessageBean administrator_member_messageBean = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(GET_ONE_STATEMENT);

			preparedstatement.setInt(1, administrator_member_message_id);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				administrator_member_messageBean = new AdministratorMemberMessageBean();
				administrator_member_messageBean.setAdministrator_member_message_id(resultset.getInt("administrator_member_message_id"));
				administrator_member_messageBean.setAdministrator_id(resultset.getInt("administrator_id"));
				administrator_member_messageBean.setMember_id(resultset.getInt("member_id"));
				}
			} catch (SQLException se) {
				throw new RuntimeException("A database error occured. "
						+ se.getMessage());
			} finally {
				if (resultset != null) {
					try {
						resultset.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (preparedstatement != null) {
					try {
						preparedstatement.close();
					} catch (SQLException se) {
						se.printStackTrace(System.err);
					}
				}
				if (connection != null) {
					try {
						connection.close();
					} catch (Exception e) {
						e.printStackTrace(System.err);
					}
				}
			}
			return administrator_member_messageBean;
		}

	@Override
	public List<AdministratorMemberMessageBean> getAll() {
		List<AdministratorMemberMessageBean> list = new ArrayList<AdministratorMemberMessageBean>();
		AdministratorMemberMessageBean administrator_member_messageBean = null;

		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(GET_ALL_STATEMENT);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				administrator_member_messageBean = new AdministratorMemberMessageBean();
				administrator_member_messageBean.setAdministrator_member_message_id(resultset.getInt("administrator_member_message_id"));
				administrator_member_messageBean.setAdministrator_id(resultset.getInt("administrator_id"));
				administrator_member_messageBean.setMember_id(resultset.getInt("member_id"));
				list.add(administrator_member_messageBean); 
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		} finally {
			if (resultset != null) {
				try {
					resultset.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (preparedstatement != null) {
				try {
					preparedstatement.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}


public static void main(String[] args) {
	AdministratorMemberMessageJDBCDAO Bean = new AdministratorMemberMessageJDBCDAO();

	// 新增
//	AdministratorMemberMessageBean Adm = new AdministratorMemberMessageBean();
//
//	Adm.setAdministrator_id(3);
//	Adm.setMember_id(3);
//	Bean.insert(Adm);

	

	// 修改
//	AdministratorMemberMessageBean Adm1 = new AdministratorMemberMessageBean();
//	Adm1.setAdministrator_member_message_id(1);
//	Adm1.setAdministrator_id(2);
//	Adm1.setMember_id(2);
//	Bean.update(Adm1);

	// 刪除
	
	Bean.delete(1);

//	// 查詢
//	AdministratorMemberMessageBean Adm3 = Bean.findByPrimaryKey(1);
//	System.out.print(Adm3.getAdministrator_member_message_id() + ",");
//	System.out.print(Adm3.getAdministrator_id() + ",");
//	System.out.print(Adm3.getMember_id() + ",");
//	System.out.println("---------------------");
//
//	// 查詢
//	List<AdministratorMemberMessageBean> list = Bean.getAll();
//	for (AdministratorMemberMessageBean Adm4 : list) {
//		
//		System.out.print(Adm4.getAdministrator_member_message_id() + ",");
//		System.out.print(Adm4.getAdministrator_id() + ",");
//		System.out.print(Adm4.getMember_id() + ",");
//		}
	}
}