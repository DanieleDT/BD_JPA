package entity;

import java.util.List;

import javax.persistence.*;

@Entity(name = "satellite")
public class Satellite {
	@Id
	private int id;
	@Column(name = "nome")
	private String nome;

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("sample");
		EntityManager em = emf.createEntityManager();

		// ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

		System.out.println("Test prendere tutti strumenti con satellite e mappe");
		TypedQuery<Satellite> queryShowAll = em.createQuery("SELECT s FROM strumento s", Satellite.class);
		List<Satellite> resultAll = queryShowAll.getResultList();

		for (Satellite s : resultAll) {
			System.out.println(s.getId());
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
