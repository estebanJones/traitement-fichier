package entities;

public class Magasin {
	private Produit produit;
	private Marque marque;
	private Ingredient ingredient;
	private Categorie categorie;
	
	public Magasin(Produit produit, Marque marque, Ingredient ingredient, Categorie categorie) {
		this.produit = produit;
		this.marque = marque;
		this.ingredient = ingredient;
		this.categorie = categorie;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	
	
}
