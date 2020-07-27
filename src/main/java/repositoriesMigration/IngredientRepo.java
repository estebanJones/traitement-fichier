package repositoriesMigration;

import java.io.IOException;
import java.util.List;

import entities.Magasin;

public class IngredientRepo {

	public static void main(String[] args) throws IOException {
		ExctractFileRepo file = new ExctractFileRepo();
		List<Magasin> result = file.lireOpenFoodFacts();

		result.forEach(e -> System.out.println(e.getIngredient()));

	}

}
