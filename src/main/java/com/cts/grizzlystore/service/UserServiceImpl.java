package com.cts.grizzlystore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cts.grizzlystore.bean.User;
import com.cts.grizzlystore.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO userDAO;

	@Override

	@Transactional(readOnly = true, propagation=Propagation.SUPPORTS)
	public User authenticateUser(User user) {
		// TODO Auto-generated method stub
		return userDAO.authenticateUser(user);
	}

	@Override
	public int getUserStatus(User user) {
		// TODO Auto-generated method stub
		return userDAO.getUserStatus(user);
	}

	@Override
	public String getUserType(User user) {
		// TODO Auto-generated method stub
		return userDAO.getUserType(user);
	}

	@Override
	public User checkUser(String id) {
		// TODO Auto-generated method stub
		return userDAO.checkUser(id);
	}

	@Override
	public void resetStatus(User user) {
		// TODO Auto-generated method stub
		userDAO.resetStatus(user);
	}

	@Override
	public void inceraseAttempt(User user) {
		// TODO Auto-generated method stub
		userDAO.inceraseAttempt(user);
	}
	
	
}
