package banque;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class LivretA extends Compte {
	
	@Column(name="TAUX")
	private Double taux;
	
	public LivretA() {
		super();
	}
	
	public LivretA(Integer numero, Double solde, Double taux) {
		super(numero, solde);
		this.taux = taux;
	}

	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}

}
