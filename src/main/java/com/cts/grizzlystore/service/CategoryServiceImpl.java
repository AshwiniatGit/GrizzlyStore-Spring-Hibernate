package com.cts.grizzlystore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.grizzlystore.bean.Category;
import com.cts.grizzlystore.dao.CategoryDAO;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	CategoryDAO dao;
	
	@Override
	public List<Category> getCategory() {
		
		return  dao.getCategory();
	}

}
