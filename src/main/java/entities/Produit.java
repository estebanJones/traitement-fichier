package entities;

public class Produit {
	private int id;
	private String nom;
	private int idMarque;
	
	public Produit(int id, String nom, int idMarque) {
		this.id = id;
		this.nom = nom;
		this.idMarque = idMarque;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdMarque() {
		return idMarque;
	}

	public void setIdMarque(int idMarque) {
		this.idMarque = idMarque;
	}
	
	
}
