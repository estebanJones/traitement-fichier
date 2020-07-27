package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public final class ConnexionService {
	private static final String URL = "db.url";
	private static final String USER = "db.user";
	private static final String PASS = "db.pass";
	
	public static final Connection connectionDatabase() {
		ResourceBundle dbProperties = ResourceBundle.getBundle("database");
		try {
			Class.forName(dbProperties.getString("db.driver"));
			return DriverManager.getConnection(dbProperties.getString(ConnexionService.URL), 
											   dbProperties.getString(ConnexionService.USER), 
											   dbProperties.getString(ConnexionService.PASS));
		}catch(SQLException | ClassNotFoundException e) {
			throw new RuntimeException();
		}
	}
}
