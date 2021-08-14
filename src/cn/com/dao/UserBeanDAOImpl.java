package cn.com.dao;

import cn.com.db.DBUtil;
import cn.com.pojo.UserBean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserBeanDAOImpl implements UserBeanDAOInf{

    @Override
    public List<UserBean> getAllUserInfo(Connection conn, String sql) {
        List<UserBean> list = new ArrayList<UserBean>();
        UserBean ub = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while(rs.next()) {
            	ub = new UserBean();
            	ub.setUserid(rs.getInt("userid"));
            	ub.setUsername(rs.getString("username"));
            	ub.setPhone(rs.getString("phone"));
            	ub.setEmail(rs.getString("email"));
            	ub.setAddress(rs.getString("address"));
            	ub.setMtext(rs.getString("mtext"));
                list.add(ub);
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return list;
    }

	@Override
	public boolean validateByUserNameAndPwd(Connection c, String sql, String userName, String userPwd) {
		 boolean bool = false;
	        PreparedStatement pstm = null;
	        ResultSet rs = null;
	        try {
	            pstm = c.prepareStatement(sql);
	            pstm.setString(1, userName);
	            pstm.setString(2, userPwd);
	            rs = pstm.executeQuery();
	            bool = rs.next();
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        } finally {
	            try {
	                DBUtil.freeResultSet(rs);
	                DBUtil.freeStatement(pstm);
	            } catch (SQLException throwables) {
	                throwables.printStackTrace();
	            }
	        }
	        return bool;
	}

	@Override
	public UserBean getUserInfoByName(Connection conn, String sql, String userName) {
	        UserBean ub = null;
	        PreparedStatement pstm = null;
	        ResultSet rs = null;
	        try {
	            pstm = conn.prepareStatement(sql);
	            pstm.setString(1, userName);
	            rs = pstm.executeQuery();
	            if(rs.next()) {
	            	ub = new UserBean();
	            	ub.setUserid(rs.getInt("userid"));
	            	ub.setUsername(rs.getString("username"));
	            	ub.setPhone(rs.getString("phone"));
	            	ub.setEmail(rs.getString("email"));
	            	ub.setAddress(rs.getString("address"));
	            	ub.setMtext(rs.getString("mtext"));
	            }

	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        } finally {
	            try {
	                DBUtil.freeResultSet(rs);
	                DBUtil.freeStatement(pstm);
	            } catch (SQLException e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	        }
	        return ub;
	}

	@Override
	public UserBean getUserInfoById(Connection conn, String sql, int userId) {
		UserBean ub = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, userId);
            rs = pstm.executeQuery();
            if(rs.next()) {
            	ub = new UserBean();
            	ub.setUserid(rs.getInt("userid"));
            	ub.setUsername(rs.getString("username"));
            	ub.setPhone(rs.getString("phone"));
            	ub.setEmail(rs.getString("email"));
            	ub.setAddress(rs.getString("address"));
            	ub.setMtext(rs.getString("mtext"));
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return ub;
	}

	@Override
	public boolean updateUserInfo(Connection conn, String sql, UserBean ub) {
		 boolean bool = false;
	        PreparedStatement pstm = null;
	        ResultSet rs = null;
	        try {
	            pstm = conn.prepareStatement(sql);
	            pstm.setString(1, ub.getUserpwd());
	            pstm.setString(2, ub.getPhone());
	            pstm.setString(3, ub.getEmail());
	            pstm.setString(4, ub.getAddress());
	            pstm.setString(5, ub.getMtext());
	            pstm.setInt(6, ub.getUserid());
	            rs = pstm.executeQuery();
	            bool = rs.next();
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        } finally {
	            try {
	                DBUtil.freeResultSet(rs);
	                DBUtil.freeStatement(pstm);
	            } catch (SQLException throwables) {
	                throwables.printStackTrace();
	            }
	           
	        }
	       return bool;
	}

	@Override
	public boolean delUserInfoById(Connection conn, String sql, int userId) {
		boolean bool = false;
        PreparedStatement pstm = null;     
        try {
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, userId);
            int rs = pstm.executeUpdate();
            if(rs > 0){
            	bool = true;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                DBUtil.freeStatement(pstm);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return bool;
	}

	@Override
	public List<UserBean> searchByName(Connection conn, String sql, String userName) {
		// TODO Auto-generated method stub
				List<UserBean> list = new ArrayList<UserBean>();
				UserBean ub= null;
				PreparedStatement pstm = null;
				ResultSet rs = null;
				try {
					pstm = conn.prepareStatement(sql);
					pstm.setString(1,"%"+userName+"%");
					rs = pstm.executeQuery();
					while (rs.next()) {
						ub = new UserBean();
						ub.setUsername(rs.getString("username"));
						ub.setPhone(rs.getString("phone"));
						ub.setEmail(rs.getString("email"));
						ub.setAddress(rs.getString("address"));
						ub.setMtext(rs.getString("mtext"));
						list.add(ub);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					try {
						DBUtil.freeResultSet(rs);
						DBUtil.freeStatement(pstm);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				return list;
	}

	@Override
	public boolean addUserInfo(Connection conn, String sql, UserBean ub) {
		boolean bool = false;
		PreparedStatement pstm = null;
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1,ub.getUsername());
			pstm.setString(2,ub.getUserpwd());
			pstm.setString(3,ub.getPhone());
			pstm.setString(4,ub.getEmail());
			pstm.setString(5,ub.getAddress());
			pstm.setString(6,ub.getMtext());
			int len = pstm.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				DBUtil.freeStatement(pstm);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bool;
	}

	@Override
	public boolean validateByUserName(Connection c, String sql, String userName) {
		 boolean bool = false;
	        PreparedStatement pstm = null;
	        ResultSet rs = null;
	        try {
	            pstm = c.prepareStatement(sql);
	            pstm.setString(1, userName);
	            rs = pstm.executeQuery();
	            bool = rs.next();
	        } catch (SQLException throwables) {
	            throwables.printStackTrace();
	        } finally {
	            try {
	                DBUtil.freeResultSet(rs);
	                DBUtil.freeStatement(pstm);
	            } catch (SQLException throwables) {
	                throwables.printStackTrace();
	            }
	        }
	        return bool;
	}

	@Override
	public boolean validateByUserId(Connection c, String sql, int userId) {
		boolean bool = false;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = c.prepareStatement(sql);
            pstm.setInt(1, userId);
            rs = pstm.executeQuery();
            bool = rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                DBUtil.freeResultSet(rs);
                DBUtil.freeStatement(pstm);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return bool;
	}

	
	
}
