package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity(name = "satellite")
public class Satellite {
	@Id
	private String nome;
	@Column(name = "agenzia")
	private String agenzia;
	@Column(name = "primaosservazione")
	private Date primaOsservazione;
	@Column(name = "termineattivita")
	private Date termineAttivita;
	

	public String getAgenzia() {
		return agenzia;
	}


	public void setAgenzia(String agenzia) {
		this.agenzia = agenzia;
	}


	public Date getPrimaOsservazione() {
		return primaOsservazione;
	}


	public void setPrimaOsservazione(Date primaOsservazione) {
		this.primaOsservazione = primaOsservazione;
	}


	public Date getTermineAttivita() {
		return termineAttivita;
	}


	public void setTermineAttivita(Date termineAttivita) {
		this.termineAttivita = termineAttivita;
	}


	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		EntityManager em = emf.createEntityManager();
		List<Satellite> sat = new ArrayList<Satellite>();

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		System.out.println("Test prendere tutti strumenti con satellite e mappe");
		TypedQuery<Satellite> queryShowAll = em.createQuery("SELECT s FROM satellite s", Satellite.class);
		List<Satellite> resultAll = queryShowAll.getResultList();

		for (Satellite c : resultAll) {
			 
            sat.add(c);

       }
		for (Satellite s : sat) {
			System.out.println(s.getNome() + " _ " + s.getAgenzia() + "  " + s.getPrimaOsservazione());
		}
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
