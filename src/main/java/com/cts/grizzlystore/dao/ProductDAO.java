package com.cts.grizzlystore.dao;

import java.util.List;

import com.cts.grizzlystore.bean.Category;
import com.cts.grizzlystore.bean.Product;


public interface ProductDAO {
	public String addProduct(Product product);
	public List<Product> getAllProducts();
	public Product findProduct(String id);
	public String deleteProduct(String productId);
	public List<Product> sortProductsByRating(String sorting);
	public String updateProduct(Product product);
	public List<Product> getProductByCategory(String category);
}
