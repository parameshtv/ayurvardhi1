package com.niit.BackEnd.daoimpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackEnd.dao.CategoryDao;
import com.niit.BackEnd.model.Category;

@Repository("categoryDao")
@EnableTransactionManagement
@Transactional
public class CategoryDaoImpl implements CategoryDao {
@Autowired 
SessionFactory sessionfactory;
	public CategoryDaoImpl(SessionFactory sessionfactory) {
		this.sessionfactory=sessionfactory;
		
	}
	public boolean saveorupdate(Category category) {
		sessionfactory.getCurrentSession().saveOrUpdate(category);
		
		return true;
	}

	
	public boolean delete(Category category) {
		sessionfactory.getCurrentSession().delete(category);
		
		return true;
	}

	
	public Category getcategory(String catId) {
		String cat="from Category where catId='"+catId+"'";
		Query q1=sessionfactory.getCurrentSession().createQuery(cat);
		List<Category>catlist=(List<Category>)q1.list();
		if(catlist==null||catlist.isEmpty())
		{
			return null;
		}
		
		return catlist.get(0);
		
	}

	
	public List<Category> list() {
	List<Category> category=(List<Category>) sessionfactory.getCurrentSession().createCriteria(Category.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
		return category;
	}

}
