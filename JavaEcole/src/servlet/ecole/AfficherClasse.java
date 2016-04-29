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
 * Servlet implementation class AfficherClasse
 */
@WebServlet("/AfficherClasse")
public class AfficherClasse extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfficherClasse() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().getRequestDispatcher("/WEB-INF/afficherClasse.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String classe = request.getParameter("classe");
		
		Vector<Personne> tab_classe = new Vector<Personne>();
		
		try {
			Connexion.connexion();
			ResultSet result = Connexion.selectFrom("SELECT idPersonne,Nom,Prenom,Date_Naissance FROM Personne "
					+ "INNER JOIN Pers_Classe ON 	Pers_Classe.Personne_idPersonne = Personne.idPersonne "
					+ "INNER JOIN Classe ON  Pers_Classe.Classe_idClasse = Classe.idClasse "
					+ "WHERE IdClasse = "+classe+" AND Statut = 'Eleve'");
			
		while (result.next()) {
			   Personne c = new Personne();
				c.setId(result.getInt("idPersonne"));
				System.out.println(c.getId()); // pour test
			    c.setNom(result.getString("Nom"));
				c.setPrenom(result.getString("Prenom"));
				c.setDateNaissance(result.getString("Date_Naissance"));
				tab_classe.add(c);
				System.out.println("taille:"+tab_classe.size());
				System.out.println("id:" +tab_classe.elementAt((tab_classe.size()-1)));
				
			}
			request.setAttribute("tab_classe", tab_classe);
			Connexion.deconnexion();
		} catch (ClassNotFoundException e) {
			// Erreur chargement driver
			e.printStackTrace();
		} catch (SQLException e) {
			request.setAttribute("tab_classe", tab_classe);
		}
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ResultClass.jsp").forward(request, response);
	}
	}


