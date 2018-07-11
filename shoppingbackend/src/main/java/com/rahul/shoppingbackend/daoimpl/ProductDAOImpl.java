package com.rahul.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.shoppingbackend.dao.ProductDAO;

import com.rahul.shoppingbackend.dto.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Product get(int id) {
		
		return sessionFactory
				.getCurrentSession()
					.get(Product.class, Integer.valueOf(id));
	}

	@Override
	public List<Product> list() {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product",Product.class)
						.getResultList();
	}

	@Override
	public boolean add(Product product) {
		try
		{
			sessionFactory 
				.getCurrentSession()
					.persist(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean update(Product product) {
		try
		{
			sessionFactory
				.getCurrentSession()
					.update(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Product product) {
		product.setActive(false);
		try
		{
			sessionFactory
				.getCurrentSession()
					.update(product);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Product> listActiveProducts() {
		
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active", Product.class)
						.setParameter("active", true)
							.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId) {
		String selectActiveProductByCategory="FROM Product WHERE active = :active AND categoryId= :categoryId";
		return sessionFactory
				.getCurrentSession()
					.createQuery(selectActiveProductByCategory,Product.class)
						.setParameter("active", true)
							.setParameter("categoryId", categoryId)
								.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProducts(int count) {
		return sessionFactory
				.getCurrentSession()
					.createQuery("FROM Product WHERE active = :active ORDER BY id",Product.class)
						.setParameter("active", true)
							.setFirstResult(0)
								.setMaxResults(count)
									.getResultList();
	}

}
