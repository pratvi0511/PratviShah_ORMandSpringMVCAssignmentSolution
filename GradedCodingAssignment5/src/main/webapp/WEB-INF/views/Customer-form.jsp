<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
	
	<style>
			
	.title-container{
		 background-color:green;
		    width: 100vw;
            height:100px;  
            text-align:center;
	}
	
	.title-container h3{
		color:white;
		padding:25px;
		
	}
	
	</style>
<title>Save Customer</title>


</head>
<body>
	<div class="title-container">
		<h3>Customer Relationship Management</h3>
	</div>
		
		
		<hr>
	

	<div class="container">

		
		<p class="h4 mb-4">Save Customer</p>

		<form action="/CustomerRelationshipManagement/customers/save" method="POST">

			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Customer.id}" />

			<div class="form-inline">
				<input type="text" name="first_Name" value="${Customer.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">



			</div>

			<div class="form-inline">

				<input type="text" name="last_Name" value="${Customer.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">



			</div>

			<div class="form-inline">

				<input type="text" name="email" value="${Customer.email}"
					class="form-control mb-4 col-4" placeholder="Email">



			</div>

			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/CustomerRelationshipManagement/customers/list">Back to Customer List</a>

	</div>
	
</body>
</html>