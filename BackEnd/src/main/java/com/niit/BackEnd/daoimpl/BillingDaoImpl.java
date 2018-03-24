package com.niit.BackEnd.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackEnd.dao.BillingDao;
import com.niit.BackEnd.model.Billing;
@Repository("billingDao")
@EnableTransactionManagement
@Transactional

public class BillingDaoImpl implements BillingDao{
	@Autowired 
	SessionFactory sessionfactory;
		public BillingDaoImpl(SessionFactory sessionfactory) {
			this.sessionfactory=sessionfactory;
			
		}
		public boolean saveorupdate(Billing billing) {
			sessionfactory.getCurrentSession().saveOrUpdate(billing);
			
			
			return true;
		}

		
		public boolean delete(Billing billing) {
			sessionfactory.getCurrentSession().delete(billing);
			
			return true;
		}

		
		public Billing getbilling(String billId) {
			String bill="from Billing where billId='"+billId+"'";
			Query q1=sessionfactory.getCurrentSession().createQuery(bill);
			List<Billing>billlist=(List<Billing>)q1.list();
			if(billlist==null||billlist.isEmpty())
			{
				return null;
			}
			
			return billlist.get(0);
			
		}

		
		public List<Billing> list() {
		
			return null;
		}

	}



