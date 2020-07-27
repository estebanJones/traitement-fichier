package repositoriesMigration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Categorie;
import entities.Ingredient;
import entities.Marque;
import entities.Produit;
import entities.Magasin;

public class ExctractFileRepo {
	private static final String PATH = "./file/openFoodFacts.csv";
	
	
	
	public List<Magasin> lireOpenFoodFacts() throws IOException {
		return this.createResultatFileAggregate(this.getFile());
	}
	

	private BufferedReader getFile() throws IOException {
		return new BufferedReader(new FileReader(ExctractFileRepo.PATH));
	}
	
	private List<Magasin> createResultatFileAggregate(BufferedReader reader) throws IOException {
		List<String> test = new ArrayList<>();
		List<Magasin> listFichier = new ArrayList<>();
		
		int id = 0;
		String line;
		
		while((line = reader.readLine()) != null) {
			Categorie categorie = new Categorie(id, line.split("\\|", -1)[0], id);
			Marque marque = new Marque(id, line.split("\\|", -1)[1]);
			Produit produit = new Produit(id, line.split("\\|", -1)[2], id);
			Ingredient ingredient = new Ingredient(id, line.split("\\|", -1)[4]);
			id++;
			listFichier.add(new Magasin(produit, marque, ingredient, categorie));
			
		}
		return listFichier;
	}
}
