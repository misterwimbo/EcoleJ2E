<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="CSS/principal.css"  > 
	<link rel="stylesheet" href="CSS/menu.css">
	<link rel="stylesheet" href="CSS/inscriptionelevecadre.css"> 
	<title>Modification Employe</title>
</head>
<body>
	<%@ include file = "header.jsp"%>
	<nav>
		<%@ include file = "menu.jsp"%>
	</nav>
	<section>
		<article>
			<h2>
				MODIFIER UN EMPLOYE
				<span class ="NiveauClasse">
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				${employe.getNom()} 
				${employe.getPrenom()}
				</span>
			</h2>
			<hr>
			<form method="post" action="ModifEmploye">    
				<div class = "eleve">
					<h2>Informations sur l'employ&eacute;:</h2>
						<fieldset>
							<legend>Infos personnelle</legend>
							<label for="nom">Nom</label><input type="text" id="nom" name="nom" size="32"  autocomplete="off" value="${employe.getNom()}" /><br />
							<label for="prenom">Pr&eacute;nom</label><input type="text" id="prenom" name="prenom" size="32" autocomplete="off" value="${employe.getPrenom()}" /><br />
							<label for="poste">Poste</label>
							<select name="poste">
								<option value="Cuisine" ${employe.getStatut() == 'Cuisine' ? 'selected' : ''}>Cuisine</option>
								<option value="Administration" ${employe.getStatut() == 'Administration' ? 'selected' : ''}>Administration</option>
								<option value="Garderie" ${employe.getStatut() == 'Garderie' ? 'selected' : ''}>Garderie</option>
								<option value="Maintenance" ${employe.getStatut() == 'Maintenance' ? 'selected' : ''}>Maintenance</option>
								<option value="Instit" ${employe.getStatut() == 'Instit' ? 'selected' : ''}>Instit</option>
							</select>
						</fieldset>
						<!-- <fieldset>
							<legend>Adresse</legend>
							<label for="adr">Adresse</label><textarea id="adr" name="adresse" rows="5" cols="50" >${employe.getAdresse()}</textarea>
						</fieldset> -->
						<input type="hidden" name="id" value=" ${employe.getId()}">
						<p>
							Cliquez sur <input type="submit" name = "valider" value="Valider"> pour modifier les informations,
							<span class = "effacer"><br><br>sinon <input type="submit" name ="valider" value="Effacer">pour effacer l'employ&eacute;</span>
						</p>
				</div>
			</form>
		</article>
	</section>
</body>
</html>