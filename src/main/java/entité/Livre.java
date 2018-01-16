package entité;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="livre")
public class Livre {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="TITRE", length=255)
	private String titre;
	
	@Column(name="AUTEUR", length=50)
	private String auteur;
	
	@ManyToMany
	@JoinTable(name="compo",
			joinColumns=@JoinColumn(name="ID_LIV", referencedColumnName="ID"),
			inverseJoinColumns=@JoinColumn(name="ID_EMP", referencedColumnName="ID")
	)
	private Set<Emprunt> emprunts;
	
	//constructor
	public Livre() {
		
	}

	//getters 
	public Integer getId() {
		return id;
	}
	
	public String getTitre() {
		return titre;
	}

	public String getAuteur() {
		return auteur;
	}

	//setters
	public void setId(Integer id) {
		this.id = id;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}	

}
