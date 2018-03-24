package com.niit.BackEnd.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackEnd.dao.OrderDao;
import com.niit.BackEnd.model.Order;
@Repository("orderDao")
@EnableTransactionManagement
@Transactional
public class OrderDaoImpl implements OrderDao {
	@Autowired 
	SessionFactory sessionfactory;
		public OrderDaoImpl(SessionFactory sessionfactory) {
			this.sessionfactory=sessionfactory;
			
		}
		public boolean saveorupdate(Order order) {
			sessionfactory.getCurrentSession().saveOrUpdate(order);
			
			
			return true;
		}

		
		public boolean delete(Order order) {
			sessionfactory.getCurrentSession().delete(order);
			
			return true;
		}

		
		public Order getorder(String orderId) {
			String or="from Order where orderId='"+orderId+"'";
			Query q1=sessionfactory.getCurrentSession().createQuery(or);
			List<Order>orlist=(List<Order>)q1.list();
			if(orlist==null||orlist.isEmpty())
			{
				return null;
			}
			
			return orlist.get(0);
			
		}

		
		public List<Order> list() {
		
			return null;
		}


}


