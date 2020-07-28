package controller;
import java.io.IOException;
import java.util.List;

import entities.AvecConstructeur;
import entities.Magasin;
import entities.SansConstructeur;
import repositoriesMigration.CategorieRepo;
import repositoriesMigration.ExctractFileRepo;
import repositoriesMigration.IngredientRepo;
import repositoriesMigration.MarqueRepo;
import repositoriesMigration.ProduitRepo;

public class TestController {
	public static void main(String[] args) {
		// repo entity
		ProduitRepo produitRepo = new ProduitRepo();
		MarqueRepo marqueRepo = new MarqueRepo();
		IngredientRepo ingreRepo = new IngredientRepo();
		CategorieRepo categorieRepo = new CategorieRepo();
		// methode de lecture
		ExctractFileRepo file = new ExctractFileRepo();
		
		
		try {
			List<Magasin> result = file.lireOpenFoodFacts();
			marqueRepo.insertCSVtoDB(result);
			//produitRepo.insertCSVtoDB(result);
			//categorieRepo.formatte(result);
			//ingreRepo.insertCSVtoDB(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
