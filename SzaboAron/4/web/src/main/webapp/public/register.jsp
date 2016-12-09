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
<script src="<c:url value="https://code.jquery.com/ui/1.12.1/jquery-ui.js"/>"></script>
<link href="<c:url value="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css"/>" rel="stylesheet">

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

<link href="<c:url value="/resources/css/register.css"/>" rel="stylesheet">

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
		<form class="form-horizontal" role="form" action="<c:url value="/Register" ></c:url>"  method="post">
			<h2>Registration Form</h2>
			
			<div class="form-group">
                <label for="username" class="col-sm-3 control-label">First Name</label>
                <div class="col-sm-9">
                    <div>
                        <input type="text" id="username" name="username" placeholder="Username" class="form-control">
                    </div>
                    <div class="alert alert-danger" id="danger_username">
                        <strong>Dont't leave this section empty!</strong>
                    </div>
                </div>
            </div>
			
			<div class="form-group">
				<label for="firstname" class="col-sm-3 control-label">First Name</label>
				<div class="col-sm-9">
					<div>
						<input type="text" id="firstname" name="firstname" placeholder="First Name" class="form-control">
					</div>
					<div class="alert alert-danger" id="danger_firstname">
						<strong>Dont't leave this section empty!</strong>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="lastname" class="col-sm-3 control-label">Last Name</label>
				<div class="col-sm-9">
					<div>
						<input type="text" id="lastname" name="lastname" placeholder="Last Name" class="form-control">
					</div>
					<div class="alert alert-danger" id="danger_lastname">
						<strong>Dont' leave this section empty!</strong>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="email" class="col-sm-3 control-label">Email</label>
				<div class="col-sm-9">
					<div>
						<input type="email" name="email" id="email" placeholder="Email" class="form-control">
					</div>
					<div class="alert alert-danger" id="danger_email">
						<strong>It's not a valid e-mail address!</strong>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="password" class="col-sm-3 control-label">Password</label>
				<div class="col-sm-9">
					<div>
						<input type="password" name="password" id="password" placeholder="Password" class="form-control">
					</div>
					<div class="alert alert-danger" id="danger_password">
						<strong>Dont' leave this section empty!</strong>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="confirm" class="col-sm-3 control-label">Confirm</label>
				<div class="col-sm-9">
					<div>
						<input type="password" id="confirm" placeholder="Confirm Password" class="form-control">
					</div>
					<div class="alert alert-danger" id="danger_confirm">
						<strong>Confirmation failure</strong>
					</div>
				</div>
			</div>
			<div class="form-group">
				<label for="date" class="col-sm-3 control-label">Birth Date</label>
				<div class='col-sm-9'>
					<div>
						<input type='text' name="birthdate" class="form-control" placeholder="Birth date" id='date' />
					</div>
					<div class="alert alert-danger" id="danger_date">
						<strong>It's not a valid date</strong>
					</div>
				</div>
			</div>
			<div class="alert alert-danger hidden">
				<strong>Danger!</strong> Indicates a dangerous or potentially negative action.
			</div>
			<div class="form-group">
				<label for="country" class="col-sm-3 control-label">Country</label>
				<div class="col-sm-9">
					<select id="country" name="country" class="form-control">
					</select>
				</div>
			</div>
			<!-- /.form-group -->
			<div class="form-group">
				<label class="control-label col-sm-3">Gender</label>
				<div class="col-sm-6">
					<div class="row">
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio" id="femaleRadio" name="female" value="Female">Female
							</label>
						</div>
						<div class="col-sm-4">
							<label class="radio-inline"> <input type="radio" id="maleRadio" name="male" value="Male">Male
							</label>
						</div>
					</div>
				</div>
			</div>
			<!-- /.form-group -->


			<!-- /.form-group -->

			<div class="form-group">
				<div class="col-sm-12">
					<button type="submit" class="btn btn-primary btn-block" id="btn_register">Register</button>
				</div>
			</div>
		</form>
		<!-- /form -->
	</div>
	<!-- ./container -->



</body>
</html>