package com.niit.BackEnd.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackEnd.dao.CartDao;
import com.niit.BackEnd.model.Cart;
@Repository("cartDao")
@EnableTransactionManagement
@Transactional

public class CartDaoImpl implements CartDao {
	@Autowired 
	SessionFactory sessionfactory;
		public CartDaoImpl(SessionFactory sessionfactory) {
			this.sessionfactory=sessionfactory;
			
		}
		public boolean saveorupdate(Cart cart) {
			sessionfactory.getCurrentSession().saveOrUpdate(cart);
			
			
			return true;
		}

		
		public boolean delete(Cart cart) {
			sessionfactory.getCurrentSession().delete(cart);
			
			return true;
		}

		
		public Cart getcart(String cartId) {
			String cart="from Cart where cartId='"+cartId+"'";
			Query q1=sessionfactory.getCurrentSession().createQuery(cart);
			List<Cart>cartlist=(List<Cart>)q1.list();
			if(cartlist==null||cartlist.isEmpty())
			{
				return null;
			}
			
			return cartlist.get(0);
			
		}

		
		public List<Cart> list() {
		
			return null;
		}

	}


