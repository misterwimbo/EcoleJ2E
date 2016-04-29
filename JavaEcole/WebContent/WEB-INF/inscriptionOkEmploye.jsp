<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="CSS/principal.css"  > 
	<link rel="stylesheet" href="CSS/menu.css">
	<meta http-equiv="refresh" content="3; URL=ModifEmploye?id=${idEmploye}">
	<title>Inscription Employ&eacute;</title>
</head>
<body>
	<%@ include file = "header.jsp"%>
	<nav>
		<%@ include file = "menu.jsp"%>
	</nav>
	<section>
		<article>
			<h3>
				L'employ&eacute; est maintenant inscrit<br />
				Vous allez être redirig&eacute;
			</h3>
		</article>
	</section>
</body>
</html>