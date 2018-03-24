package com.niit.BackEnd.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.BackEnd.dao.Paydao;
import com.niit.BackEnd.model.Pay;
@Repository("payDao")
@EnableTransactionManagement
@Transactional
public class PayDaoImpl implements Paydao{
	@Autowired 
	SessionFactory sessionfactory;
		public PayDaoImpl(SessionFactory sessionfactory) {
			this.sessionfactory=sessionfactory;
			
		}
		public boolean saveorupdate(Pay pay) {
			sessionfactory.getCurrentSession().saveOrUpdate(pay);
			
			
			return true;
		}

		
		public boolean delete(Pay pay) {
			sessionfactory.getCurrentSession().delete(pay);
			
			return true;
		}

		
		public Pay getpay(String payId) {
			String p="from Pay where Payid='"+payId+"'";
			Query q1=sessionfactory.getCurrentSession().createQuery(p);
			List<Pay>plist=(List<Pay>)q1.list();
			if(plist==null||plist.isEmpty())
			{
				return null;
			}
			
			return plist.get(0);
			
		}

		
		public List<Pay> list() {
		
			return null;
		}


}



