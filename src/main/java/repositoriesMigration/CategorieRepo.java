package repositoriesMigration;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import entities.Categorie;
import entities.Magasin;

public class CategorieRepo {

	public void formatte(List<Magasin> magasin) throws IOException {
		Collection<Categorie> result = this.formatteCategorieName(magasin);
		result.forEach(e -> System.out.println(e.getId() + " " + e.getNom() + " " + e.getIdProduit()));
	}
	
	private Collection<Categorie> formatteCategorieName(List<Magasin> magasin) throws IOException {
		Collection<Categorie> cate = this.collectCategorie(magasin);
		cate.stream().forEach(e -> {
			e.setNom(e.getNom().replace("-", " "));
			
		});
		return cate;
	
	}
	
	private Collection<Categorie> collectCategorie(List<Magasin> magasin) throws IOException {
		return magasin.stream()
				.map(e -> new Categorie(e.getCategorie().getId(), e.getCategorie().getNom(), e.getCategorie().getIdProduit()))
				.collect(Collectors.toMap(Categorie::getNom, p -> p, (p, q) -> p)).values();
	}


}
