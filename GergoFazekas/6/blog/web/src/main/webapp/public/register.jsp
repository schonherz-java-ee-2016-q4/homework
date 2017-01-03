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


<title>Registration</title>

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


<link href="<c:url value="/resources/css/register.css"/>"
	rel="stylesheet">

<link rel="stylesheet"
	href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

</head>

<body>

	<div class="container">

		<div class="page-header">
			<h1 class="text-center">Registration</h1>
		</div>
		<div class="alert alert-info">
			<strong>Info!</strong> To complete the registration fill all of the
			fields below with valid data, and click on the Submit button! :)
		</div>
		<form id="registration" method="post"
			action="/Blog/Register">
			<div class="wellregister">
				<h3 class="text-center">Basic info</h3>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>First Name</label> <input type="text" name="firstname"
								id="firstname" class="form-control input-sm"
								placeholder="First Name" required>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>Last Name</label> <input type="text" name="lastname"
								id="lastname" class="form-control input-sm"
								placeholder="Last Name" required>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>Gender</label><br>
							<label class="radio-inline"> <input type="radio"
								name="gender" value="female" checked>Female
							</label> <label class="radio-inline"> <input type="radio"
								name="gender" value="male">Male
							</label>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>Date of birth</label> <input type="text" name="dob"
								id="dob" class="form-control input-sm"
								placeholder="Date of birth" required>
						</div>
					</div>
				</div>
				<div class="alert alert-danger" id="alertbasic"></div>
			</div>
			<div class="wellregister">
				<h3 class="text-center">Location info</h3>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>State</label> <input type="text" name="state" id="state"
								class="form-control input-sm" placeholder="State" required>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>Postcode</label> <input type="text" name="postcode"
								id="postcode" class="form-control input-sm"
								placeholder="Postcode" required>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>City</label> <input type="text" name="city" id="city"
								class="form-control input-sm" placeholder="City" required>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>Street</label> <input type="text" name="street" id="dob"
								class="form-control input-sm" placeholder="Street" required>
						</div>
					</div>
				</div>
				<div class="alert alert-danger" id="alertlocation"></div>
			</div>
			<div class="wellregister">
				<h3 class="text-center">Login info</h3>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>E-mail</label> <input type="text" name="email" id="email"
								class="form-control input-sm" placeholder="E-mail" required>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>Username</label> <input type="text" name="username"
								id="username" class="form-control input-sm"
								placeholder="Username" required>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>Password</label> <input type="password" name="password1"
								id="password1" class="form-control input-sm"
								placeholder="Password" required>
						</div>
					</div>
					<div class="col-xs-12 col-sm-6 col-md-6">
						<div class="form-group">
							<label>Password again</label> <input type="password"
								name="password2" id="password2" class="form-control input-sm"
								placeholder="Password again" required>
						</div>
					</div>
				</div>
				<div class="alert alert-danger" id="alertlogin"></div>
			</div>
			<div class="wellregister">
				<h3 class="text-center">Picture info</h3>
				<div class="row">
					<div class="col-xs-12 col-md-4">
						<div class="form-group">
							<label>Large picture URL</label> <input type="text" name="large"
								id="large" class="form-control input-sm" placeholder="Large URL"
								required>
						</div>
					</div>
					<div class="col-xs-12 col-md-4">
						<div class="form-group">
							<label>Medium picture URL</label> <input type="text"
								name="medium" id="medium" class="form-control input-sm"
								placeholder="Medium URL" required>
						</div>
					</div>
					<div class="col-xs-12 col-md-4">
						<div class="form-group">
							<label>Thumbnail picture URL</label> <input type="text"
								name="thumbnail" id="thumbnail" class="form-control input-sm"
								placeholder="Thumbnail URL">
						</div>
					</div>
				</div>
				<div class="alert alert-danger" id="alertpicture"></div>
			</div>
			<!--            <button class="btn btn-lg btn-success pull-right" type="submit" id="btn_submit">Submit!</button> -->
			<input type="submit" value="Submit"
				class="btn btn-lg btn-success pull-right">
		</form>
	</div>
	<!-- /container -->

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/register.js"/>"></script>
	<script
		src="<c:url value="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.js"/>"></script>
	<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

</body>
</html>
