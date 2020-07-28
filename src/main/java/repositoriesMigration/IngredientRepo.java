package repositoriesMigration;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import entities.Ingredient;
import entities.Magasin;
import entities.Marque;
import interfaces.IIngredientMigration;

public class IngredientRepo implements IIngredientMigration {
	
	@Override
	public void insertCSVtoDB(List<Magasin> magasin) throws IOException {
		List<Ingredient> ingre = this.formatteIngredient(magasin);
		
		for(int i=0; i < ingre.size(); i++) {
			System.out.println(ingre.get(i).getNom());
		}
	}
	
	public List<Ingredient> formatteIngredient(List<Magasin> magasin) throws IOException {
		List<Ingredient> ingre = this.getListIngredients(magasin);
		for(int i=0; i < ingre.size(); i++) {
			ingre.get(i).setNom(StringUtils.substringBefore(ingre.get(i).getNom().toUpperCase(), ","));
			ingre.get(i).setNom(ingre.get(i).getNom().trim());
			ingre.get(i).setNom(ingre.get(i).getNom().replace("_", ""));
			System.out.println(ingre.get(i).getNom());
		}
		return null;
		
	}
	
	private List<Ingredient> getListIngredients(List<Magasin> magasin) throws IOException {
		List<Ingredient> list = new ArrayList<>();
		List<String[]> ingre = this.collectIngredient(magasin);
		int id = 0;
		for(int i=0; i < ingre.size(); i++) {
			for(int j=0; j < ingre.get(i).length; j++) {
				list.add(new Ingredient(id, ingre.get(i)[j]));
				id++;
			}
		}
		return list;
	}
	
	private List<String[]> collectIngredient(List<Magasin> magasin) throws IOException {
		return magasin.stream()
				.map(e -> e.getIngredient().getNom().split(","))
				.collect(Collectors.toList());
	}

}
