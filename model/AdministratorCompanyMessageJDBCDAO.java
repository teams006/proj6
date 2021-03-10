package com.administratorCompanyMessage.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.administratorCompanyMessageContent.model.AdministratorCompanyMessageContentBean;
import com.administratorCompanyMessageContent.model.AdministratorCompanyMessageContentJDBCDAO;

import Util.Util;

public class AdministratorCompanyMessageJDBCDAO implements AdministratorCompanyMessageDAO_interface {

	private static final String INSERT_STATEMENT = "INSERT INTO administrator_company_message (administrator_id, company_id) VALUES (?, ?)";
	private static final String GET_ALL_STATEMENT = "SELECT * FROM administrator_company_message";
	private static final String GET_ONE_STATEMENT = "SELECT * FROM administrator_company_message where administrator_company_message_id = ?";
	private static final String DELETE_ADMINISTRATOR_COMPANY_MESSAGE = "DELETE FROM administrator_company_message where administrator_company_message_id = ?";
	private static final String UPDATE = "UPDATE administrator_company_message set administrator_id=?, company_id=? where administrator_company_message_id = ?";

	// ================== 載入驅動 ==================//
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void insert(AdministratorCompanyMessageBean administrator_company_messageBean) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(INSERT_STATEMENT);
			preparedstatement.setInt(1, administrator_company_messageBean.getAdministrator_id());
			preparedstatement.setInt(2, administrator_company_messageBean.getCompany_id());
//			preparedstatement.executeUpdate("set auto_increment_offset=1;");
//			preparedstatement.executeUpdate("set auto_increment_increment=1;");
			preparedstatement.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void update(AdministratorCompanyMessageBean administrator_company_messageBean) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(UPDATE);

			preparedstatement.setInt(3, administrator_company_messageBean.getAdministrator_company_message_id());
			preparedstatement.setInt(1, administrator_company_messageBean.getAdministrator_id());
			preparedstatement.setInt(2, administrator_company_messageBean.getCompany_id());

			preparedstatement.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
	public void delete(Integer administrator_company_message_id) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
//			connection.setAutoCommit(false);
			preparedstatement = connection.prepareStatement(DELETE_ADMINISTRATOR_COMPANY_MESSAGE);
			preparedstatement.setInt(1, administrator_company_message_id);
			preparedstatement.executeUpdate();

		} catch (SQLException se) {
			String errors = "";
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException excep) {
					errors += "rollback error occured. " + excep.getMessage()+"; ";
				}
			}
			throw new RuntimeException(errors + "A database error occured. " + se.getMessage());
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
	public AdministratorCompanyMessageBean findByPrimaryKey(Integer administrator_company_message_id) {
		AdministratorCompanyMessageBean administrator_company_messageBean = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(GET_ONE_STATEMENT);

			preparedstatement.setInt(1, administrator_company_message_id);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				administrator_company_messageBean = new AdministratorCompanyMessageBean();
				administrator_company_messageBean
						.setAdministrator_company_message_id(resultset.getInt("administrator_company_message_id"));
				administrator_company_messageBean.setAdministrator_id(resultset.getInt("administrator_id"));
				administrator_company_messageBean.setCompany_id(resultset.getInt("company_id"));
			}
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		return administrator_company_messageBean;
	}

	@Override
	public List<AdministratorCompanyMessageBean> getAll() {
		List<AdministratorCompanyMessageBean> list = new ArrayList<AdministratorCompanyMessageBean>();
		AdministratorCompanyMessageBean administrator_company_messageBean = null;

		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(GET_ALL_STATEMENT);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				administrator_company_messageBean = new AdministratorCompanyMessageBean();
				administrator_company_messageBean
						.setAdministrator_company_message_id(resultset.getInt("administrator_company_message_id"));
				administrator_company_messageBean.setAdministrator_id(resultset.getInt("administrator_id"));
				administrator_company_messageBean.setCompany_id(resultset.getInt("company_id"));
				list.add(administrator_company_messageBean);
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());
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
		AdministratorCompanyMessageJDBCDAO Bean = new AdministratorCompanyMessageJDBCDAO();

		// 新增
//	AdministratorCompanyMessageBean Adm = new AdministratorCompanyMessageBean();
//	Adm.setAdministrator_id(1);
//	Adm.setCompany_id(1);
//	Bean.insert(Adm);

		// 修改
//	AdministratorCompanyMessageBean Adm1 = new AdministratorCompanyMessageBean();
//	Adm1.setAdministrator_company_message_id(2);
//	Adm1.setAdministrator_id(1);
//	Adm1.setCompany_id(1);
//	Bean.update(Adm1);

		// 刪除
//		Bean.delete(2);

		// 查詢
//	AdministratorCompanyMessageBean Adm3 = Bean.findByPrimaryKey(2);
//	System.out.print(Adm3.getAdministrator_company_message_id() + ",");
//	System.out.print(Adm3.getAdministrator_id() + ",");
//	System.out.print(Adm3.getCompany_id() + ",");
//	System.out.println("---------------------");

		// 查詢
//	List<AdministratorCompanyMessageBean> list = Bean.getAll();
//	for (AdministratorCompanyMessageBean Adm4 : list) {
//		System.out.print(Adm4.getAdministrator_company_message_id() + ",");
//		System.out.print(Adm4.getAdministrator_id() + ",");
//		System.out.print(Adm4.getCompany_id() + ",");
//		}
	}
}
