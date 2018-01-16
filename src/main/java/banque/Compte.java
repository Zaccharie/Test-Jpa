package banque;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="compte")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Compte {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="NUMERO", unique=true)
	private Integer numero;
	
	@Column(name="SOLDE")
	private Double solde;
	
	//TODO Faire le JoinTable de maniere inverse ici
	@ManyToMany(mappedBy="comptes")
	private Set<Client> clients;
	
	@OneToMany(mappedBy="compte")
	private Set<Operation> operations;
	
	/**
	 * default constructor
	 */
	public Compte() {
		operations = new HashSet<Operation>();
	}
	
	//getters and setters

	/**
	 * @return id, type Integer
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return numero, type Integer
	 */
	public Integer getNumero() {
		return numero;
	}

	/**
	 * @param numero
	 */
	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	/**
	 * @return solde, type Double
	 */
	public Double getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 */
	public void setSolde(Double solde) {
		this.solde = solde;
	}

	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}

	public Set<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Set<Operation> operations) {
		this.operations = operations;
	}
	
	

}
