<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				Tapez le nom complet ou les premi&egrave;res lettres du nom de l'&eacute;l&egrave;ve &agrave; rechercher.<br>
				Affinez votre recherche gr&acirc;ce aux r&eacute;sultats propos&eacute;s.
			</p>
			<form method="post" action="RechercheEleve">
				<p>
					<label for="nom">Nom</label><input type="text" id="nom" name="nom" autocomplete="off" placeholder="nom de l'élève" /> 
					&nbsp;<input type="submit" value="Rechercher" />
				</p>
			</form>
		</article>
	</section>
</body>
</html>