package com.rahul.shoppingbackend.daoimpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rahul.shoppingbackend.dao.CategoryDAO;
import com.rahul.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Category> list() {
		String selectActiveCategory="FROM Category WHERE active= :active";
		return sessionFactory.getCurrentSession().createQuery(selectActiveCategory,Category.class)
				.setParameter("active", true)
					.getResultList();
	}

	/*
	 * Getting Single Category based on id
	 */
	@Override
	public Category get(int id) {

		return sessionFactory
				.getCurrentSession()
					.get(Category.class, Integer.valueOf(id));
	}

	@Override
	public boolean add(Category category) {

		try {

			// add the category to the database
			sessionFactory
				.getCurrentSession()
					.persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean update(Category category) {
		try {

			// update the category to the database
			sessionFactory
				.getCurrentSession()
					.update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		try {

			// delete the category to the database
			sessionFactory
				.getCurrentSession()
					.update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
