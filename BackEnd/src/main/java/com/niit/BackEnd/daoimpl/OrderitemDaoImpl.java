package com.niit.BackEnd.daoimpl;

import java.util.List;


import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackEnd.dao.OrderitemDao;
import com.niit.BackEnd.model.Orderitem;
@Repository("orderitemDao")
@EnableTransactionManagement
@Transactional

public class OrderitemDaoImpl implements OrderitemDao {
	@Autowired 
	SessionFactory sessionfactory;
		public OrderitemDaoImpl(SessionFactory sessionfactory) {
			this.sessionfactory=sessionfactory;
			
		}
		public boolean saveorupdate(Orderitem orderitem) {
			sessionfactory.getCurrentSession().saveOrUpdate(orderitem);
			
			
			return true;
		}

		
		public boolean delete(Orderitem orderitem) {
			sessionfactory.getCurrentSession().delete(orderitem);
			
			return true;
		}

		
		public Orderitem getorderitem(String orderitemid) {
			String orit="from Orderitem where orderitemid='"+orderitemid+"'";
			Query q1=sessionfactory.getCurrentSession().createQuery(orit);
			List<Orderitem>oritlist=(List<Orderitem>)q1.list();
			if(oritlist==null||oritlist.isEmpty())
			{
				return null;
			}
			
			return oritlist.get(0);
			
		}

		
		public List<Orderitem> list() {
		
			return null;
		}


}




