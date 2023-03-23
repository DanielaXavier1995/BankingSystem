package app;

import java.util.Calendar;

import javax.persistence.EntityManager;

import dao.AccountDao;
import dao.UserDao;
import jpautil.JPAUtil;
import models.Account;
import models.User;
import service.AccountService;
import service.UserService;

public class AppBank {

		public static void main(String[] args) {
			
			UserService userService = new UserService();
			User user = new User();
			
			//Inserindo Usuário:
//			user.setName("aaaaaaa");
//			user.setCpf("00000000000");
//			user.setAddress("Est. do bongi");
//			user.setTelephone("00000000000");
////			
//	    	userService.getCpfUser(user);
		    
			//Buscando Usuário:
			//userService.getIdUser(user, 41);
			
			//Buscando todos os usuários:
			//userService.findAllUser();
			
			//Atualizando usuário:
			//userService.getIdUserUpdate(user, 40);
			
			//Deletar usuário:
			//userService.getIdUserDelete(user, 37);
			
			AccountService accountService = new AccountService();
			Account account = new Account();
	    	
			//Inserindo Conta:
//	    	account.setUser(user);
//			account.setNumberAccount("000000");
//			account.setStatusAccount("0");
//			account.setTypeAccount("conta corrente");
//		    account.setCreationDateAccount(Calendar.getInstance());
//			account.setFirstDepositAccount(1000.00);
//			account.setBalance(account.getFirstDepositAccount());
////			
//			accountService.getNumberAccount(account);
			
			//Buscando Conta:
			//accountService.getIdAccount(account, 71);
			
			//Atualizar conta:
			//accountService.getIdAccountUpdate(account, 73);
			
			//Deletar usuário:
			//accountService.getIdAccountDelete(account, 73);
			
			//Depósito:
			//accountService.verificationDeposit(account, 77);
			
			//Saque:
			//accountService.verificationWithdraw(account, 77, 10.0);
			
			//Transferência:
			//accountService.verificationBankTransfer(75, 76, 100.0);
			
			//Emprestimo:
			//accountService.verificationBankLoan(account, 75);
			
	}
}
