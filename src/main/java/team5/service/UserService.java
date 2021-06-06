package team5.service;

import java.util.ArrayList;

import team5.model.RoleType;
import team5.model.User;


public interface UserService extends IService<User>{

	public ArrayList<User> findByJobRole(RoleType roleType);
	public User findByUsername(String userName);
	public void deleteUsers(String[] users);
	boolean updateUser(User user);
}