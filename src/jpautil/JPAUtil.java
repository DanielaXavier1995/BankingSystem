package jpautil;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory factory;

	static {
		factory = Persistence.createEntityManagerFactory("BANKSYSTEM"); // LIGAÇÃO COM O BANCO
	}

	public static EntityManager getEntityManager() {
		return factory.createEntityManager(); //TRANSAÇÃO COM BANCO
	}

	public static void close() {
		factory.close();
	}

}
