package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Subjects;
import util.HibernateUtil;

public class SubjectDao {

	Subjects sub = null;
	
	public List<Subjects> getAllSubjects() {

		Transaction transaction = null;
		List<Subjects> listOfsubjects = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			listOfsubjects = session.createQuery("from Subjects").getResultList();
			
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

	public void addSubject(String subject) {
		
		sub = new Subjects();
		sub.setSub_name(subject);
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			 session.save(sub);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
	}

	public void DeleteSubject(int id) {
		// TODO Auto-generated method stub
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			 Subjects sub = session.get(Subjects.class, id);		
			 if(sub!=null) {
				 session.delete(sub);
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

