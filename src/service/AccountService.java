package service;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.AccountDao;
import dao.UserDao;
import jpautil.JPAUtil;
import models.Account;
import models.User;

public class AccountService {
	
	EntityManager em = JPAUtil.getEntityManager();
	AccountDao accountDao = new AccountDao();

	public Boolean getNumberAccount(Account account) {

		List<Account> accounts = accountList();

		for (Account a : accounts) {
			if (a.getNumberAccount().equals(account.getNumberAccount())) {
				System.out.println("The number account alread exist!");
                return true;
			}
		}
		accountDao.InsertAccount(account);
		System.out.println("Number account don't find!");
		return false;
	}

	private List<Account> accountList() {
		Query query = em.createQuery("From Account");
		return query.getResultList();
	}
	
   public Account getIdAccount(Account account, int idAccount) {
		
		account = accountDao.findByIdAccount(account, idAccount);
		
		if (Objects.nonNull(account)) {
			System.out.println(account.toString());
		} else {
			System.out.println("Object doesn't exist!!");
		}
		
		return account;
	}
   
   public Account getIdAccountUpdate(Account account, int idAccount) {
		
		if (Objects.nonNull(account)) {
			account = accountDao.updateAccount(account, idAccount);
			System.out.println("Object changed with success!!");
		} else {
			System.out.println("Object doesn't exist!!");
		}
		return account;
	}
   
   public Account getIdAccountDelete(Account account, int idAccount) {
		
		if (Objects.nonNull(account)) {
			account = accountDao.deleteAccount(account, idAccount);
			System.out.println("Object deleted with success!!");
		} else {
			System.out.println("Object doesn't exist!!");
		}
		return account;
	}
   
   public Account verificationDeposit(Account account, int idAccount) {
	   
		account = em.find(Account.class, idAccount);
		
	   if ((account.getStatusAccount().equals("1") || account.getNumberAccount().isEmpty())) {
		   account = accountDao.deposit(account, 200.00);
		   System.out.println("Deposit finalized!!");
	   } else {
		   System.out.println("Account isn't open or account not find!!");
	   }
	   return account;
   }
   
   public Account verificationWithdraw(Account account, int idAccount, Double saque) {
	   
		account = em.find(Account.class, idAccount);
		
	   if ((account.getStatusAccount().equals("1") || account.getNumberAccount().isEmpty()) && account.getBalance() > saque) {
		   account = accountDao.withdraw(account, 200.00);
		   System.out.println("Withdraw finalized!!");
	   } else {
		   System.out.println("Account isn't open or find, or your balance is insufficient!!");
	   }
	   return account;
  }
   
   public void verificationBankTransfer(int idAccount1, int idAccount2, Double value) {
	   
		Account account1 = em.find(Account.class, idAccount1);
		Account account2 = em.find(Account.class, idAccount2);
		
	   if ((account1.getStatusAccount().equals("1") && account2.getStatusAccount().equals("1")) && account1.getBalance() > value) {
           accountDao.bankTransfer(75, 76, 100.00);
           System.out.println("Bank Transfer finalized!!");
	   } else {
		   System.out.println("Account isn't open or your balance is insufficient!!");
	   }
   }
   
   public void verificationBankLoan(Account account, int idAccount) {
	   
	   account = em.find(Account.class, idAccount);
		
	   if ((account.getStatusAccount().equals("1") || account.getNumberAccount().isEmpty())) {
		    accountDao.bankLoan(account, 1000.00);
		    System.out.println("Bank loan completed!!");
	   } else {
		   System.out.println("Account isn't open or account not find!!");
	   }
  }
}
