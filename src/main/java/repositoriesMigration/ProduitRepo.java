package repositoriesMigration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import database.ConnexionService;
import entities.Produit;
import entities.Magasin;
import entities.Marque;
import interfaces.IProduitMigration;

public class ProduitRepo implements IProduitMigration {


	@Override
	public void insertCSVtoDB(List<Magasin> magasin) throws IOException {
		List<Produit> formatteProduit = this.formatteProduit(magasin);
//		Path fichier = Paths.get("./file/log.txt");
//		Files.write(fichier, produit.getNom().getBytes(), StandardOpenOption.APPEND);
	
		formatteProduit.forEach(produit -> {
			System.out.println(produit.getId() + " " + produit.getNom());
				Connection connection = null;
				ResultSet resultSet = null;
				Statement statement = null;
				try {
					connection = ConnexionService.connectionDatabase();
					statement = connection.createStatement();
					resultSet = statement.
							executeQuery("INSERT INTO produit(id, nom, id_marque) VALUES(" + produit.getId()+ ",'" + produit.getNom() + "'," + produit.getIdMarque() +")");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}finally {
					try {
						connection.close();
						statement.close();
						resultSet.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
		});
		
	}
	
	private List<Produit> formatteProduit(List<Magasin> magasin) throws IOException {
		return magasin.stream()
				 .map(e -> new Produit(e.getProduit().getId(), e.getProduit().getNom(), e.getProduit().getIdMarque()))
				 .filter(e -> e.getNom().length() > 2 
						 && e != null 
						 && !(e.getNom().equalsIgnoreCase("nom")))
				 .distinct()
				 .collect(Collectors.toList());
	}
	
}
