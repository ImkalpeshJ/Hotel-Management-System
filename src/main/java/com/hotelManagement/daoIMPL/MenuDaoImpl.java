package com.hotelManagement.daoIMPL;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelManagement.dao.MenuDao;
import com.hotelManagement.entity.Menu;

@Repository
public class MenuDaoImpl implements MenuDao{

	@Autowired
	SessionFactory sf;
	
	@Override
	public int[] uploadSheet(List<Menu> list) {
		Session session = null;
		int addedCount = 0;
		int excludedCount = 0;
		int []arr=new int[2];
		for (Menu menu : list) {
			session = sf.openSession();
			try {
				session.save(menu);
				session.beginTransaction().commit();
				addedCount += 1;
			} catch (PersistenceException e) {
				System.out.println("duplicate");
				excludedCount += 1;
			} catch (Exception e) {
				e.printStackTrace();
			} arr[0] = addedCount;
			arr[1]=excludedCount;
		}
		return arr;
	}

	@Override
	public List<Menu> getMenu() {
		Session session = null;
		List<Menu> list = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Menu.class);
			list = criteria.list();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	@Override
	public List<Menu> getMenuAsc() {
		Session session = null;
		List<Menu> list = null;
		try {
			session = sf.openSession();
			Criteria criteria = session.createCriteria(Menu.class);
			criteria.addOrder(Order.asc("price"));
			list = criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

}
