package banque;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * Entity Client
 *
 */
@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="NOM", length=50, nullable=false)
	private String nom;
	
	@Column(name="PRENOM", length=50, nullable=false)	
	private String prenom;
	
	@Column(name="DATE_NAISSANCE", nullable=false)
	private LocalDate dateNaissance;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToMany
	@JoinTable(name="client_compte",
			joinColumns=@JoinColumn(name="ID_CLI", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_COM", referencedColumnName="ID")
	)
	private Set<Compte> comptes;
	
	@ManyToOne
	@JoinColumn(name="BANQUE_ID")
	private Banque banque;
	
	/**
	 * default constructor
	 */
	public Client() {
		comptes = new HashSet<Compte>();
	}
	
	public Client(String nom, String prenom, LocalDate dateNaissance) {
		comptes = new HashSet<Compte>();
		this.prenom = prenom;
		this.nom = nom;
		this.dateNaissance = dateNaissance;
	}
	
	//getters and setters
	
	/**
	 * @return id
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
	 * @return nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return dateNaissance
	 */
	public LocalDate getDateNaissance() {
		return dateNaissance;
	}

	/**
	 * @param dateNaissance
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * @return adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	public Banque getBanque() {
		return banque;
	}

	public void setBanque(Banque banque) {
		this.banque = banque;
	}

	
	
}
