package controller;
import java.io.IOException;
import java.util.List;

import entities.Magasin;
import repositoriesMigration.ExctractFileRepo;
import repositoriesMigration.MarqueRepo;
import repositoriesMigration.ProduitRepo;

public class TestController {
	public static void main(String[] args) {
		// repo entity
		ProduitRepo produitRepo = new ProduitRepo();
		MarqueRepo marqueRepo = new MarqueRepo();
		// methode de lecture
		ExctractFileRepo file = new ExctractFileRepo();
		
		
		try {
			List<Magasin> result = file.lireOpenFoodFacts();
			marqueRepo.insertCSVtoDB(result);
			//produitRepo.insertCSVtoDB(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
