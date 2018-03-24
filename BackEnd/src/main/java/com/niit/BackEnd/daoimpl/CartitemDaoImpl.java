package com.niit.BackEnd.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackEnd.dao.CartitemDao;
import com.niit.BackEnd.model.Cartitem;
@Repository("cartitemDao")
@EnableTransactionManagement
@Transactional
public class CartitemDaoImpl implements CartitemDao{
	@Autowired 
	SessionFactory sessionfactory;
		public CartitemDaoImpl(SessionFactory sessionfactory) {
			this.sessionfactory=sessionfactory;
			
		}
		public boolean saveorupdate(Cartitem cartitem) {
			sessionfactory.getCurrentSession().saveOrUpdate(cartitem);
			
			
			return true;
		}

		
		public boolean delete(Cartitem cartitem) {
			sessionfactory.getCurrentSession().delete(cartitem);
			
			return true;
		}

		
		public Cartitem getcartitem(String cartitemId) {
			String cartitem="from Cartitem where cartitemId='"+cartitemId+"'";
			Query q1=sessionfactory.getCurrentSession().createQuery(cartitem);
			List<Cartitem>cartitemlist=(List<Cartitem>)q1.list();
			if(cartitemlist==null||cartitemlist.isEmpty())
			{
				return null;
			}
			
			return cartitemlist.get(0);
			
		}

		
		public List<Cartitem> list() {
		
			return null;
		}


}
