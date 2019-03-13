package com.cts.grizzlystore.service;

import com.cts.grizzlystore.bean.User;


public interface UserService {
	
	public User authenticateUser(User user);
	public int getUserStatus(User user);
	public String getUserType(User user);
	public User checkUser(String id);
	public void resetStatus(User user);
	public void inceraseAttempt(User user);
}
