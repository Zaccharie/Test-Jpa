package banque;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="operation")
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Operation {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name="MOTIF", length=255)
	private String motif;
	
	@Column(name="MONTANT")
	private Double montant;
	
	@Column(name="DATE")
	private LocalDate date;
	
	@ManyToOne
	@JoinColumn(name="COMPTE_ID")
	private Compte compte;
	
	/**
	 * default constructor
	 */
	public Operation() {
		
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
	 * @return motif, type String
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * @return montant, type Double
	 */
	public Double getMontant() {
		return montant;
	}

	/**
	 * @param montant
	 */
	public void setMontant(Double montant) {
		this.montant = montant;
	}

	/**
	 * @return date, type LocalDate
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return compte, type Compte
	 */
	public Compte getCompte() {
		return compte;
	}

	/**
	 * @param compte
	 */
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	
	
}
