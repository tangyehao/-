package cn.com.dao;

import cn.com.pojo.UserBean;

import java.sql.Connection;
import java.util.List;

public interface UserBeanDAOInf {
	 boolean validateByUserNameAndPwd(Connection c, String sql, String userName, String userPwd);
     List<UserBean> getAllUserInfo(Connection conn,String sql);
     UserBean getUserInfoByName(Connection conn,String sql, String userName);
     UserBean getUserInfoById(Connection conn,String sql, int userId);
     boolean updateUserInfo(Connection conn,String sql, UserBean ub);
     boolean addUserInfo(Connection conn,String sql, UserBean ub);
     boolean delUserInfoById(Connection conn,String sql, int userId);
     List<UserBean> searchByName(Connection conn,String sql, String userName);
     boolean validateByUserName(Connection c, String sql, String userName);
     boolean validateByUserId(Connection c, String sql, int userId);
}
