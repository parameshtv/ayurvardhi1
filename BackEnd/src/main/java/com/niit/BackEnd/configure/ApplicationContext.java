package com.niit.BackEnd.configure;

	import java.util.Properties;

	import javax.sql.DataSource;

	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.context.annotation.Bean;
	import org.springframework.context.annotation.ComponentScan;
	import org.springframework.context.annotation.Configuration;
	import org.springframework.jdbc.datasource.DriverManagerDataSource;
	import org.springframework.orm.hibernate5.HibernateTransactionManager;
	import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
	import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.BackEnd.dao.BillingDao;
import com.niit.BackEnd.dao.CartDao;
import com.niit.BackEnd.dao.CartitemDao;
import com.niit.BackEnd.dao.CategoryDao;
import com.niit.BackEnd.dao.OrderDao;
import com.niit.BackEnd.dao.OrderitemDao;
import com.niit.BackEnd.dao.Paydao;
import com.niit.BackEnd.dao.ProductDao;
import com.niit.BackEnd.dao.ShippingDao;
import com.niit.BackEnd.dao.SuppliersDao;
import com.niit.BackEnd.dao.UsersDao;
import com.niit.BackEnd.daoimpl.BillingDaoImpl;
import com.niit.BackEnd.daoimpl.CartDaoImpl;
import com.niit.BackEnd.daoimpl.CartitemDaoImpl;
import com.niit.BackEnd.daoimpl.CategoryDaoImpl;
import com.niit.BackEnd.daoimpl.OrderDaoImpl;
import com.niit.BackEnd.daoimpl.OrderitemDaoImpl;
import com.niit.BackEnd.daoimpl.PayDaoImpl;
import com.niit.BackEnd.daoimpl.ProductDaoImpl;
import com.niit.BackEnd.daoimpl.ShippingDaoImpl;
import com.niit.BackEnd.daoimpl.SuppliersDaoImpl;
import com.niit.BackEnd.daoimpl.UsersDaoImpl;
import com.niit.BackEnd.model.Billing;
import com.niit.BackEnd.model.Cart;
import com.niit.BackEnd.model.Cartitem;
import com.niit.BackEnd.model.Category;
import com.niit.BackEnd.model.Order;
import com.niit.BackEnd.model.Orderitem;
import com.niit.BackEnd.model.Pay;
import com.niit.BackEnd.model.Product;
import com.niit.BackEnd.model.Shipping;
import com.niit.BackEnd.model.Suppliers;
import com.niit.BackEnd.model.Users;

	
	@Configuration
	@ComponentScan("com.niit.*")
	@EnableTransactionManagement
	public class ApplicationContext {
	  @Bean("dataSource")
	  public DataSource getDataSource() {
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();
		  dataSource.setDriverClassName("org.h2.Driver");
		  dataSource.setUrl("jdbc:h2:tcp://localhost/~/test/AyurVardhi");
		  dataSource.setUsername("parmesh");
		  dataSource.setPassword("param");
		  return dataSource;
	  }
	   private Properties getHibernateProperties() {
		  Properties properties = new Properties();
		  properties.put("hibernate.connection.pool_size","10");
		  properties.put("hibernate.hbm2ddl.auto","update");
		  properties.put("hibernate.show_sql","true");
		  properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		  return properties;
		  
	   }
	   @Autowired
	   @Bean("sessionFactory")
	   public SessionFactory getSessionFactory(DataSource dataSource) {
		   LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
		   sessionBuilder.addProperties(getHibernateProperties());
		   sessionBuilder.addAnnotatedClass(Category.class);
		   sessionBuilder.addAnnotatedClass(Billing.class);
		   sessionBuilder.addAnnotatedClass(Cart.class);
		   sessionBuilder.addAnnotatedClass(Cartitem.class);
		   sessionBuilder.addAnnotatedClass(Order.class);
		   sessionBuilder.addAnnotatedClass(Orderitem.class);
		   sessionBuilder.addAnnotatedClass(Pay.class);
		   sessionBuilder.addAnnotatedClass(Product.class);
		   sessionBuilder.addAnnotatedClass(Shipping.class);
		   sessionBuilder.addAnnotatedClass(Suppliers.class); 
		   sessionBuilder.addAnnotatedClass(Users.class);
		   
		   return sessionBuilder.buildSessionFactory();
		   }
	   @Autowired
	   @Bean("transactionManager")
	   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		   HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		   return transactionManager;
		  }
	   @Autowired
	   @Bean("categoryDao")
	   public CategoryDao getCategoryDao(SessionFactory sessionFactory) {
		   return new CategoryDaoImpl(sessionFactory);
		   }
	   @Autowired
	   @Bean("billingDao")
	   public BillingDao getBillingDao(SessionFactory sessionFactory) {
		   return new BillingDaoImpl(sessionFactory);
		   }
	   @Autowired
	   @Bean("cartDao")
	   public CartDao getCartDao(SessionFactory sessionFactory) {
		   return new CartDaoImpl(sessionFactory);
		   }
	   @Autowired
	   @Bean("cartitemDao")
	   public CartitemDao getCartitemDao(SessionFactory sessionFactory) {
		   return new CartitemDaoImpl(sessionFactory);
		   }
	   @Autowired
	   @Bean("orderDao")
	   public OrderDao getOrderDao(SessionFactory sessionFactory) {
		   return new OrderDaoImpl(sessionFactory);
		   }
	   @Autowired
	   @Bean("orderitemDao")
	   public OrderitemDao getOrderitemDao(SessionFactory sessionFactory) {
		   return new OrderitemDaoImpl(sessionFactory);
		   }
	   @Autowired
	   @Bean("payDao")
	   public Paydao getPaydao(SessionFactory sessionFactory) {
		   return new PayDaoImpl(sessionFactory);
		   }
	   @Autowired
	   @Bean("productDao")
	   public ProductDao getProductDao(SessionFactory sessionFactory) {
		   return new ProductDaoImpl(sessionFactory);
		   }
	   @Autowired
	   @Bean("shippingDao")
	   public ShippingDao getShippingDao(SessionFactory sessionFactory) {
		   return new ShippingDaoImpl(sessionFactory);
		   }
	   @Autowired
	   @Bean("suppliersDao")
	   public SuppliersDao getSuppliersDao(SessionFactory sessionFactory) {
		   return new SuppliersDaoImpl(sessionFactory);
		   }
	   @Autowired
	   @Bean("usersdao")
	   public UsersDao getUsersDao(SessionFactory sessionFactory) {
		   return new UsersDaoImpl(sessionFactory);
		   }
}
