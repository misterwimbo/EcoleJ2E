<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Inscription &eacute;l&egrave;ve</title>
	<link rel="stylesheet" href="CSS/principal.css"  > 
	<link rel="stylesheet" href="CSS/menu.css">
	<link rel="stylesheet" href="CSS/inscriptionelevecadre.css"> 
	<script src="JS/formulaire.js"></script>
</head>
<body>
	<%@ include file = "header.jsp"%>
	<nav>
		<%@ include file = "menu.jsp"%>
	</nav>
	<section>
		<article>
			<h2>INSCRIRE UN ELEVE</h2>
			<hr />
			<form name="formulaire" method="post" action="modifEleve" onSubmit="return verifform()"> <!--  ne pas oublié à changer en post -->   
				<!--Formulaire infos eleves-->
				<div class = "eleve">
					<h2>Informations sur l'&eacute;l&egrave;ve:</h2>
					<p><label for="nom">Nom</label><input type="text" id="nom" name="nom" size="32"  autocomplete="off" placeholder="nom de l'élève" /></p>
					<p><label for="prenom">Pr&eacute;nom</label><input type="text" id="prenom" name="prenom" size="32" autocomplete="off" placeholder="prénom de l'élève" /></p>
					<p><label for="jour">Age</label><input type="text" id="jour" name="age" size="32"  autocomplete="off" placeholder="AAAA/MM/JJ  Ex:2010/04/05" /></p>
					<!-- <label for="sexe">Sexe</label><SELECT name="sexe" size="1"><OPTION>M<OPTION>F</SELECT></p> -->
					<p><label for="adr">Adresse</label></p><br>
					<p><textarea id="adr" name="adresse" rows="5" cols="50"></textarea></p>
				</div>
				<!--formulaire personne à prevenir-->
				<div class = "prevenir">
					<h2>Personne à prévenir:</h2>
					<p><label for="prevnom">Nom</label><input type="text" id="prevnom" name="prevnom" autocomplete="off" placeholder="nom de la personne" /></p>
					<p><label for="prevprenom">Pr&eacute;nom</label><input type="text" id="prevprenom" name="prevprenom" autocomplete="off" placeholder="prénom de la personne" /></p>
					<p><label for="prevtel">TEL</label><input type="text" id="prevtel" name="prevtel" autocomplete="off" /></p>
					<hr /><br /><br />
					<p>
						Cliquez sur <input type="submit" name = "valider" value="Inscrire"> pour soumettre votre requ&ecirc;te.,
						sinon <input type="reset" value="Annuler">
					</p>
				</div>
			</form>
		</article>
	</section>
</body>
</html>