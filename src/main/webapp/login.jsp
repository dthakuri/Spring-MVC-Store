<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
	<header style="height: 30px; background-color: #03a9f4;"> </header>
	<div class="container">
		<br /> <img src="images/banner-home-middle.png" style="height: 150px;"
			class="img-thumbnail"> <img
			src="${pageContext.request.contextPath}/images/sleeping.png"
			style="height: 150px;" class="img-thumbnail"> <img
			src="${pageContext.request.contextPath}/images/student.png"
			style="height: 150px;" class="img-thumbnail">
		<hr />
		<span style="font-size: 18px; color: red;">${msg}</span> <br />
		<div style="width: 50%">
			<form action="auth" method="post">
				<label><b>Username</b></label> <input type="text" name="username"
					class="form-control"> <label><b>Password</b></label> <input
					type="password" name="password" class="form-control"> <br />
				<button type="submit" class="btn btn-primary">Login</button>
				<button type="reset" class="btn btn-info">Clear</button>
				<a href="${pageContext.request.contextPath}/register">
					<button type="button" class="btn btn-danger">Register</button>
				</a> <a href="${pageContext.request.contextPath}/forgetPass">
					<button type="button" class="btn btn-warning">Forgot Pass</button>
				</a> <a href="${pageContext.request.contextPath}/search">
					<button type="button" class="btn btn-primary">Search</button>
				</a>

			</form>
		</div>
	</div>
</body>
</html>