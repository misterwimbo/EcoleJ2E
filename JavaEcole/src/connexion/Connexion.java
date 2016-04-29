package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Connexion {
	
	private static String user = "root";
	private static String mdp = "guitares";
	private static String url = "jdbc:mysql://localhost/ecole_projet";
	private static Connection connexion = null;
	private static Statement statement = null;
	private static ResultSet resultat = null;
	
	/*public Connexion() {
		
	}*/
	
	public static void connexion() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Drivers charge.");
			connexion = DriverManager.getConnection(url, user, mdp);
			System.out.println("Connexion etablie.");
		} catch (SQLException e) {
			throw new SQLException(e);
		} catch ( ClassNotFoundException e) {
			throw new ClassNotFoundException();
		}
	}
	
	public static void deconnexion() {
		if (resultat != null) {
			try {
				resultat.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		if (connexion != null) {
			try {
				connexion.close();
			} catch (SQLException e) {
				// On ignore l'erreur
			}
		}
	}
	
	public static ResultSet selectFrom(String requete) {
		statement = null;
		resultat = null;
		
		try {
			statement = connexion.createStatement();
			System.out.println("Statement cree.");
			resultat = statement.executeQuery(requete);
			System.out.println("Requete reussie.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return resultat;
	}
	
	public static int updateFrom(String requete) {
		statement = null;
		resultat = null;
		
		try {
			statement = connexion.createStatement();
			System.out.println("Statement cree.");
			statement.executeUpdate(requete);
			System.out.println("Requete reussie.");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return 0;
	}
	
	
	
	
	
	
	
	
	
}//fin classe
