package com.niit.BackEnd.daoimpl;




import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackEnd.dao.ProductDao;
import com.niit.BackEnd.dao.UsersDao;
import com.niit.BackEnd.model.Category;
import com.niit.BackEnd.model.Product;
import com.niit.BackEnd.model.Users;
@Repository("usersDao")
@EnableTransactionManagement
@Transactional
@SuppressWarnings("deprecation")
public class UsersDaoImpl implements  UsersDao{
@Autowired
	
SessionFactory sessionfactory;
public UsersDaoImpl(SessionFactory sessionfactory) {
	this.sessionfactory=sessionfactory;
	
}
public boolean saveorupdate(Users users) {
	sessionfactory.getCurrentSession().saveOrUpdate(users);
	
	return true;
}


public boolean delete(Users users) {
	sessionfactory.getCurrentSession().delete(users);
	
	return true;
}


public Users getUsers(String uId) {
	String use="from Users where userid='"+uId+"'";
	Query q1=sessionfactory.getCurrentSession().createQuery(use);
	List<Users> uselist=(List<Users>)q1.list();
	if(uselist==null||uselist.isEmpty())
	{
		return null;
	}
	
	return uselist.get(0);
	
}


public List<Users> list() {
	// TODO Auto-generated method stub
	return null;
}

}

