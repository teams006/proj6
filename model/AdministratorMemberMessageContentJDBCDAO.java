package com.administratorMemberMessageContent.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.administratorCompanyMessageContent.model.AdministratorCompanyMessageContentBean;
import com.administratorCompanyMessageContent.model.AdministratorCompanyMessageContentJDBCDAO;

import Util.Util;


public class AdministratorMemberMessageContentJDBCDAO implements AdministratorMemberMessageContentDAO_interface {
	
	private static final String INSERT_STATEMENT = "INSERT INTO administrator_member_message_content (administrator_member_message_id, administrator_member_sender, administrator_member_message_content) VALUES (?, ?, ?)";
	private static final String GET_ALL_STATEMENT = "SELECT * FROM administrator_member_message_content";
	private static final String GET_ONE_STATEMENT = "SELECT * FROM administrator_member_message_content where administrator_member_message_content_id = ?";
	private static final String DELETE_ADMINISTRATOR_MEMBER_MESSAGE_CONTENT = "DELETE FROM administrator_member_message_content where administrator_member_message_content_id = ?";		
	private static final String UPDATE = "UPDATE administrator_member_message_content set administrator_member_message_id=?, administrator_member_sender=?, administrator_member_message_content=? where administrator_member_message_content_id = ?";
	
	// ================== 載入驅動 ==================//
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void insert(AdministratorMemberMessageContentBean administrator_member_message_contentBean) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(INSERT_STATEMENT);
			preparedstatement.setInt(1, administrator_member_message_contentBean.getAdministrator_member_message_id());
			preparedstatement.setString(2, administrator_member_message_contentBean.getAdministrator_member_sender());
			preparedstatement.setString(3, administrator_member_message_contentBean.getAdministrator_member_message_content());
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
	public void update(AdministratorMemberMessageContentBean administrator_member_message_contentBean) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(UPDATE);

			preparedstatement.setInt(1, administrator_member_message_contentBean.getAdministrator_member_message_id());
			preparedstatement.setString(2, administrator_member_message_contentBean.getAdministrator_member_sender());
			preparedstatement.setString(3, administrator_member_message_contentBean.getAdministrator_member_message_content());
			preparedstatement.setInt(4, administrator_member_message_contentBean.getAdministrator_member_message_content_id());
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
	public void delete(Integer administrator_member_message_content_id) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			
			
			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);

			preparedstatement = connection.prepareStatement(DELETE_ADMINISTRATOR_MEMBER_MESSAGE_CONTENT);
			preparedstatement.setInt(1, administrator_member_message_content_id);
			preparedstatement.executeUpdate();


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
	public AdministratorMemberMessageContentBean findByPrimaryKey(Integer administrator_member_message_content_id) {
		AdministratorMemberMessageContentBean administrator_member_message_contentBean = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(GET_ONE_STATEMENT);

			preparedstatement.setInt(1, administrator_member_message_content_id);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				administrator_member_message_contentBean = new AdministratorMemberMessageContentBean();
				administrator_member_message_contentBean.setAdministrator_member_message_content_id(resultset.getInt("administrator_member_message_content_id"));
				administrator_member_message_contentBean.setAdministrator_member_message_id(resultset.getInt("administrator_member_message_id"));
				administrator_member_message_contentBean.setAdministrator_member_sender(resultset.getString("administrator_member_sender"));
				administrator_member_message_contentBean.setAdministrator_member_message_content(resultset.getString("administrator_member_message_content"));
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
			return administrator_member_message_contentBean;
	}

	@Override
	public List<AdministratorMemberMessageContentBean> getAll() {
		List<AdministratorMemberMessageContentBean> list = new ArrayList<AdministratorMemberMessageContentBean>();
		AdministratorMemberMessageContentBean administrator_member_message_contentBean = null;

		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(GET_ALL_STATEMENT);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				administrator_member_message_contentBean = new AdministratorMemberMessageContentBean();
				administrator_member_message_contentBean.setAdministrator_member_message_content_id(resultset.getInt("administrator_member_message_content_id"));
				administrator_member_message_contentBean.setAdministrator_member_message_id(resultset.getInt("administrator_member_message_id"));
				administrator_member_message_contentBean.setAdministrator_member_sender(resultset.getString("administrator_member_sender"));
				administrator_member_message_contentBean.setAdministrator_member_published_time(resultset.getTimestamp("administrator_member_published_time"));
				administrator_member_message_contentBean.setAdministrator_member_message_content(resultset.getString("administrator_member_message_content"));
				list.add(administrator_member_message_contentBean); 
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
 
	// 新增
	AdministratorMemberMessageContentJDBCDAO Bean = new AdministratorMemberMessageContentJDBCDAO();
	Timestamp time= new Timestamp(System.currentTimeMillis());//獲取系統當前時間 
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String timeStr = df.format(time); 
	time = Timestamp.valueOf(timeStr); 
//	Adm.setAdministrator_member_message_content_id(3);
//	Adm.setAdministrator_member_message_id(2);
//	Adm.setAdministrator_member_sender("管理員");
//	Adm.setAdministrator_member_message_content("你好!謝謝惠顧!");
//	Bean.insert(Adm);

	

	// 修改
//	AdministratorMemberMessageContentBean Adm1 = new AdministratorMemberMessageContentBean();
//	Adm1.setAdministrator_member_message_content_id(1);
//	Adm1.setAdministrator_member_message_id(2);
//	Adm1.setAdministrator_member_sender("廠商");
//	Adm1.setAdministrator_member_message_content("謝謝!");
//	Bean.update(Adm1);
	
	// 刪除
	
//	Bean.delete(1);

//	// 查詢
//	AdministratorMemberMessageContentBean Adm3 = Bean.findByPrimaryKey(2);
//	System.out.print(Adm3.getAdministrator_member_message_content_id() + ",");
//	System.out.print(Adm3.getAdministrator_member_message_id() + ",");
//	System.out.print(Adm3.getAdministrator_member_published_time() + ",");
//	System.out.print(Adm3.getAdministrator_member_sender() + ",");
//	System.out.print(Adm3.getAdministrator_member_message_content() + ",");
//	System.out.println("---------------------");
//
//	// 查詢
	List<AdministratorMemberMessageContentBean> list = Bean.getAll();
	for (AdministratorMemberMessageContentBean Adm4 : list) {
		
		System.out.print(Adm4.getAdministrator_member_message_content_id() + ",");
		System.out.print(Adm4.getAdministrator_member_message_id() + ",");
		System.out.print(Adm4.getAdministrator_member_published_time() + ",");
		System.out.print(Adm4.getAdministrator_member_sender() + ",");
		System.out.print(Adm4.getAdministrator_member_message_content() + ",");
		}
	}
}