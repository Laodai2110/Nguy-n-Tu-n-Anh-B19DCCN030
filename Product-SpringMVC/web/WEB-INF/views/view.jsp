<%-- 
    Document   : view
    Created on : May 8, 2022, 10:25:10 AM
    Author     : H
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Product Editor - Page</title>
	<!-- Latest compiled and minified CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"/>

	<!-- jQuery library -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

	<!-- Popper JS -->
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h2 class="text-center">Product Editor - Page</h2>
			</div>
			<div class="panel-body">
                            <form method="post" action="save.html">
				<div class="form-group">
				  <label for="usr">Title:</label>
                                  <input type="text" name="id" value="${product.id}" hidden="true"/>
                                  <input required="true" type="text" class="form-control" id="title" name="title" value="${product.title}"/>
				</div>
				<div class="form-group">
				  <label for="email">Thumbnail:</label>
                                  <input required="true" type="text" class="form-control" id="thumbnail" name="thumbnail" value="${product.thumbnail}"/>
				</div>
				<div class="form-group">
				  <label for="birthday">Price:</label>
                                  <input type="number" class="form-control" id="price" name="price" value="${product.price}"/>
				</div>
				<div class="form-group">
				  <label for="pwd">Discount:</label>
                                  <input required="true" type="number" class="form-control" id="discount" name="discount" value="${product.discount}"/>
				</div>
				<div class="form-group">
				  <label for="address">Description:</label>
                                  <textarea class="form-control" rows="5" name="content">${product.content}</textarea>
				</div>
				<button class="btn btn-success">Save</button>
                            </form>
			</div>
		</div>
	</div>
</body>
</html>