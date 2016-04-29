package servlet.ecole;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Personne;
import connexion.Connexion;

/**
 * Servlet implementation class Modifemploye
 */
@WebServlet("/ModifEmploye")
public class ModifEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifEmploye() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = null;
		id = (String)request.getParameter("id");
		
		Personne p = new Personne();
		try {
			Connexion.connexion();
			ResultSet result = Connexion.selectFrom("SELECT idPersonne, Nom, Prenom, Statut " +
													"FROM Personne " +
													"WHERE idPersonne = " +id);
			
			while (result.next()) {
				p.setId(result.getInt("idPersonne"));
				p.setNom(result.getString("Nom"));
				p.setPrenom(result.getString("Prenom"));
				p.setStatut(result.getString("Statut"));
			}
			
			result = Connexion.selectFrom("SELECT Adresse_1 " +
										  "FROM Personne " +
										  "INNER JOIN pers_coord ON idPersonne = Personne_idPersonne " +
										  "INNER JOIN coordonnees ON Coordonnees_idAdresse=idAdresse " +
										  "WHERE idPersonne = "+ id);
			
			while (result.next()) {
				p.setAdresse(result.getString("Adresse_1"));
			}
			
			request.setAttribute("employe",p);
			Connexion.deconnexion();
		} catch (ClassNotFoundException e) {
			// Erreur chargement driver
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("erreur");
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/modifEmploye.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String option = request.getParameter("valider");
		
		String id = request.getParameter("id");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String poste = request.getParameter("poste");
		//String adresse = request.getParameter("adresse");
		
		if (option.equals("Valider")) {
			try {
				Connexion.connexion();
				Connexion.updateFrom("UPDATE personne SET Nom='"+nom+"', Prenom='"+prenom+"', Statut='"+poste+"' WHERE idPersonne="+id);
				// Je ne peux pas mettre leur adresse a jour car ils en ont pas
				//Connexion.updateFrom("UPDATE coordonnee)
				Connexion.deconnexion();
			} catch (ClassNotFoundException e) {
				// Erreur drivers
			} catch (SQLException e) {
				// Erreur sql
			}
			
			request.setAttribute("id", id);
			this.getServletContext().getRequestDispatcher("/WEB-INF/miseAjourEmploye.jsp").forward(request, response);
			
		} else {
			try {
				Connexion.connexion();
				Connexion.updateFrom("DELETE FROM personne WHERE idPersonne="+id);
				Connexion.deconnexion();
			} catch (ClassNotFoundException e) {
				// Erreur drivers
			} catch (SQLException e) {
				// Erreur sql
			}
			
			this.getServletContext().getRequestDispatcher("/WEB-INF/deleteEmploye.jsp").forward(request, response);
		}
	}

}
