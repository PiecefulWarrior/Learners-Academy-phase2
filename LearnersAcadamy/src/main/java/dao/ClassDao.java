package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.ClassStandard;

import util.HibernateUtil;

public class ClassDao {
	
	ClassStandard cls = null;
	public List<ClassStandard> getAllClasses() {

		Transaction transaction = null;
		List<ClassStandard> listOfClasses = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			listOfClasses = session.createQuery("from ClassStandard").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfClasses;
	}

	public void addClasses(String className) {
		
		cls = new ClassStandard();
		cls.setStandard(className);
	
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			 session.save(cls);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
	}

	public void DeleteClass(int id) {
		// TODO Auto-generated method stub
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			 ClassStandard cls = session.get(ClassStandard.class, id);		
			 if(cls!=null) {
				 session.delete(cls);
			 }
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
	}

}
