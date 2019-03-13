package com.cts.grizzlystore.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.grizzlystore.bean.User;

@Repository
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	
	public User authenticateUser(User user) {
		// TODO Auto-generated method stub
		try{
		String userId = user.getUserId();
		String password = user.getPassword();
		Session session = sessionFactory.getCurrentSession();
		String query = "from User where userId = ? and password = ?";
		Query<User> query2 = null;
		
		query2=session.createQuery(query);
		
		query2.setParameter(0,userId);  
		query2.setParameter(1,password);  
		User user1= query2.getSingleResult();
		
		if(user1!=null)
		{
			
		return user1;
		}
		else
		{
			
			return null;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int getUserStatus(User user) {

		return user.getUserStatus();
	}

	@Override
	public String getUserType(User user) {
		// TODO Auto-generated method stub
		return user.getUserType();
	}

	@Override
	public User checkUser(String id) {
		try{
			Session session = sessionFactory.getCurrentSession();
			String query = "from User where userId = ?";
			Query<User> query2 = null;
			query2=session.createQuery(query);
			query2.setParameter(0,id);  
			User user1= query2.getSingleResult();
			if(user1!=null)
			{
				
			return user1;
			}
			else
			{
				
				return null;
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public void resetStatus(User user) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(user);
	}

	@Override
	public void inceraseAttempt(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
			
	}
	


}
