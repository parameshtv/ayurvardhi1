package com.niit.BackEnd.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackEnd.dao.ShippingDao;
import com.niit.BackEnd.model.Shipping;
@Repository("shippingDao")
@EnableTransactionManagement
@Transactional
public class ShippingDaoImpl implements ShippingDao {
	@Autowired 
	SessionFactory sessionfactory;
		public ShippingDaoImpl(SessionFactory sessionfactory) {
			this.sessionfactory=sessionfactory;
			
		}
		public boolean saveorupdate(Shipping shipping) {
			sessionfactory.getCurrentSession().saveOrUpdate(shipping);
			
			
			return true;
		}

		
		public boolean delete(Shipping shipping) {
			sessionfactory.getCurrentSession().delete(shipping);
			
			return true;
		}

		
		public Shipping getshipping(String shippingId) {
			String ship="from shipping where shippingId='"+shippingId+"'";
			Query q1=sessionfactory.getCurrentSession().createQuery(ship);
					
			List<Shipping>shippinglist=(List<Shipping>)q1.list();
			if(shippinglist==null||shippinglist.isEmpty())
			{
				return null;
			}
			
			return shippinglist.get(0);
			
		}

		
		public List<Shipping> list() {
		
			return null;
		}
		@Override
		public Shipping getShipping(String shippingid) {
			// TODO Auto-generated method stub
			return null;
		}


}
