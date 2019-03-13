package com.cts.grizzlystore.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cts.grizzlystore.bean.Product;

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
		// TODO Auto-generated method stub
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

}
