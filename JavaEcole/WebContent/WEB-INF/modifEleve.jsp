<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="CSS/principal.css"  > 
	<link rel="stylesheet" href="CSS/menu.css">
	<link rel="stylesheet" href="CSS/inscriptionelevecadre.css"> 
	<title>Modification El&egrave;ve</title>
</head>
<body>
	<%@ include file = "header.jsp"%>
	<nav>
		<%@ include file = "menu.jsp"%>
	</nav>
	<section>
		<article>  
			<h2>
				MODIFIER UN ELEVE  
				<span class ="NiveauClasse">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					${eleve.getNom()} 
					${eleve.getPrenom()} Classe:
					${eleve.getNiveau()}
					(${eleve.getClasse()})
				</span>
			</h2>
			<hr />
			<form method="post" action="modifEleve"> <!--  ne pas oublié à changer en post -->
				<!--Formulaire infos eleves-->
				<div class = "eleve">
					<h2>Informations sur l'&eacute;l&egrave;ve:</h2>
					<p><label for="nom">Nom</label><input type="text" id="nom" name="nom" size="32"  autocomplete="off" value="${eleve.getNom()}" /></p>
					<p><label for="prenom">Prenom</label><input type="text" id="prenom" name="prenom" size="32" autocomplete="off" value="${eleve.getPrenom()}" /></p>
					<p><label for="jour">Age</label><input type="text" id="jour" name="age" size="32"  autocomplete="off" value="${eleve.getDateNaissance()}" /></p>
					<p><label for="adr">Adresse</label></p><br>
					<p><textarea id="adr" name="adresse" rows="5" cols="50" >${eleve.getAdresse()}</textarea></p>
				</div>  
				<!--formulaire personne à prevenir-->
				<div class = "prevenir">
					<h2>Personne à pr&eacute;venir:</h2>
					<p><label for="prevnom">Nom</label><input type="text" id="prevnom" name="prevnom" autocomplete="off" value = "${eleve.getPrevNom() }" /></p>
					<p><label for="prevprenom">Prenom</label><input type="text" id="prevprenom" name="prevprenom" autocomplete="off" value="${eleve.getPrevPrenom()}" /></p>
					<p><label for="prevtel">TEL</label><input type="text" id="prevtel" name="prevtel" autocomplete="off" value="${eleve.getPrevTel()}" /></p>
					<input type="hidden" name ="id" value = " ${eleve.getId()}">
					<input type="hidden" name ="previd" value = " ${eleve.getPrevid()}">
					<hr /><br /><br />
					<p>
						Cliquez sur <input type="submit" name="valider" value="Valider" /> pour modifier les informations,
						<span class="effacer"><br /><br />sinon <input type="submit" name="valider" value="Effacer" />pour effacer l'&eacute;l&egrave;ve</span>
					</p>
				</div>
			</form>
		</article>
	</section>
</body>
</html>