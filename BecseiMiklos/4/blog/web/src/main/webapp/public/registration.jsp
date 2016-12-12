<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">


<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/signin.css"/>" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="container">

		<div class="col-sm-6 col-sm-offset-3">

			<c:if test="${requestScope.error != null}">
				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> ${requestScope.error}
				</div>

			</c:if>

			<div class="row">

				<form name="regform" action="<c:url value="/Register"></c:url>"
					onsubmit="return validatePasswords(this)" method="post">

					<h2>Registration</h2>

					<div class="panel panel-default">
						<div class="panel-heading">Personal data</div>
						<div class="panel-body">
							<div class="form-group">

								<label for="inputEmail">Email:</label>
								<input type="text" class="form-control" id="inputEmail" name="email"
									placeholder="me@example.com"> 
									
									<label for="username">Username:</label>
								<input type="text" class="form-control" id="username" name="username"
									placeholder="Username"> 
									
									<label for="inputPassword">Password:</label>
								<input type="password" class="form-control" id="inputPassword" name="password"
									placeholder="Password"> 
									
									<label for="inputConfirmPassword">Confirm password:</label> <input
									type="password" class="form-control" id="inputConfirmPassword" 
									name="confirmpassword" placeholder="Confirm password">
									
								<label for="phone">Phone:</label> <input type="text"
									class="form-control" id="phone" name="phone" placeholder="(555) 555-5555">
							</div>


						</div>
					</div>


					<div class="panel panel-default">
						<div class="panel-heading">Name</div>
						<div class="panel-body">
							<div class="form-group">

								<label for="title">Title:</label> <input type="text"
									class="form-control" id="title" name="title" placeholder="Title"> <label
									for="first">First:</label> <input type="text"
									class="form-control" id="first" name="first" placeholder="First name">
								<label for="last">Last:</label> <input type="text"
									class="form-control" id="last" name="last" placeholder="Last name">
							</div>


						</div>
					</div>

					<div class="panel panel-default">
						<div class="panel-heading">Location</div>
						<div class="panel-body">
							<div class="form-group">

								<label for="street">Street:</label> <input type="text"
									class="form-control" id="street" name="street" placeholder="Street">
								<label for="city">City:</label> <input type="text"
									class="form-control" id="city" name="city" placeholder="City"> <label
									for="state">State:</label> <input type="text"
									class="form-control" id="state" name="state" placeholder="State"> <label
									for="postcode">Postcode:</label> <input type="number"
									class="form-control" id="postcode" name="postcode" placeholder="ZIP">
							</div>


						</div>
					</div>


					<button class="btn btn-primary btn-lg" type="submit">Register</button>

				</form>
			</div>



		</div>
	</div>
	<script src="<c:url value="/resources/js/validate.js"/>"></script>
</body>
</html>
