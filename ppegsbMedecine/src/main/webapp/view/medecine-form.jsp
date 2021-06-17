<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body>
	
	<div class = "container">
	
		<h1>Medecine</h1>
		<hr/>
		
		<div class = "row">
			<div class = "col-md-4">
				<form action = "${pageContext.request.contextPath}/getMedical" method="POST">
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "name" placeholder = "Nom" value = "${medecine.nom}"/>
					</div>
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "dob" placeholder="Prenom" value = "${medecine.prenom}"/>
					</div>
				
					<div class="form-group">
					  	<input type = "text" class = "form-control" name = "department" placeholder = "Enter Department" value = "${medecine.department}"/>
					</div>
				
					<input type = "hidden" name = "id" value = "${medecine.id}"/>
				
					<button type = "submit" class = "btn btn-primary">Save</button>
				</form>
			</div>
		</div>
		<h3><a href = "${pageContext.request.contextPath}/getMedical?action=LIST">Voir les liste des Medecins</a></h3>
		
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>