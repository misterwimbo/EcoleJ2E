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
 * Servlet implementation class ModifEleve
 */
@WebServlet("/modifEleve")
public class modifEleve extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public modifEleve() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String id = null;
				id = (String)request.getParameter("id");
				String req = "SELECT PERS.idPersonne  AS idPersonne,"
						+"PERS.Nom  AS Nom, PERS.Prenom AS Prenom,"
						+"PERS.Date_Naissance AS Date_Naissance,"
						+"PERS.Sexe As sexe,Adresse_1 AS Adresse," 
						+"PPER.Nom AS prevNom,PPER.prenom AS prevPrenom,Telephone_1 AS PrevTel,PPER.idPersonne AS previdPersonne "
						+"FROM Personne AS PERS "
						+"INNER JOIN Prevenir on PERS.idPersonne = Prevenir.Personne_idPersonne "
						+"INNER JOIN Personne AS PPER on Prevenir.Personne_idpersonne_2 = PPER.idPersonne " 
						+"INNER JOIN pers_coord ON PERS.idPersonne = pers_coord.Personne_idPersonne "
						+"INNER JOIN coordonnees ON pers_coord.coordonnees_idadresse = coordonnees.idadresse "
						+"WHERE PERS.Idpersonne ='"+id+"' ";
				
				
				String req1="SELECT Niveau,Nom_Classe FROM personne "
						+"INNER JOIN pers_classe on pers_classe.Personne_idPersonne = personne.idPersonne "
						+"INNER JOIN classe  on pers_classe.Classe_idClasse = classe.idClasse "
						+"WHERE idPersonne = '"+id+"'";





				
				Personne p = new Personne();
				try {
					Connexion.connexion();
					ResultSet result = Connexion.selectFrom(req);
					
					while (result.next()) {
						
						p.setId(result.getInt("idPersonne"));
						p.setPrevid(result.getInt("previdPersonne"));
						p.setNom(result.getString("Nom"));
						p.setAdresse(result.getString("Adresse"));
						p.setPrenom(result.getString("Prenom"));
						p.setPrevNom(result.getString("prevNom"));
						p.setPrevPrenom(result.getString("prevPrenom"));
						p.setPrevTel(result.getString("PrevTel"));
						
						p.setDateNaissance(result.getString("Date_Naissance"));
						/* rajouter le select count */
						
					}
					
                    result = Connexion.selectFrom(req1);
					
					while (result.next()) {
						
						p.setNiveau(result.getString("Niveau"));
						p.setClasse(result.getString("Nom_Classe"));
						
					}
					
					
					request.setAttribute("eleve",p);
					Connexion.deconnexion();
				}
				
				catch (ClassNotFoundException e) {
					// Erreur chargement driver
					e.printStackTrace();
				}
				


                  catch (SQLException e) {
					System.out.println("erreur");
					e.printStackTrace();
				}
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/modifEleve.jsp").forward(request, response);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String option = request.getParameter("valider");
		
		String id           =     request.getParameter("id");
		String previd       =     request.getParameter("previd");
		String nom          =     request.getParameter("nom");
		String prenom       =     request.getParameter("prenom");
		String age          =     request.getParameter("age");
		String adresse      =     request.getParameter("adresse");
		String prevnom      =     request.getParameter("prevnom");
		String prevprenom   =     request.getParameter("prevprenom");
		String prevtel      =     request.getParameter("prevtel");
		
		/*suivi console */
		/*System.out.println(id);
		System.out.println(previd);
		System.out.println(prevtel);
		System.out.println(nom);
		System.out.println(prenom);
		System.out.println(age);
		System.out.println(adresse);
		System.out.println(prevnom);
		System.out.println(prevprenom);
		System.out.println(prevtel);*/
		
		
		
		
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
		/* si la requete est pour modifier un eleve */
		if(option.equals("Valider")){
			System.out.println("Valider");
			String req = "UPDATE personne SET Nom='"+nom+"',Prenom='"+prenom+"',Date_Naissance='"+age+"' WHERE idPersonne = '"+id+"' ;";
			String req1= "UPDATE coordonnees SET Adresse_1='"+adresse+"' WHERE  idAdresse = '"+id+"' ;";
			String req2= "UPDATE personne SET Nom='"+prevnom+"',Prenom='"+prevprenom+"' WHERE idPersonne = '"+previd +"' ;";
			String req3= "UPDATE coordonnees SET Telephone_1 ='"+prevtel+"' WHERE  idAdresse = '"+id +"' ;";
			
			try {
				Connexion.connexion();
				Connexion.updateFrom(req);
				Connexion.updateFrom(req1);
				Connexion.updateFrom(req2);
				Connexion.updateFrom(req3);
				Connexion.deconnexion();
			}
			
			catch (ClassNotFoundException e) {
				// Erreur chargement driver
				e.printStackTrace();
			}
			
			catch (SQLException e) {
				System.out.println("erreur");
				e.printStackTrace();
			}
			
			request.setAttribute("id", id);
			this.getServletContext().getRequestDispatcher("/WEB-INF/miseAjourEleve.jsp").forward(request, response);
			
				
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           /* si la requete est pour efacer un eleve */
		else if (option.equals("Effacer")){
			System.out.println("Effacer");
			String req = "DELETE  FROM `personne` WHERE idPersonne = '"+id+"' ;";
				try {
					Connexion.connexion();
					Connexion.updateFrom(req);
			
					Connexion.deconnexion();
				}
			
				catch (ClassNotFoundException e) {
					// Erreur chargement driver
					e.printStackTrace();
				}
			
				catch (SQLException e) {
					System.out.println("erreur");
					e.printStackTrace();
				}
	
				this.getServletContext().getRequestDispatcher("/WEB-INF/deleteEleve.jsp").forward(request, response);
		
			}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			/* si la requete est pour inscrire un eleve */		
		else if (option.equals("Inscrire")){
			
			
			String maxIdPersonne = null;
			int intMaxIdPersonne = 0 ;
		
		/*on regarde la date pour savoir dans quelle classe mettre l'élève */
			
			
			int niveauClasse= 0;
			try{
			String year = age.substring(0,4);
			System.out.println(year);
			     if(year.equals("2006")){niveauClasse = 8;}
			else if(year.equals("2007")){niveauClasse = 7;}
			else if(year.equals("2008")){niveauClasse = 6;}
			else if(year.equals("2009")){niveauClasse = 5;}
			else if(year.equals("2010")){niveauClasse = 4;}
			else if(year.equals("2011")){niveauClasse = 3;}
			else if(year.equals("2012")){niveauClasse = 2;}
			else if(year.equals("2013")){niveauClasse = 1;}
			else{
				
				
				this.getServletContext().getRequestDispatcher("/WEB-INF/erreurFormulaire.jsp").forward(request, response);
			}
			}
			catch(StringIndexOutOfBoundsException e){
				this.getServletContext().getRequestDispatcher("/WEB-INF/erreurFormulaire.jsp").forward(request, response);
			}
			
		    ////////////////////////////////////////////////////////////////////////////	
			
			
			String req = "SET FOREIGN_KEY_CHECKS=0;";
			
			String req1 = "INSERT INTO `personne` (`idPersonne`, `Nom`, `Prenom`, `Sexe`, `Date_Naissance`, `Statut`) VALUES"
			        +"(null, '"+nom+"', '"+prenom+"', 'M', '"+age+"', 'Eleve');";
			
			String req3="SELECT idPersonne FROM personne WHERE Nom = '"+nom+"' AND Prenom = '"+prenom+"';"; // je recupere le dernier Id
			
			try {
				Connexion.connexion();
				Connexion.updateFrom(req);
				Connexion.updateFrom(req1);
			    ResultSet result = Connexion.selectFrom(req3);
				
				while (result.next()) {
					maxIdPersonne = result.getString("idPersonne");
					System.out.println(maxIdPersonne);
					}
				
                }
		
			catch (ClassNotFoundException e) {
				// Erreur chargement driver
				e.printStackTrace();
			}
		
			catch (SQLException e) {
				System.out.println("erreur");
				e.printStackTrace();
			}

			intMaxIdPersonne = Integer.parseInt(maxIdPersonne);
			intMaxIdPersonne = intMaxIdPersonne +1;
			
			String req4 = "INSERT INTO `coordonnees` (`idAdresse`, `Adresse_1`, `Adresse_2`, `Code_Postal`, `Ville`, `Telephone_1`, `Telephone_2`) VALUES "
					+"('"+(intMaxIdPersonne-1)+"', '"+adresse+"', ' ', 31000, 'TOULOUSE', '"+prevtel+"', null);";
			
			String req5 = "INSERT INTO `pers_coord` (`Personne_idPersonne`, `Coordonnees_idAdresse`) VALUES ("+(intMaxIdPersonne-1)+","+(intMaxIdPersonne-1)+")";
			String req6 = "INSERT INTO personne (idPersonne, Nom, Prenom, Sexe, Date_Naissance, Statut) VALUES"
					+ "(null, '"+prevnom+"', '"+prevprenom+"', 'M', '1978-09-08', 'Parent');";
			String req7 ="INSERT INTO Prevenir (Personne_idPersonne, Personne_idPersonne_2) VALUES"
					   +"("+(intMaxIdPersonne - 1)+","+intMaxIdPersonne+")";
			
			String req8="INSERT INTO Pers_Classe (Classe_idClasse, Personne_idPersonne) VALUES("+niveauClasse+","+(intMaxIdPersonne - 1)+");";
			try {
				Connexion.connexion();
				Connexion.selectFrom(req);
				Connexion.updateFrom(req4);
				Connexion.updateFrom(req5);
				Connexion.updateFrom(req6);
				Connexion.updateFrom(req7);
				Connexion.updateFrom(req8);
				
				Connexion.deconnexion();
                }
		
			catch (ClassNotFoundException e) {
				// Erreur chargement driver
				e.printStackTrace();
			}
		
			catch (SQLException e) {
				System.out.println("erreur");
				e.printStackTrace();
			}

			request.setAttribute("idEleve",(intMaxIdPersonne-1));
			this.getServletContext().getRequestDispatcher("/WEB-INF/inscriptionOkEleve.jsp").forward(request, response);
			
		}
		
		
    }//fin methode goPost
	
}//fn class
