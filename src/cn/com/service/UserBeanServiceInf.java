package cn.com.service;

import cn.com.pojo.UserBean;

import java.sql.Connection;
import java.util.List;

public interface UserBeanServiceInf {
	 boolean validateByUserNameAndPwd(String userName, String userPwd);
     List<UserBean> getAllUserInfo();
     UserBean getUserInfoByName(String userName);
     UserBean getUserInfoById(int userId);
     boolean updateUserInfo(UserBean ub);
     boolean delUserInfoById(int userId);
     boolean addUserInfo(UserBean ub);
     List<UserBean> searchByName(String userName);
     boolean validateByUserName(String userName);
     boolean validateByUserId(int userId);
}
