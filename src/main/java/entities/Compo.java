package entities;

public class Compo {
	private int id;
	private int idProduit;
	private int idIngredient;
	
	public Compo(int id, int idProduit, int idIngredient) {
		this.id = id;
		this.idProduit = idProduit;
		this.idIngredient = idIngredient;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	public int getIdIngredient() {
		return idIngredient;
	}

	public void setIdIngredient(int idIngredient) {
		this.idIngredient = idIngredient;
	}
}
