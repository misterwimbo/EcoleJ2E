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

import bean.Personne;
import connexion.Connexion;

/**
 * Servlet implementation class InfosEmploye
 */
@WebServlet("/InfosEmploye")
public class InfosEmploye extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InfosEmploye() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Vector<Personne> tab_personne = new Vector<Personne>();
		request.setAttribute("tab_personne", tab_personne);
		request.setAttribute("visible", false);
		request.setAttribute("name", "aucun");
		this.getServletContext().getRequestDispatcher("/WEB-INF/infosEmploye.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nom = null;
		String poste = null;
		
		nom = (String)request.getParameter("nom");
		poste = (String)request.getParameter("poste");
		request.setAttribute("name", nom);
		request.setAttribute("poste",poste);
		request.setAttribute("visible", true);
		
		Vector<Personne> tab_personne = new Vector<Personne>();
		try {
			Connexion.connexion();
			ResultSet result = null;
			if (poste.equals("Tout Poste")) {

				result = Connexion.selectFrom("SELECT * FROM personne WHERE nom LIKE '" + nom + "%' AND statut NOT IN ('Tuteur','Institution','Collateral','Eleve','Parent','Grand Parent','Nourice','Epoux','Epoux(se)')");

			} else {
				result = Connexion.selectFrom("SELECT * FROM personne WHERE nom LIKE '" + nom + "%' AND statut = '" + poste + "'");
			}
			while (result.next()) {
				Personne p = new Personne();
				p.setId(result.getInt("idPersonne"));
				p.setNom(result.getString("Nom"));
				p.setPrenom(result.getString("Prenom"));
				p.setStatut(result.getString("Statut"));
				tab_personne.add(p);
			}
			request.setAttribute("tab_personne", tab_personne);
			Connexion.deconnexion();
		} catch (ClassNotFoundException e) {
			// Erreur chargement driver
		} catch (SQLException e) {
			request.setAttribute("tab_personne", tab_personne);
		}
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/resultInfosEmploye.jsp").forward(request, response);
		this.getServletContext().getRequestDispatcher("/WEB-INF/infosEmploye.jsp").forward(request, response);
	}

}
