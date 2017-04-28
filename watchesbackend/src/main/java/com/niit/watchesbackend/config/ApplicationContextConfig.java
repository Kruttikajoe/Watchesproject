package com.niit.watchesbackend.config;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.watchesbackend.DAO.CategoryDAO;
import com.niit.watchesbackend.DAO.CategoryDAOImpl;
import com.niit.watchesbackend.DAO.ProductDAO;
import com.niit.watchesbackend.DAO.ProductDAOImpl;
import com.niit.watchesbackend.DAO.SupplierDAO;
import com.niit.watchesbackend.DAO.SupplierDAOImpl;
import com.niit.watchesbackend.DAO.UserDAO;
import com.niit.watchesbackend.DAO.UserDAOImpl;
import com.niit.watchesbackend.model.Category;
import com.niit.watchesbackend.model.Product;
import com.niit.watchesbackend.model.Supplier;
import com.niit.watchesbackend.model.User;
@Configuration
@ComponentScan("com")
@EnableTransactionManagement


public class ApplicationContextConfig {
	@Bean(name="datasource")
	public DataSource getDataSource()
	{
		BasicDataSource datasource= new BasicDataSource();
		datasource.setDriverClassName("org.h2.Driver");
		datasource.setUrl("jdbc:h2:tcp://localhost/~/Watches");
		datasource.setUsername("sa");
		datasource.setPassword("");
		System.out.println("Datasource");
		return datasource;
	}

private Properties getHibernateProperties()
{
	Properties prop=new Properties();
	prop.put("hibernate.show_sql","true");
	prop.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	prop.put("hibernate.hbm2ddl.auto", "update");
	prop.put("hibernate.current_session_context_class", "thread");
	System.out.println("Hibernate Properties");
	return prop;
}

@Autowired
@Bean (name="sessionFactory")
public SessionFactory getSessionFactory(DataSource datasource)
{
	LocalSessionFactoryBuilder sessionBuilder= new LocalSessionFactoryBuilder(datasource);
	sessionBuilder.addProperties(getHibernateProperties());
	sessionBuilder.addAnnotatedClass(User.class);
	sessionBuilder.addAnnotatedClass(Supplier.class);
	sessionBuilder.addAnnotatedClass(Category.class);
	sessionBuilder.addAnnotatedClass(Product.class);
	System.out.println("Session Factory");
	return sessionBuilder.buildSessionFactory();
	
}

@Autowired 
@Bean(name="transactionManager")
public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory)
{
	HibernateTransactionManager transactionManager= new HibernateTransactionManager(sessionFactory);
	System.out.println("Transaction Manager");
	return transactionManager;
}

@Autowired
@Bean(name="userDAO")
public UserDAO getUserDAO(SessionFactory sessionFactory)
{
	System.out.println("user DAO");
	return new UserDAOImpl();
	
}

@Autowired
@Bean(name="user")

public User getUser()
{
	System.out.println("user");
	return new User();
}

@Autowired
@Bean(name="supplierDAO")

public SupplierDAO getSupplierDAO(SessionFactory sessionFactory)
{
	System.out.println("supplier DAO");
	return new SupplierDAOImpl();
	
}

@Autowired
@Bean(name="supplier")

public Supplier getSupplier()
{
	System.out.println("supplier");
	return new Supplier();
}

@Autowired
@Bean(name="categoryDAO")

public CategoryDAO getCategoryDAO(SessionFactory sessionFactory)
{
	System.out.println("category DAO");
	return new CategoryDAOImpl();
	
}

@Autowired
@Bean(name="category")

public Category getCategory()
{
	System.out.println("Category");
	return new Category();
}

@Autowired
@Bean(name="productDAO")

public ProductDAO getProductDAO(SessionFactory sessionFactory)
{
	System.out.println("product DAO");
	return new ProductDAOImpl();
}

@Autowired
@Bean(name="product")

public Product getProduct()
{
	System.out.println("Product");
	return new Product();
}

}
