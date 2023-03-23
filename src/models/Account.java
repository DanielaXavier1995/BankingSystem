package models;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Calendar;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "account")
@DynamicUpdate
@DynamicInsert
public class Account {

	//ATRIBUTOS
	@Id
	@GeneratedValue(generator = "sequence_account", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "sequence_account", sequenceName = "sequence_account", initialValue = 1, allocationSize = 1)
	@Column (name = "idAccount", nullable = false)
	private int idAccount;
	@Column (name = "status_account", nullable = false) //0 - inativo/ 1- ativo
	private String statusAccount;
	@Column (name = "type_account", nullable = false) 
	private String typeAccount;
	@Column (name = "number_account", nullable = false)
	private String numberAccount;
	@Column (name = "creation_Calendar_account", nullable = true)
	@Temporal(TemporalType.DATE)
	private Calendar creationDateAccount;
	@Column (name = "first_deposit_account", nullable = false)
	private double firstDepositAccount;
	@Column (name = "balance_account", nullable = false)
	private double balance;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name = "idUser")
	private User user;
	
	
	//CONSTRUTORES
	
	public Account() {
	
	}
	
    public Account(int idAccount, String statusAccount, String typeAccount, String numberAccount,
			Calendar creationCalendarAccount, double firstDepositAccount, double balance, User userAccount) {
		super();
		this.idAccount = idAccount;
		this.statusAccount = statusAccount;
		this.typeAccount = typeAccount;
		this.numberAccount = numberAccount;
		this.creationDateAccount = creationCalendarAccount;
		this.firstDepositAccount = firstDepositAccount;
		this.balance = balance;
		this.user = user;
	}

	//MÉTODOS ACESSORES
	
    public int getIdAccount() {
		return idAccount;
	}

	public void setIdAccount(int idAccount) {
		this.idAccount = idAccount;
	}

	public String getStatusAccount() {
		return statusAccount;
	}

	public void setStatusAccount(String statusAccount) {
		this.statusAccount = statusAccount;
	}

	public String getTypeAccount() {
		return typeAccount;
	}

	public void setTypeAccount(String typeAccount) {
		this.typeAccount = typeAccount;
	}

	public String getNumberAccount() {
		return numberAccount;
	}

	public void setNumberAccount(String numberAccount) {
		this.numberAccount = numberAccount;
	}

	public Calendar getCreationDateAccount() {
		return creationDateAccount;
	}

	public void setCreationDateAccount(Calendar creationDateAccount) {
		this.creationDateAccount = creationDateAccount;
	}

	public double getFirstDepositAccount() {
		return firstDepositAccount;
	}

	public void setFirstDepositAccount(double firstDepositAccount) {
		this.firstDepositAccount = firstDepositAccount;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

	//EQUALS E HASCODE
	
	@Override
	public int hashCode() {
		return Objects.hash(balance, creationDateAccount, firstDepositAccount, idAccount, numberAccount, statusAccount,
				typeAccount, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return idAccount == other.idAccount;
	}

	//TOSTRING
	
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat();
		return "Account [idAccount=" + idAccount + ", statusAccount=" + statusAccount + ", typeAccount=" + typeAccount
				+ ", numberAccount=" + numberAccount + ", creationDateAccount=" + sdf.format(creationDateAccount.getTime())
				+ ", firstDepositAccount=" + firstDepositAccount + ", balance=" + balance + ", userAccount="
				+ user + "]";
	}
}

