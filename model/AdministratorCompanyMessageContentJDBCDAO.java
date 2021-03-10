package com.administratorCompanyMessageContent.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.administratorCompanyMessage.model.AdministratorCompanyMessageBean;

import Util.Util;


public class AdministratorCompanyMessageContentJDBCDAO implements AdministratorCompanyMessageContentDAO_interface {
	
	private static final String INSERT_STATEMENT = "INSERT INTO administrator_company_message_content (administrator_company_message_id, administrator_company_sender, administrator_company_message_content) VALUES (?, ?, ?)";
	private static final String GET_ALL_STATEMENT = "SELECT * FROM administrator_company_message_content";
	private static final String GET_ONE_STATEMENT = "SELECT * FROM administrator_company_message_content where administrator_company_message_content_id = ?";
	private static final String DELETE_ADMINISTRATOR_COMPANY_MESSAGE_CONTENT = "DELETE FROM administrator_company_message_content where administrator_company_message_content_id = ?";		
	private static final String UPDATE = "UPDATE administrator_company_message_content set administrator_company_message_id=?, administrator_company_sender=?, administrator_company_message_content=? where administrator_company_message_content_id=?";
	// ================== 載入驅動 ==================//
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void insert(AdministratorCompanyMessageContentBean administrator_company_message_contentBean) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(INSERT_STATEMENT);
			preparedstatement.setInt(1, administrator_company_message_contentBean.getAdministrator_company_message_id());
			preparedstatement.setString(2, administrator_company_message_contentBean.getAdministrator_company_sender());
			preparedstatement.setString(3, administrator_company_message_contentBean.getAdministrator_company_message_content());
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
	public void update(AdministratorCompanyMessageContentBean administrator_company_message_contentBean) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(UPDATE);

			preparedstatement.setInt(4, administrator_company_message_contentBean.getAdministrator_company_message_content_id());
			preparedstatement.setInt(1, administrator_company_message_contentBean.getAdministrator_company_message_id());
//			preparedstatement.setDate(3, administrator_company_message_contentBean.getAdministrator_company_published_time());
			preparedstatement.setString(2, administrator_company_message_contentBean.getAdministrator_company_sender());
			preparedstatement.setString(3, administrator_company_message_contentBean.getAdministrator_company_message_content());

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
	public void delete(Integer administrator_company_message_content_id) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			
//			connection.setAutoCommit(false);
			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);

			preparedstatement = connection.prepareStatement(DELETE_ADMINISTRATOR_COMPANY_MESSAGE_CONTENT);
			preparedstatement.setInt(1, administrator_company_message_content_id);
			preparedstatement.executeUpdate();

//			connection.commit();
//			connection.setAutoCommit(true);

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
	public AdministratorCompanyMessageContentBean findByPrimaryKey(Integer administrator_company_message_content_id) {
		AdministratorCompanyMessageContentBean administrator_company_message_contentBean = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(GET_ONE_STATEMENT);

			preparedstatement.setInt(1, administrator_company_message_content_id);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				administrator_company_message_contentBean = new AdministratorCompanyMessageContentBean();
				administrator_company_message_contentBean.setAdministrator_company_message_content_id(resultset.getInt("administrator_company_message_content_id"));
				administrator_company_message_contentBean.setAdministrator_company_message_id(resultset.getInt("administrator_company_message_id"));
				administrator_company_message_contentBean.setAdministrator_company_published_time(resultset.getDate("administrator_company_published_time"));
				administrator_company_message_contentBean.setAdministrator_company_sender(resultset.getString("administrator_company_sender"));
				administrator_company_message_contentBean.setAdministrator_company_message_content(resultset.getString("administrator_company_message_content"));
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
			return administrator_company_message_contentBean;
	}

	@Override
	public List<AdministratorCompanyMessageContentBean> getAll() {
		List<AdministratorCompanyMessageContentBean> list = new ArrayList<AdministratorCompanyMessageContentBean>();
		AdministratorCompanyMessageContentBean administrator_company_message_contentBean = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(GET_ALL_STATEMENT);
			resultset = preparedstatement.executeQuery();
			
			while (resultset.next()) {
				administrator_company_message_contentBean = new AdministratorCompanyMessageContentBean();
				administrator_company_message_contentBean.setAdministrator_company_message_content_id(resultset.getInt("administrator_company_message_content_id"));
				administrator_company_message_contentBean.setAdministrator_company_message_id(resultset.getInt("administrator_company_message_id"));
				administrator_company_message_contentBean.setAdministrator_company_published_time(resultset.getDate("administrator_company_published_time"));
				administrator_company_message_contentBean.setAdministrator_company_sender(resultset.getString("administrator_company_sender"));
				administrator_company_message_contentBean.setAdministrator_company_message_content(resultset.getString("administrator_company_message_content"));
				list.add(administrator_company_message_contentBean); 
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
	AdministratorCompanyMessageContentJDBCDAO Bean = new AdministratorCompanyMessageContentJDBCDAO();

	// 新增
//	AdministratorCompanyMessageContentBean Adm = new AdministratorCompanyMessageContentBean();
//	Adm.setAdministrator_company_message_id(1);
//	Adm.setAdministrator_company_sender("管理員");
//	Adm.setAdministrator_company_message_content("你好");
//	Bean.insert(Adm);

	

	// 修改
//	AdministratorCompanyMessageContentBean Adm1 = new AdministratorCompanyMessageContentBean();
//	Adm1.setAdministrator_company_message_content_id(1);
//	Adm1.setAdministrator_company_message_id(3);
//	Adm1.setAdministrator_company_sender("管理者");
//	Adm1.setAdministrator_company_message_content("謝謝，你好!我是管理者!你好");
//	Bean.update(Adm1);
	
	// 刪除
	
	Bean.delete(1);

//	// 查詢
//	AdministratorCompanyMessageContentBean Adm3 = Bean.findByPrimaryKey(2);
//	System.out.print(Adm3.getAdministrator_company_message_content_id() + ",");
//	System.out.print(Adm3.getAdministrator_company_message_id() + ",");
//	System.out.print(Adm3.getAdministrator_company_published_time() + ",");
//	System.out.print(Adm3.getAdministrator_company_sender() + ",");
//	System.out.print(Adm3.getAdministrator_company_message_content() + ",");
//	System.out.println("---------------------");
//
	// 查詢
//	List<AdministratorCompanyMessageContentBean> list = Bean.getAll();
//	for (AdministratorCompanyMessageContentBean Adm4 : list) {
//		
//		
//		System.out.print(Adm4.getAdministrator_company_message_content_id() + ",");
//		System.out.print(Adm4.getAdministrator_company_message_id() + ",");
//		System.out.print(Adm4.getAdministrator_company_published_time() + ",");
//		System.out.print(Adm4.getAdministrator_company_sender() + ",");
//		System.out.print(Adm4.getAdministrator_company_message_content() + ",");
//		}
	}
}



