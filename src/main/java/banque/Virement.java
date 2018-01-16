package banque;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Virement extends Operation{

	@Column(name="BENEFICIAIRE")
	private String beneficiaire;
	
	public Virement() {
		super();
	}

	public String getBeneficiaire() {
		return beneficiaire;
	}

	public void setBeneficiaire(String beneficiaire) {
		this.beneficiaire = beneficiaire;
	}
	
	
}
