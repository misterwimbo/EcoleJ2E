package servlet.ecole;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connexion.Connexion;
import bean.Personne;

/**
 * Servlet implementation class RechercheEleve
 */
@WebServlet("/RechercheEleve")
public class RechercheEleve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RechercheEleve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/rechercheEleve.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nom = null;
		nom = (String)request.getParameter("nom");
		request.setAttribute("name", nom);
		
		Vector<Personne> tab_personne = new Vector<Personne>();
		try {
			Connexion.connexion();
			ResultSet result = Connexion.selectFrom("SELECT * FROM personne WHERE nom LIKE '" + nom + "%' AND statut = 'Eleve'");
			while (result.next()) {
				Personne p = new Personne();
				p.setId(result.getInt("idPersonne"));
				p.setNom(result.getString("Nom"));
				p.setPrenom(result.getString("Prenom"));
				p.setDateNaissance(result.getString("Date_Naissance"));
				tab_personne.add(p);
			}
			request.setAttribute("tab_personne", tab_personne);
			Connexion.deconnexion();
		} catch (ClassNotFoundException e) {
			// Erreur chargement driver
			e.printStackTrace();
		} catch (SQLException e) {
			request.setAttribute("tab_personne", tab_personne);
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/resultRechercheEleve.jsp").forward(request, response);
	}

}
