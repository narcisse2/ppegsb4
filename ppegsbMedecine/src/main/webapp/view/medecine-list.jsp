<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title> List</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	
	<div class = "container">
		
		<h1> Liste des Medecins </h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
	
		<table class = "table table-striped table-bordered">
			
			<tr class = "thead-dark">
				<th>Nom</th>
				<th>Prenom</th>
				<th>Adress</th>
				<th>Tel</th>
				<th>Spe</th>
				<th>Departement</th>
			</tr>
			
			<c:forEach items="${list}" var="theList">
			
				<tr>
				    
					<td>${theList.nom}</td>
					<td>${theList.prenom}</td>
					<td>${theList.adress}</td>
					<td>${theList.tel}</td>
					<td>${theList.spe}</td>
					<td>${theList.departement }</td>
			
			
					
					
					
					<td> 
					
						| 
						<a href = "${pageContext.request.contextPath}/getMedical?action=DELETE&id=${medecine.id}">Delete</a> 
					</td>
				</tr>
				
			</c:forEach>
			
		</table>
		
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>