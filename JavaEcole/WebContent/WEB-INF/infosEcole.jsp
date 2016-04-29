<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="CSS/principal.css"  > 
	<link rel="stylesheet" href="CSS/menu.css">
	<link rel="stylesheet" href="CSS/inscriptionelevecadre.css">
	<title>Informations</title>
</head>
<body>
	<%@ include file = "header.jsp"%>
	<nav>
		<%@ include file = "menu.jsp"%>
	</nav>
	<section>
		<article>
			<p>
				Nombre d'&eacute;l&egrave;ves dans l'&eacute;tablissement : 
				<%
					int NombreEleve = (int) request.getAttribute("nbeleve");
					out.print(NombreEleve);
				%>
			</p>
			<p>
				Nombre de classes dans l'&eacute;tablissement : 
				<%
					int Niveau = (int) request.getAttribute("nbligne");
					out.print(Niveau);
				%>
			</p>
			<p>
				Le directeur de l'&eacute;tablissement : 
				<%
					String Nom_Instit = (String) request.getAttribute("Statut");
					String Prenom_Instit = (String) request.getAttribute("Statut2");
					out.print(Nom_Instit + " ");
					out.print(Prenom_Instit);
				%>
			</p> 			
			<p>
				Nombre de personnels dans l'&eacute;tablissement : 
				<%
					int Personnel = (int) request.getAttribute("nombre");
					out.print(Personnel);
				%>
			</p>
			<form method="post" action="InfosEcole">
				<p>
					Changer l'identit&eacute; du directeur:<br /><br />
					<label for="nom"> nom </label><input type="text" id="nom" name="nom" placeholder="Entrez le nom" required="required" autocomplete="off"  /><br />
					<label for="prenom">pr&eacute;nom  </label><input type="text" id="prenom" name="prenom" placeholder="Entrez le prenom" required="required"  autocomplete="off" />
					<input type="submit" value="Valider" name="envoyer" />
				</p>	
			</form>
		</article>
	</section>
</body>
</html>