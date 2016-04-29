<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Vector, bean.Personne" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="CSS/principal.css"  > 
	<link rel="stylesheet" href="CSS/menu.css">
	<link rel="stylesheet" href="CSS/rechercheEleveCadre.css">
	<title>Informations employés</title>
</head>
<body>
	<%@ include file = "header.jsp"%>
	<nav>
		<%@ include file = "menu.jsp"%>
	</nav>
	<section>
		<article>
			<h2>RECHERCHER UN EMPLOYE</h2>
			<hr>
			<p>
				Tapez le nom complet ou les premi&egrave;res lettres du nom de l'employ&eacute; &agrave; rechercher.<br>
				Affinez votre recherche grace aux r&eacute;sultats propos&eacute;s.
			</p>
			<form method="post" action="InfosEmploye">
				<p>
					<label for="nom">Nom</label><input type = "text" id="nom" name="nom"  autocomplete="off" placeholder="nom de l'employé">
					<select name = "poste">
						<option value="Tout Poste">Tout Poste</option>
						<option value="Cuisine">Cuisine</option>
						<option value="Administration">Administration</option>
						<option value="Garderie">Garderie</option>
						<option value="Maintenance">Maintenance</option>
						<option value="Instit">Instit</option>
					</select>  
					&nbsp;<input type = "submit" value = "Rechercher">
				</p>
			</form>
			<div class = "resultat" style="display: ${visible ? 'block' : 'none'}">
				<c:choose>
					<c:when test="${!empty requestScope.name }">
						<table>
							<tr>
								<th>&nbsp;Nom&nbsp;</th>
								<th>&nbsp;prénom&nbsp;</th>
								<th>&nbsp;Poste&nbsp;</th>
							</tr>
							<c:forEach items="${ requestScope.tab_personne }" var="personne">
								<tr>
									<td><a href="ModifEmploye?id=<c:out value="${personne.getId()}" />"><c:out value="${ personne.getNom() }" /></a></td>
									<td><c:out value="${ personne.getPrenom() }" /></td>
									<td><c:out value="${ personne.getStatut() }" /></td>
								</tr>
							</c:forEach>
						</table>
					</c:when>
					<c:otherwise>
						<span class ="vide"><c:out value="VEUILLEZ SAISIR AU MOINS UNE LETTRE !" /></span>
					</c:otherwise>
				</c:choose>
			</div>
		</article>
	</section>
</body>
</html>