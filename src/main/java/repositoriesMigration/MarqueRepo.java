package repositoriesMigration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Normalizer;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import database.ConnexionService;
import entities.Magasin;
import entities.Marque;
import interfaces.IMarqueMigration;

public class MarqueRepo implements IMarqueMigration {
	@Override
	public List<Marque> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCSVtoDB(List<Magasin> magasin) throws IOException {
		Collection<Marque> formatteMarque = this.formatteMarque(magasin);
		formatteMarque.forEach(marque -> {
				marque.setNom(marque.getNom().replace("'", ""));
				marque.setNom(marque.getNom().replace("-", " "));
				Connection connection = null;
				ResultSet resultSet = null;
				Statement statement = null;
				try {
					connection = ConnexionService.connectionDatabase();
					statement = connection.createStatement();
					resultSet = statement.executeQuery("INSERT INTO marque(id, nom) VALUES(" + marque.getId() + ",'" + marque.getNom() +  "')");
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
	
	private Collection<Marque> formatteMarque(List<Magasin> magasin) throws IOException {
		return magasin.stream()
				      .filter(e -> e.getMarque().getNom().length() > 2 
						 && e != null 
						 && !(e.getMarque().getNom().equalsIgnoreCase("marque"))  
				 		 && (!e.getMarque().getNom().isBlank())) 
				      .map(e -> new Marque(e.getMarque().getId(), 
				    		  MarqueRepo.sansAccent(StringUtils.substringBefore(e.getMarque().getNom().toUpperCase(), ","))))
				      .collect(Collectors.toMap(Marque::getNom, p -> p, (p, q) -> p)).values();
	}
	
	private static String sansAccent(String s) {
	        String strTemp = Normalizer.normalize(s, Normalizer.Form.NFD);
	        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	        return pattern.matcher(strTemp).replaceAll("");
	}
}
