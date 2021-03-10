package com.memberCompanyMessage.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.administratorMemberMessage.model.AdministratorMemberMessageBean;
import com.administratorMemberMessage.model.AdministratorMemberMessageJDBCDAO;

import Util.Util;

public class MemberCompanyMessageJDBCDAO implements MemberCompanyMessageDAO_interface {

	
	private static final String INSERT_STATEMENT = "INSERT INTO member_company_message (company_id, member_id) VALUES (?, ?)";
	private static final String GET_ALL_STATEMENT = "SELECT * FROM member_company_message";
	private static final String GET_ONE_STATEMENT = "SELECT * FROM member_company_message where member_company_message_id = ?";
	private static final String DELETE_MEMBER_COMPANY_MESSAGE = "DELETE FROM member_company_message where member_company_message_id = ?";		
	private static final String UPDATE = "UPDATE member_company_message set company_id=?, member_id=? where member_company_message_id = ?";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	@Override
	public void insert(MemberCompanyMessageBean member_company_messageBean) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(INSERT_STATEMENT);
			preparedstatement.setInt(1, member_company_messageBean.getCompany_id());
			preparedstatement.setInt(2, member_company_messageBean.getMember_id());
//			preparedstatement.executeUpdate("set auto_increment_offset=1;");
//			preparedstatement.executeUpdate("set auto_increment_increment=1;");
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
	public void update(MemberCompanyMessageBean member_company_messageBean) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(UPDATE);

			preparedstatement.setInt(3, member_company_messageBean.getMember_company_message_id());
			preparedstatement.setInt(1, member_company_messageBean.getCompany_id());
			preparedstatement.setInt(2, member_company_messageBean.getMember_id());

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
	public void delete(Integer member_company_message_id) {
		Connection connection = null;
		PreparedStatement preparedstatement = null;

		try {
			
		
			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			connection.setAutoCommit(false);
			preparedstatement = connection.prepareStatement(DELETE_MEMBER_COMPANY_MESSAGE);
			preparedstatement.setInt(1, member_company_message_id);
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
	public MemberCompanyMessageBean findByPrimaryKey(Integer member_company_message_id) {
		MemberCompanyMessageBean member_company_messageBean = null;
		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(GET_ONE_STATEMENT);

			preparedstatement.setInt(1, member_company_message_id);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				member_company_messageBean = new MemberCompanyMessageBean();
				member_company_messageBean.setMember_company_message_id(resultset.getInt("member_company_message_id"));
				member_company_messageBean.setCompany_id(resultset.getInt("company_id"));
				member_company_messageBean.setMember_id(resultset.getInt("member_id"));
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
			return member_company_messageBean;
	}

	@Override
	public List<MemberCompanyMessageBean> getAll() {
		List<MemberCompanyMessageBean> list = new ArrayList<MemberCompanyMessageBean>();
		MemberCompanyMessageBean member_company_messageBean = null;

		Connection connection = null;
		PreparedStatement preparedstatement = null;
		ResultSet resultset = null;

		try {

			connection = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			preparedstatement = connection.prepareStatement(GET_ALL_STATEMENT);
			resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				member_company_messageBean = new MemberCompanyMessageBean();
				member_company_messageBean.setMember_company_message_id(resultset.getInt("member_company_message_id"));
				member_company_messageBean.setCompany_id(resultset.getInt("company_id"));
				member_company_messageBean.setMember_id(resultset.getInt("member_id"));
				list.add(member_company_messageBean); 
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
	MemberCompanyMessageJDBCDAO Bean = new MemberCompanyMessageJDBCDAO();

	// 新增
//	MemberCompanyMessageBean Mem = new MemberCompanyMessageBean();
//	Mem.setMember_company_message_id(3);
//	Mem.setCompany_id(1);
//	Mem.setMember_id(1);
//	Bean.insert(Mem);

	

	// 修改
//	MemberCompanyMessageBean Mem1 = new MemberCompanyMessageBean();
//	Mem1.setMember_company_message_id(1);
//	Mem1.setCompany_id(2);
//	Mem1.setMember_id(2);
//	Bean.update(Mem1);
	
	// 刪除
//	Bean.delete(2);

//	// 查詢
//	MemberCompanyMessageBean Mem3 = Bean.findByPrimaryKey(1);
//	System.out.print(Mem3.getMember_company_message_id() + ",");
//	System.out.print(Mem3.getCompany_id() + ",");
//	System.out.print(Mem3.getMember_id() + ",");
//	System.out.println("---------------------");
//
//	// 查詢
//	List<MemberCompanyMessageBean> list = Bean.getAll();
//	for (MemberCompanyMessageBean Mem4 : list) {
//		
//		System.out.print(Mem4.getMember_company_message_id() + ",");
//		System.out.print(Mem4.getCompany_id() + ",");
//		System.out.print(Mem4.getMember_id() + ",");
//		}
	}
}