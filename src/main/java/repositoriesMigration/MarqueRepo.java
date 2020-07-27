package repositoriesMigration;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import database.ConnexionService;
import entities.Marque;
import entities.Magasin;
import interfaces.IMarqueMigration;

public class MarqueRepo implements IMarqueMigration {
	@Override
	public List<Marque> extraire() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertCSVtoDB(List<Magasin> magasin) throws IOException {
		List<Marque> formatteMarque = this.formatteMarque(magasin);
		formatteMarque.forEach(e -> System.out.println(e.getId() + " " + e.getNom()));
		System.out.println("fin");
//		formatteMarque.forEach(marque -> {
//			System.out.println(marque.getNom());
//			System.out.println(marque.getId());
//				Connection connection = null;
//				ResultSet resultSet = null;
//				Statement statement = null;
//				try {
//					connection = ConnexionService.connectionDatabase();
//					statement = connection.createStatement();
//					resultSet = statement.executeQuery("INSERT INTO marque(id, nom) VALUES(" + marque.getId() + ",'" + marque.getNom() +  "')");
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}finally {
//					try {
//						connection.close();
//						statement.close();
//						resultSet.close();
//					} catch (SQLException e1) {
//						e1.printStackTrace();
//					}
//				}
//		});
	}
	
	private List<Marque> formatteMarque(List<Magasin> magasin) throws IOException {

		 List<Marque> formatteMarque= magasin.stream()
					 .filter(e -> e.getMarque().getNom().length() > 2 && e != null && !(e.getMarque().getNom().equalsIgnoreCase("marque"))  
					 				&& (!e.getMarque().getNom().isBlank())) 
					 .map(e -> new Marque(e.getMarque().getId(), StringUtils.substringBefore(e.getMarque().getNom(), ",")))
					 .distinct()
					 .collect(Collectors.toList());
		 System.out.println(formatteMarque.size());
		return formatteMarque;
	}
}
