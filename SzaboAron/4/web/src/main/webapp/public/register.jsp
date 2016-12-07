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


<title>Register</title>
<script src="<c:url value="/resources/js/jquery-3.1.1.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/register.js"/>"></script>
<script
	src="<c:url value="https://code.jquery.com/ui/1.12.1/jquery-ui.js"/>"></script>
<link
	href="<c:url value="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>"
	rel="stylesheet">

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<link href="<c:url value="/resources/css/register.css"/>"
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
		<form class="form-horizontal" role="form"
			action="<c:url value="" ></c:url>" method="post">
			<h2>Registration Form</h2>
			<div class="form-group">
				<label for="firstName" class="col-sm-3 control-label">First
					Name</label>
				<div class="col-sm-9">
					<input type="text" id="firstName" placeholder="First Name"
						class="form-control" autofocus>
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-3 control-label">Last
					Name</label>
				<div class="col-sm-9">
					<input type="text" id="lastname" placeholder="Last Name"
						class="form-control" autofocus>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">Email</label>
				<div class="col-sm-9">
					<input type="email" id="email" placeholder="Email"
						class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Password</label>
				<div class="col-sm-9">
					<input type="password" id="password" placeholder="Password"
						class="form-control">
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Birth
					Date</label>
				<div class='col-sm-9'>
					<input type='text' class="form-control col-sm-6"
						id='datetimepicker1' />
				</div>
			</div>
			<div class="form-group">
				<label for="country" class="col-sm-3 control-label">Country</label>
				<div class="col-sm-9">
					<select id="country" class="form-control">
						<option>Afghanistan</option>
						<option>Bahamas</option>
						<option>Cambodia</option>
						<option>Denmark</option>
						<option>Ecuador</option>
						<option>Fiji</option>
						<option>Gabon</option>
						<option>Haiti</option>
					</select>
				</div>
			</div>
			<!-- /.form-group -->
			<div class="form-group">
				<label class="control-label col-sm-3">Gender</label>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="femaleRadio" value="Female">Female
							</label>
						</div>
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio"
								id="maleRadio" value="Male">Male
							</label>
						</div>
					</div>
				</div>
			</div>
			<!-- /.form-group -->


			<!-- /.form-group -->
			<div class="form-group">
				<div class="col-sm-12 col-sm-offset-3">
					<button type="submit" class="btn btn-primary btn-block">Register</button>
				</div>
			</div>
		</form>
		<!-- /form -->
	</div>
	<!-- ./container -->



</body>
</html>