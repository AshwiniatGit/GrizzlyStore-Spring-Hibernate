package com.cts.grizzlystore.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.grizzlystore.bean.Product;
import com.cts.grizzlystore.bean.User;

@Repository
@Transactional
public class ProductDAOImpl implements ProductDAO{

	 @Autowired
	private SessionFactory sessionFactory;
	 
	public String addProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println(product.getCategory());
		sessionFactory.getCurrentSession().save(product);
		return "success";
	}

	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		 TypedQuery<Product> query = sessionFactory.getCurrentSession().createQuery("from Product");
		 
	      return query.getResultList();
	}

	public Product findProduct(String id) {
		try{
			Session session = sessionFactory.getCurrentSession();
			String query = "from Product where id = ?";
			Query<Product> query2 = null;
			query2=session.createQuery(query);
			query2.setParameter(0,id);   
			Product product= query2.getSingleResult();
			if(product!=null)
			{
				
			return product;
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

	public String deleteProduct(String productId) {
		Product product = sessionFactory.getCurrentSession().load(Product.class, productId);
		sessionFactory.getCurrentSession().delete(product);
		return "success";
	}

	public List<Product> filterProducts(String query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProduct(Product product) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		return "success";
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		try{
			Session session = sessionFactory.getCurrentSession();
			String query = "from Product where category = ?";
			Query<Product> query2 = null;
			query2=session.createQuery(query);
			query2.setParameter(0,category);   
			return query2.getResultList();
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
	}

	@Override
	public List<Product> sortProductsByRating(String sorting) {
		try{
			String query = "from Product order by rating";
			if(sorting.equals("HighToLow")){
				query = "from Product order by rating desc";
			}
			Session session = sessionFactory.getCurrentSession();
			Query<Product> query2 = null;
			query2=session.createQuery(query);  
			return query2.getResultList();
			
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return null;
	}
	
	}

