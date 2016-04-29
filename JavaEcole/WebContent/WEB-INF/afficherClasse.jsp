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
			<h2>INFORMATIONS CLASSE</h2>
			<hr>
			<p>
				Choisissez une classe pour avoir la liste des eleves de celle-ci
			</p>
			<form method="post" action="AfficherClasse">
				<p>
					<label for="nom">Classe</label>
					<select name = "classe">
						<option value="1">PS(1)</option>
						<option value="2">MS(1)</option>
						<option value="3">GS(1)</option>
						<option value="4">CP(1)</option>
						<option value="5">CE1(1)</option>
						<option value="6">CE2(1)</option>
						<option value="7">CM1(1)</option>
						<option value="8">CM2(1)</option>
						<option value="9">PS(2)</option>
						<option value="10">MS(2)</option>
						<option value="11">GS(2)</option>
						<option value="12">CP(2)</option>
						<option value="13">CE1(2)</option>
						<option value="14">CE2(2)</option>
						<option value="15">CM1(2)</option>
						<option value="16">CM2(2)</option>
						
					</select>  
					&nbsp;<input type = "submit" value = "Rechercher">
				</p>
			</form>
		
		</article>
	</section>
</body>
</html>