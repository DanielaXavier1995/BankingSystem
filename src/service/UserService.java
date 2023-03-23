package service;

import java.util.List;
import java.util.Objects;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import dao.UserDao;
import jpautil.JPAUtil;
import models.User;

public class UserService {

	EntityManager em = JPAUtil.getEntityManager();
	UserDao userDao;

	public Boolean getCpfUser(User user) {

		List<User> users = userList();

		for (User u : users) {
			if (u.getCpf().equals(user.getCpf())) {
				System.out.println("The cpf alread exist!");
                return true;
			}
		}
		userDao.insertUser(user);
		System.out.println("Cpf don't find!");
		return false;
	}
	
	public void findAllUser() {
		List<User> users = userList();
		
		for (User u: users) {
			System.out.println(u);
		}
	}

	private List<User> userList() {
		Query query = em.createQuery("From User");
		return query.getResultList();
	}
	
	public User getIdUser(User user, int id) {
		
		user = userDao.findByIdUser(user, id) ;
		
		if (Objects.nonNull(user)) {
			System.out.println(user.toString());
		} else {
			System.out.println("Object doesn't exist!!");
		}
		
		return user;
	}
	
	 public User getIdUserUpdate(User user, int id) {
		
		if (Objects.nonNull(user)) {
			user = userDao.updateUser(user, id);
			System.out.println("Object changed with success!!");
		} else {
			System.out.println("Object doesn't exist!!");
		}
		return user;
	}
	 
	 public User getIdUserDelete(User user, int id) {
			
			if (Objects.nonNull(user)) {
				user = userDao.deleteUser(user, id);
				System.out.println("Object deleted with success!!");
			} else {
				System.out.println("Object doesn't exist!!");
			}
			return user;
		}
}
