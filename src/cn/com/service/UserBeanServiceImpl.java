package cn.com.service;

import cn.com.dao.UserBeanDAOImpl;
import cn.com.dao.UserBeanDAOInf;
import cn.com.db.DBUtil;
import cn.com.pojo.UserBean;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBeanServiceImpl implements UserBeanServiceInf {
	private UserBeanDAOInf dao;

	public UserBeanServiceImpl() {
		dao = new UserBeanDAOImpl();
	}

	@Override
	public List<UserBean> getAllUserInfo() {
		Connection conn = null;
		List<UserBean> list = null;
		String sql = "select * from address_list";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			list = dao.getAllUserInfo(conn, sql);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	public boolean validateByUserNameAndPwd(String userName, String userPwd) {
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select * from address_list where username = ? and userpwd=?";
			bool = dao.validateByUserNameAndPwd(conn, sql, userName, userPwd);
			if (bool) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					DBUtil.freeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bool;
	}

	@Override
	public UserBean getUserInfoByName(String userName) {
		Connection conn = null;
		UserBean ub = null;
		String sql = "select * from address_list where username = ?";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			ub = dao.getUserInfoByName(conn, sql, userName);
			if(ub != null){
                conn.commit();
            }else{
                conn.rollback();
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ub;
	}

	@Override
	public UserBean getUserInfoById(int userId) {
		Connection conn = null;
		UserBean ub = null;
		String sql = "select * from address_list where userId = ?";
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			ub = dao.getUserInfoById(conn, sql, userId);
			if(ub != null){
                conn.commit();
            }else{
                conn.rollback();
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ub;
	}

	@Override
	public boolean updateUserInfo(UserBean ub) {
		boolean bool = false;
		 Connection conn = null;
	        try {
	            conn = DBUtil.getConn();
	            conn.setAutoCommit(false);
	            String sql = "update address_list set userpwd = ?,phone = ?,email = ?,address = ?, mtext = ? where userid = ?";
	            bool = dao.updateUserInfo(conn, sql,ub);
	            if(bool){
	                conn.commit();
	            }else{
	                conn.rollback();
	            }
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	            try {
	                conn.rollback();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            } finally {
	                try {
	                    DBUtil.freeConnection(conn);
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		return bool;
	}

	@Override
	public boolean delUserInfoById(int userId) {
		boolean bool = false;
		Connection conn = null;
		String sql = "delete from address_list where userid = ?";
		try {
			conn = DBUtil.getConn();
			bool = dao.delUserInfoById(conn, sql, userId);
			if(bool){
				conn.commit();
			}else{
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				DBUtil.freeConnection(conn);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return bool;
	}

	@Override
	public List<UserBean> searchByName(String userName) {
		List<UserBean> list = new ArrayList<UserBean>();
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select userid,username,phone,email,address,mtext from address_list where username like ?";
			list = dao.searchByName(conn, sql, userName);
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				DBUtil.freeConnection(conn);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public boolean addUserInfo(UserBean ub) {
		 boolean bool = false;
	        Connection conn = null;
	        String sql = "insert into address_list values(seq_address_list.nextval,?,?,?,?,?,?)";
	        try {
	            conn = DBUtil.getConn();
	            conn.setAutoCommit(false);
	            bool = dao.addUserInfo(conn, sql, ub);
	            if(bool) {
	                conn.commit();
	            } else {
	                conn.rollback();
	            }
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            try {
	                DBUtil.freeConnection(conn);
	            } catch (SQLException e1) {
	                // TODO Auto-generated catch block
	                e1.printStackTrace();
	            }
	            e.printStackTrace();
	            
	        }
	        return bool;
	}

	@Override
	public boolean validateByUserName(String userName) {
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select * from address_list where username = ?";
			bool = dao.validateByUserName(conn, sql, userName);
			if (bool) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					DBUtil.freeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bool;
	}

	@Override
	public boolean validateByUserId(int userId) {
		boolean bool = false;
		Connection conn = null;
		try {
			conn = DBUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select * from address_list where userid = ?";
			bool = dao.validateByUserId(conn, sql, userId);
			if (bool) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					DBUtil.freeConnection(conn);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return bool;
	}
}
