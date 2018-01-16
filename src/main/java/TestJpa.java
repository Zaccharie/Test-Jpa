import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import banque.Adresse;
import banque.AssuranceVie;
import banque.Banque;
import banque.Client;
import banque.LivretA;
import banque.Virement;

/**
 * @author ETY19
 *
 */
public class TestJpa {

	public static final Logger LOG = LoggerFactory.getLogger(TestJpa.class);
	
	public static void main(String[] args) {
		/*
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("pu_essai");
		EntityManager em = entityManagerFactory.createEntityManager();
		
		//test find 
		Livre l = em.find(Livre.class, 1);
		if (l != null) {
			LOG.info("**************************INFO************* "+ l.getAuteur() +", "+l.getTitre());
		}
		
		//test JPQL query
		Query query = em.createQuery("select l from Livre l where l.titre = 'Germinal' ");
		Livre livre = (Livre) query.getResultList().get(0);
		
		if(livre != null) {
			LOG.info("**************************INFO************* "+ livre.getTitre() + ", "+livre.getAuteur());
		}
		
		//query to get emprunt with all the associated livre
		Query queryEmprunt = em.createQuery("select emp from Emprunt emp where emp.id = '4'");
		Emprunt emprunt = (Emprunt) queryEmprunt.getResultList().get(0);
		Set<Livre> livres = emprunt.getLivres();
				
		if(emprunt != null) {
			LOG.info("**************************INFO************* "+ "ID de l'emprunt : "+ emprunt.getId());
			for(Livre li : livres){
				LOG.info("**************************INFO************* "+ li.getTitre() + ", " + li.getAuteur());
			}
		}
		
		em.close();
		entityManagerFactory.close();
		
		*/
		
		/************************************* TEST BANQUE *******************************/
		
		EntityManagerFactory entityManagerFactoryBan = Persistence.createEntityManagerFactory("banque");
		EntityManager emB = entityManagerFactoryBan.createEntityManager();
		EntityTransaction transaction = emB.getTransaction();
		transaction.begin();
		
		//Creation d'un client et de son premier compte, d'une banque ainsi que d'une operation
		try {
			
			//Objet Client
			Client cli1 = new Client();
			cli1.setNom("Meddah");
			cli1.setPrenom("Zaccharie");
			cli1.setDateNaissance(LocalDate.of(1991, 07, 21));
			
			//Objet Adresse
			Adresse adr1 = new Adresse();
			adr1.setNumero(8);
			adr1.setCodePostal(67000);
			adr1.setRue("rue de l'outre");
			adr1.setVille("Strasbourg");
			
			cli1.setAdresse(adr1);
			
			//Objet compte LivretA
			LivretA livA = new LivretA();
			livA.setNumero(1245365);
			livA.setSolde(2000.00);
			
			//Objet compte AssuranceVie
			AssuranceVie assurV = new AssuranceVie();
			assurV.setNumero(124999);
			assurV.setSolde(100.00);
			assurV.setDateFin(LocalDate.now());
			assurV.setTaux(1.5);
			
			cli1.getComptes().add(livA);
			cli1.getComptes().add(assurV);
			
			//Objet Banque 
			Banque ban1 = new Banque();
			ban1.setNom("Credit Mutuel");
			cli1.setBanque(ban1);
			
			//Objet operation Virement
			Virement op1 = new Virement();
			op1.setCompte(livA);
			op1.setDate(LocalDate.now());
			op1.setMotif("Avance de frais");
			op1.setMontant(250.0);
			op1.setBeneficiaire("Le Pape");
			livA.getOperations().add(op1);
			
			
			emB.persist(op1);
			emB.persist(ban1);
			emB.persist(assurV);
			emB.persist(livA);
			emB.persist(cli1);
			
			transaction.commit();
			LOG.info("******** CREATION CLIENT + COMPTE OK ************ ");
			
		}
		catch(HibernateException e){
			LOG.info("******** ERROR ************ " + e.getMessage());
			transaction.rollback();
			emB.close();
			entityManagerFactoryBan.close();
		}

		emB.close();
		entityManagerFactoryBan.close();
	}	

}
