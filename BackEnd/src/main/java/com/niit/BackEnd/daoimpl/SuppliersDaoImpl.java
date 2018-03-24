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
import com.niit.BackEnd.dao.SuppliersDao;
import com.niit.BackEnd.model.Category;
import com.niit.BackEnd.model.Product;
import com.niit.BackEnd.model.Suppliers;
@Repository("suppliersDao")
@EnableTransactionManagement
@Transactional

public class SuppliersDaoImpl implements  SuppliersDao{
@Autowired
	
SessionFactory sessionfactory;
public SuppliersDaoImpl(SessionFactory sessionfactory) {
	this.sessionfactory=sessionfactory;
	
}
public boolean saveorupdate(Suppliers suppliers) {
	sessionfactory.getCurrentSession().saveOrUpdate(suppliers);
	
	return true;
}


public boolean delete(Suppliers suppliers) {
	sessionfactory.getCurrentSession().delete(suppliers);
	
	return true;
}


public Suppliers getsuppliers(String sId) {
	String supply="from Suppliers where sId='"+sId+"'";
	Query q1=sessionfactory.getCurrentSession().createQuery(supply);
	List<Suppliers> supplylist=(List<Suppliers>)q1.list();
	if(supplylist==null||supplylist.isEmpty())
	{
		return null;
	}
	
	return supplylist.get(0);
	
	
}


public List<Suppliers> list() {
	List<Suppliers> suppliers=(List<Suppliers>) sessionfactory.getCurrentSession().createCriteria(Suppliers.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
	
	return suppliers;
}

}




