package com.niit.BackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackEnd.dao.ProductDao;
import com.niit.BackEnd.model.Category;
import com.niit.BackEnd.model.Product;
@Repository("productDao")
@EnableTransactionManagement
@Transactional

public class ProductDaoImpl implements  ProductDao{
@Autowired
	
SessionFactory sessionfactory;
public ProductDaoImpl(SessionFactory sessionfactory) {
	this.sessionfactory=sessionfactory;
	
}
public boolean saveorupdate(Product product) {
	sessionfactory.getCurrentSession().saveOrUpdate(product);
	
	return true;
}


public boolean delete(Product product) {
	sessionfactory.getCurrentSession().delete(product);
	
	return true;
}


public Product getproduct(String pId) {
	String prod="from Product where pId='"+pId+"'";
	Query q1=sessionfactory.getCurrentSession().createQuery(prod);
	List<Product> prodlist=(List<Product>)q1.list();
	if(prodlist==null||prodlist.isEmpty())
	{
		return null;
	}
	
	return prodlist.get(0);
	
}


public List<Product> list() {
	
		List<Product> product=(List<Product>) sessionfactory.getCurrentSession().createCriteria(Product.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		
			return product;
		}
}




