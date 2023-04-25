package com.hotelManagement.daoIMPL;

import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotelManagement.dao.StaffMemberDao;
import com.hotelManagement.entity.StaffMember;

@Repository
public class StaffMemberDaoImpl implements StaffMemberDao{

	@Autowired
	SessionFactory factory;
	
	@Override
	public boolean saveStaff(StaffMember staffMember) {
		boolean isAdded = false;
		Session session = null;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			session.save(staffMember);
			transaction.commit();
			isAdded = true;
		} catch (PersistenceException e) {
			isAdded = false;
		}

		catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isAdded;
	}

	@Override
	public StaffMember getStaffById(long id) {
		StaffMember staffMember = null;
		Session session = null;
		try {
			session = factory.openSession();

			staffMember = session.get(StaffMember.class, id);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return staffMember;
	}
	

	@Override
	public boolean updateStaff(StaffMember staffMember) {
		Session session = null;
		boolean isUpdated = false;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();
			StaffMember dbStaffMember = getStaffById(staffMember.getId());
			if (dbStaffMember != null) {
				session.update(staffMember);
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return isUpdated;
	}

	@Override
	public List<StaffMember> getAllStaff() {
		Session session = null;
		List<StaffMember> list = null;
		try {
			session = factory.openSession();
			Criteria criteria = session.createCriteria(StaffMember.class);
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
	public boolean deleteStaffMember(long id) {
		Session session = null;
		boolean isDeleted = false;
		try {
			session = factory.openSession();
			Transaction transaction = session.beginTransaction();

			StaffMember product = session.get(StaffMember.class, id);
			if (product != null) {
				session.delete(product);
				transaction.commit();
				isDeleted = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return isDeleted;
	}

}
