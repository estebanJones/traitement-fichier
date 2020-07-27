package entities;

public class Categorie {
	private int id;
	private String nom;
	private int idProduit;
	
	public Categorie(int id, String nom, int idMarque) {
		this.id = id;
		this.nom = nom;
		this.idProduit = idMarque;
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
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idMarque) {
		this.idProduit = idMarque;
	}
	
	
}
