<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector, bean.Personne" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Rechercher un &eacute;l&egrave;ve</title>
	<link rel="stylesheet" href="CSS/principal.css"  > 
	<link rel="stylesheet" href="CSS/menu.css">
	<link rel="stylesheet" href="CSS/rechercheEleveCadre.css"> 
</head>
<body>
	<%@ include file = "header.jsp"%>
	<nav>
		<%@ include file = "menu.jsp"%>
	</nav>
	<section>
		<article>
			<h2>RECHERCHER UN ELEVE</h2>
			<hr />
			<p>
				Tapez le nom compet ou les premieres lettres du nom de l'&eacute;l&egrave;ve &agrave; rechercher.<br>
				Affinez votre recherche gr&acirc;ce aux resultats propos&eacute;s.
			</p>
			<form method="post" action="RechercheEleve">
				<p>
					<label for="nom">Nom</label><input type="text" id="nom" name="nom" autocomplete="off" placeholder="nom de l'élève" /> 
					&nbsp;<input type="submit" value="Rechercher" />
				</p>
			</form>
			<div class="resultat">  
				<%
				String eleve_a_trouver = (String)request.getAttribute("name");
				if (eleve_a_trouver.length()!=0) {
					Vector<Personne> tab_personne = (Vector<Personne>) request.getAttribute("tab_personne");
					out.println("<table>");
					
					out.println("<tr><th>&nbsp;Nom&nbsp;</th>");
					out.println("<th>&nbsp;prénom&nbsp;</th>");
					out.println("<th>&nbsp;Date de naissance&nbsp;</th></tr>");
					
					for (Personne i : tab_personne) {
						out.println("<tr><td><a href = \"modifEleve?id="+i.getId()+"\">"+ i.getNom() + "</a></td><td>" + i.getPrenom() + "</td><td>"
						+i.getDateNaissance()+"</td></tr>");
					}
					out.println("</table>");
				}
				else {
					out.println("<span class = \"vide\">VEUILLEZ SAISIR AU MOINS UNE LETTRE ! </span>");
				}
			 	%>    	
			</div>
		</article>
	</section>
</body>
</html>