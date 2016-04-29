<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.Vector, bean.Personne" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="CSS/principal.css"  > 
	<link rel="stylesheet" href="CSS/menu.css">
	<link rel="stylesheet" href="CSS/rechercheEleveCadre.css"> 
<title>Infos Classe</title>
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
<div class="resultat">  
<%
				
					Vector<Personne> tab_classe = (Vector<Personne>) request.getAttribute("tab_classe");
					out.println("<table>");
					
					out.println("<tr><th>&nbsp;Nom&nbsp;</th>");
					out.println("<th>&nbsp;prénom&nbsp;</th>");
					out.println("<th>&nbsp;Date de naissance&nbsp;</th></tr>");
					
					
					for (Personne i : tab_classe) {
						out.println("<tr><td><a href = \"modifEleve?id="+i.getId()+"\">"+ i.getNom() + "</a></td><td>" + i.getPrenom() + "</td><td>"
								+i.getDateNaissance()+"</td></tr>");
					
					}
				
						
					out.println("</table>");
				
			
			 	%>  
			 	</div>
			 		</article>
	</section>  	
</body>
</html>