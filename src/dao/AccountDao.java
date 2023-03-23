package dao;

import java.util.Calendar;

import javax.persistence.EntityManager;

import jpautil.JPAUtil;
import models.Account;
import models.User;

public class AccountDao {
	
	public void InsertAccount(Account account) {
		EntityManager em = JPAUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(account);
			em.getTransaction().commit();
			
		} catch (Exception e){
			System.err.println(e); 
			
			em.getTransaction().rollback();
		} finally {
			em.close();
			//JPAUtil.close();
		}
   }

	public static Account findByIdAccount(Account account, int idAccount) {
		EntityManager em = JPAUtil.getEntityManager();
		
		account = em.find(Account.class, idAccount);
		
		return account;
	}
	
	public static Account updateAccount(Account account, int idAccount) {
		EntityManager em = JPAUtil.getEntityManager();
		
		account = em.find(Account.class, idAccount);
		
		try {
			em.getTransaction().begin();
			account.setNumberAccount("134567");
			account.setStatusAccount("1");
			account.setTypeAccount("poupança");
			account.setFirstDepositAccount(500.00);
			account.setBalance(account.getFirstDepositAccount());
			em.merge(account);
			em.getTransaction().commit();
			
		} catch (Exception e){
			System.err.println(e); 
			
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return account;
	}
	
	public static Account deleteAccount(Account account, int idAccount) {
		EntityManager em = JPAUtil.getEntityManager();
		
		account = em.find(Account.class, idAccount);
		
		try {
			em.getTransaction().begin();
			em.remove(account);
			em.getTransaction().commit();
			
		} catch (Exception e){
			System.err.println(e); 
			
			em.getTransaction().rollback();
		} finally {
			em.close();
			//JPAUtil.close();
		}
		return account;
	}
	
	public static Account deposit(Account account, Double deposit) {
		
    EntityManager em = JPAUtil.getEntityManager();
		
		Double balance = account.getBalance() + deposit;
		
		try {
			em.getTransaction().begin();
			account.setBalance(balance);
			em.merge(account);
			em.getTransaction().commit();
			
		} catch (Exception e){
			System.err.println(e); 
			
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return account;
	}
	
	public static Account withdraw(Account account, Double saque) {
    EntityManager em = JPAUtil.getEntityManager();
		
		Double balance = account.getBalance() - saque;
		
		try {
			em.getTransaction().begin();
			account.setBalance(balance);
			em.merge(account);
			em.getTransaction().commit();
			
		} catch (Exception e){
			System.err.println(e); 
			
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
		return account;
	}
	
	public static void bankTransfer(int idAccount1, int idAccount2, Double value) {
	    EntityManager em = JPAUtil.getEntityManager();
	  
	       Account account1 = em.find(Account.class, idAccount1);
		   Account account2 = em.find(Account.class, idAccount2);
			
			Double balance1 = account1.getBalance() - value;
			Double balance2 = account2.getBalance() + value;
			
			try {
				em.getTransaction().begin();
				account1.setBalance(balance1);
				account2.setBalance(balance2);
				em.merge(account1);
				em.merge(account2);
				em.getTransaction().commit();
				
			} catch (Exception e){
				System.err.println(e); 
				
				em.getTransaction().rollback();
			} finally {
				em.close();
			}
		}
	
	public static void bankLoan(Account account, Double value) {
		
	    EntityManager em = JPAUtil.getEntityManager();
			
			Double balance = account.getBalance() + value;
			
			try {
				em.getTransaction().begin();
				account.setBalance(balance);
				em.merge(account);
				em.getTransaction().commit();
				
			} catch (Exception e){
				System.err.println(e); 
				
				em.getTransaction().rollback();
			} finally {
				em.close();
			}
		}
}
	
		
	

