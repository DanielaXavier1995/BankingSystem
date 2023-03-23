package dao;

import java.util.Objects;

import javax.persistence.EntityManager;

import jpautil.JPAUtil;
import models.User;

public class UserDao {
	
	public static User insertUser(User user) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(user);
			em.getTransaction().commit();
			
		} catch (Exception e){
			System.err.println(e); 
			
			em.getTransaction().rollback();
		} finally {
			em.close();
			//JPAUtil.close();
		}
		return user;
	}
	
	public static User findByIdUser(User user, int id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		user = em.find(User.class, id);
		
		return user;
	}
	
	public static User updateUser(User user, int id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		user = em.find(User.class, id);
		
		try {
			em.getTransaction().begin();
			user.setName("Daniela Maria");
			user.setCpf("10343189429");
			user.setAddress("Av. General San Martin");
			user.setTelephone("996272527");
			em.merge(user);
			em.getTransaction().commit();
			
		} catch (Exception e){
			System.err.println(e); 
			
			em.getTransaction().rollback();
		} finally {
			em.close();
			//JPAUtil.close();
		}
		return user;
	}
	
	public static User deleteUser(User user, int id) {
		EntityManager em = JPAUtil.getEntityManager();
		
		user = em.find(User.class, id);
		
		try {
			em.getTransaction().begin();
			em.remove(user);
			em.getTransaction().commit();
			
		} catch (Exception e){
			System.err.println(e); 
			
			em.getTransaction().rollback();
		} finally {
			em.close();
			//JPAUtil.close();
		}
		return user;
	}
}
