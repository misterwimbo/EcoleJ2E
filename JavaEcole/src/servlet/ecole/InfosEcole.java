package servlet.ecole;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Ecole;
import connexion.Connexion;

@WebServlet("/InfosEcole")
public class InfosEcole extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public InfosEcole() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Ecole ecole = new Ecole();
		
		//Affiche le nom d'élève dans l'ecole
		try 
		{
			Connexion.connexion();
			
			//Affiche le nombre de d'élève dans l'école
			ResultSet result0 = Connexion.selectFrom
					("SELECT COUNT(*) AS nbeleve FROM `personne` WHERE `Statut` = 'Eleve'");
			result0.next();
			ecole.setNbr_eleves(result0.getInt("nbeleve"));
			System.out.println(ecole.getNbr_eleves());
			request.setAttribute("nbeleve", ecole.getNbr_eleves());
			
			//Affiche le nombre de classes
			ResultSet result = Connexion.selectFrom
					("SELECT COUNT(*) AS nbligne FROM classe");
			result.next();
			ecole.setNbr_classe(result.getInt("nbligne"));
			System.out.println(ecole.getNbr_classe());
			request.setAttribute("nbligne", ecole.getNbr_classe());
			
			
			//Affiche le nom et le prenom du directeur de l'ecole
			ResultSet result1 = Connexion.selectFrom
					("SELECT nom, prenom FROM `personne` WHERE `Statut` = 'Directeur'");
			result1.next();	
			
			ecole.setNom(result1.getString("nom"));
			System.out.println(ecole.getNom());
			request.setAttribute("Statut", ecole.getNom());
			
			ecole.setPrenom(result1.getString("prenom"));
			System.out.println(ecole.getPrenom());
			request.setAttribute("Statut2", ecole.getPrenom());
			
			
			//Affiche le nombre de personnel dans l'ecole
			
			ResultSet result2 = Connexion.selectFrom
					("SELECT COUNT( * )  AS nombre "
					+ "FROM Personne "
					+ "WHERE Personne.Statut = 'Instit' OR Personne.Statut = 'Maintenance' "
					+ "OR Personne.Statut = 'Garderie' OR Personne.Statut = 'Administration' "
					+ "OR Personne.Statut = 'Cuisine' OR Personne.Statut = 'Directeur' ");
			
			result2.next();
			ecole.setNbr_employes(result2.getInt("nombre"));
			System.out.println(ecole.getNbr_employes());
			request.setAttribute("nombre", ecole.getNbr_employes());
			
			Connexion.deconnexion();
		} 
		
		catch (ClassNotFoundException e) 
		{
			// Erreur chargement driver
			e.printStackTrace();
		} 
		
		catch (SQLException e) 
		{
			request.setAttribute("nbligne", ecole.getNbr_classe());
		}
		
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/infosEcole.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nom    = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println("test");
		
	    
		
		
		

		try 
		{
			Connexion.connexion();
			Connexion.updateFrom("UPDATE personne SET nom ='" + nom + "', prenom ='" + prenom + "' WHERE Statut = 'Directeur'");
			
			
		
			
			Connexion.deconnexion();
		} 
		catch (ClassNotFoundException e) 
		{
			// Erreur chargement driver
			e.printStackTrace();
		} catch (SQLException e) 
		{
			
		}
		
		request.setAttribute("nom", nom);
		request.setAttribute("prenom", prenom);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/changDirecteurOk.jsp").forward(request, response);
	}

}
