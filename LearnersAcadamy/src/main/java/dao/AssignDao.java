package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;


import util.HibernateUtil;

public class AssignDao {

	public List<String> getAllClasses() {
		
		Transaction transaction = null;
		List<String> listOfClasses= null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			listOfClasses = session.createQuery("standard from ClassStandard").getResultList();
			
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

	public List<String> getAllSubjects() {
		

			Transaction transaction = null;
			List<String> listOfsubjects = null;
			try (Session session = HibernateUtil.getSessionFactory().openSession()) {
				// start a transaction
				transaction = session.beginTransaction();
				// get an user object
				
				listOfsubjects = session.createQuery("sub_name from Subjects").getResultList();
				
				// commit transaction
				transaction.commit();
			} catch (Exception e) {
				if (transaction != null) {
					transaction.rollback();
				}
				e.printStackTrace();
			}
			return listOfsubjects;
		
	}

	public List<String> getAllTeachers() {
		Transaction transaction = null;
		List<String> listOfTeachers = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			listOfTeachers = session.createQuery("teacher_name from Teachers").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfTeachers;
	
	}

}
