package models;

	import java.util.List;
	import java.util.Objects;

	import javax.persistence.CascadeType;
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.FetchType;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.OneToMany;
	import javax.persistence.SequenceGenerator;
	import javax.persistence.Table;

	import org.hibernate.annotations.DynamicInsert;
	import org.hibernate.annotations.DynamicUpdate;

	@Entity
	@Table(name = "userBank")
	@DynamicUpdate
	@DynamicInsert
	public class User {
		
		//ATRIBUTOS
		@Id
		@GeneratedValue(generator = "sequence_user", strategy = GenerationType.AUTO)
		@SequenceGenerator(name = "sequence_user", sequenceName = "sequence_user", initialValue = 1, allocationSize = 1)
		@Column (name = "idUser", nullable = false)
		private int idUser;
		@Column (name = "name_user", nullable = false)
		private String name;
		@Column (name = "cpf_user", nullable = false)
		private String cpf;
		@Column (name = "address_user", nullable = false)
		private String address;
		@Column (name = "telephone_user", nullable = false)
		private String telephone;
		@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "user")
		private List <Account> account;
		
		//CONSTRUTORES
		
		public User() {

		}
		
		public User(int idUser, String name, String cpf, String address, String telephone, List<Account> account) {
			this.idUser = idUser;
			this.name = name;
			this.cpf = cpf;
			this.address = address;
			this.telephone = telephone;
			this.account = account;
		}
		
		//MÉTODOS ACESSORES
		
		public Integer getId() {
			return idUser;
		}

		public void setId(int idUser) {
			this.idUser = idUser;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCpf() {
			return cpf;
		}

		public void setCpf(String cpf) {
			this.cpf = cpf;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getTelephone() {
			return telephone;
		}

		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}

	    public List<Account> getAccount() {
			return account;
		}

		public void setAccount(List<Account> account) {
			this.account = account;
		}
		
		//EQUALS E HASCODE
		
		@Override
		public int hashCode() {
			return Objects.hash(account, address, cpf, idUser, name, telephone);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			User other = (User) obj;
			return Objects.equals(idUser, other.idUser);
		}
		
		//TO STRING
		
		@Override
		public String toString() {
			return "User [idUser=" + idUser + ", name=" + name + ", cpf=" + cpf + ", address=" + address
					+ ", telephone=" + telephone + ", account=" + account + "]";
		}
	}



