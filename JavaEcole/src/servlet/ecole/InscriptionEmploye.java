package servlet.ecole;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connexion.Connexion;

@WebServlet("/InscriptionEmploye")
public class InscriptionEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InscriptionEmploye() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher("/WEB-INF/InscriptionEmploye.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idPersonne = null;
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String poste = request.getParameter("poste");
		
		String idAdresse = null;
		String adresse = request.getParameter("adr");
		String cp = request.getParameter("cp");
		String ville = request.getParameter("ville");
		
		
		try {
			Connexion.connexion();
			Connexion.updateFrom("INSERT INTO personne (Nom,Prenom,Statut) VALUES ('"+nom+"','"+prenom+"','"+poste+"')");
			Connexion.updateFrom("INSERT INTO coordonnees (Adresse_1,Code_Postal,Ville) VALUES ('"+adresse+"','"+cp+"','"+ville+"')");
			
			ResultSet result = Connexion.selectFrom("SELECT idPersonne FROM personne WHERE nom LIKE '"+nom+"' AND prenom LIKE '"+prenom+"'");
			while (result.next()) {
				idPersonne = result.getString("idPersonne");
			}
			result = Connexion.selectFrom("SELECT idAdresse FROM coordonnees WHERE Adresse_1='"+adresse+"' AND Code_Postal='"+cp+"' AND Ville='"+ville+"'");
			while (result.next()) {
				idAdresse = result.getString("idAdresse");
			}
			
			Connexion.updateFrom("INSERT INTO pers_coord (Personne_IdPersonne,Coordonnees_idAdresse) VALUES ('"+idPersonne+"','"+idAdresse+"')");
			
			Connexion.deconnexion();
		} catch (ClassNotFoundException e) {
			// Erreur driver
		} catch (SQLException e) {
			// Erreur sql
		}
		
		request.setAttribute("idEmploye", idPersonne);
		this.getServletContext().getRequestDispatcher("/WEB-INF/inscriptionOkEmploye.jsp").forward(request, response);
	}

}
