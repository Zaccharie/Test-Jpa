package entit�;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="NOM", length=50 )
	private String nom;
	
	@Column(name="PRENOM", length=50 )
	private String prenom;
	
	@OneToMany(mappedBy="client")
	private Set<Emprunt> emprunt;
	
	//constructor
	public Client() {
		emprunt = new HashSet<Emprunt>();
	}
	
	//getters and setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
