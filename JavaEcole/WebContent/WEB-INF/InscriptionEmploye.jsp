<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="CSS/principal.css"  > 
	<link rel="stylesheet" href="CSS/menu.css">
	<link rel="stylesheet" href="CSS/inscriptionelevecadre.css"> 
	<title>Inscription Employ&eacute;</title>
</head>
<body>
	<%@ include file = "header.jsp"%>
	<nav>
		<%@ include file = "menu.jsp"%>
	</nav>
	<section>
		<article>
			<h2>INSCRIRE UN EMPLOYE</h2>
			<hr />
			<form method="post" action="InscriptionEmploye">    
				<div class = "eleve">
					<h2>Informations sur l'employ&eacute;:</h2>
						<fieldset>
							<legend>Infos personnelle</legend>
							<label for="nom">Nom</label><input type="text" id="nom" name="nom" size="32" autocomplete="off" /><br />
							<label for="prenom">Pr&eacute;nom</label><input type="text" id="prenom" name="prenom" size="32" autocomplete="off" /><br />
							<label for="poste">Poste</label>
							<select name="poste">
								<option value="Cuisine">Cuisine</option>
								<option value="Administration">Administration</option>
								<option value="Garderie">Garderie</option>
								<option value="Maintenance">Maintenance</option>
								<option value="Instit">Instit</option>
							</select>
						</fieldset>
						<fieldset>
							<legend>Adresse</legend>
							<label for="adr">Adresse</label><input type="text" id="adr" name="adr" size="32" autocomplete="off" /><br />
							<label for="cp">CP</label><input type="text" id="cp" name="cp" size="32" autocomplete="off" /><br />
							<label for="ville">Ville</label><input type="text" id="ville" name="ville" size="32" autocomplete="off" />
						</fieldset>
						<input type="hidden" name="id" value=" ${employe.getId()}">
						<p>
							Cliquez sur <input type="submit" name = "valider" value="Valider"> pour soumettre votre requête.,
      						sinon <input type="reset" value="Annuler">
						</p>
				</div>
			</form>
		</article>
	</section>
</body>
</html>