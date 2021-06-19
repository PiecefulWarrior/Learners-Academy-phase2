package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import models.Teachers;
import util.HibernateUtil;

public class TeacherDao {
	
	Teachers teach = null;
	public List<Teachers> getAllTeachers() {

		Transaction transaction = null;
		List<Teachers> listOfteachers = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			listOfteachers = session.createQuery("from Teachers").getResultList();
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return listOfteachers;
	}

	public void addTeachers(String teacher,String mail) {
		
		teach = new Teachers();
		teach.setTeacher_name(teacher);
		teach.setEmail(mail);
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			 session.save(teach);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		
	}

	public void DeleteTeacher(int id) {
		// TODO Auto-generated method stub
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			 Teachers sub = session.get(Teachers.class, id);		
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
