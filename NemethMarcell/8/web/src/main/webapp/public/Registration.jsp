<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Registration</title>
<!-- css imports -->

<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/css/button.css"/>">
<link rel="stylesheet"
    href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

<!-- javascript imports -->
<script src="<c:url value="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="/resources/js/bootstrap.js"/>"></script>
<script src="<c:url value="/resources/js/registration_js.js"/>"></script>
<script src="<c:url value="https://use.fontawesome.com/c46cf86766.js"/>"></script>
<script src="<c:url value="https://code.jquery.com/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="https://code.jquery.com/ui/1.12.1/jquery-ui.js"/>"></script>
<script src="<c:url value="/resources/js/validator.min.js"/>"></script>
<script src="<c:url value="/resources/js/validator.js"/>"></script>


</head>
<body>

    <div class="blog-masthead">
        <div class="container">
            <nav class="blog-nav">
                <a class="blog-nav-item active" href="<c:url value="/index.jsp"/>">Home</a>

                <c:if test="${sessionScope.user ==null}">
                    <a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
                </c:if>
                
                <c:if test="${sessionScope.user ==null}">
                    <a class="blog-nav-item" href="<c:url value="/public/Registration.jsp"/>">Registration</a>
                </c:if>
                
                <c:if test="${sessionScope.user !=null}">
                    <a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout</a>
                </c:if>
                <a class="blog-nav-item"
                    href="<c:url value="/secured/secured.jsp"/>">Users</a>

            </nav>
        </div>
    </div>

	<div class="container">

		<div class="row">
			<div
				class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
				<form data-toggle="validator" role="form" action="<c:url value="/Register" ></c:url>"
					method="post">
					<h2 class="text-center" style="color: #FAFAFA">REGISTRATION</h2>
					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group has-feedback">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-user fa-fw"></i></span> 
									<input type="text"
									name="first_name" id="first_name" class="form-control input-lg "
									placeholder="First Name" data-error="Ne hagyd üresen!" required>
							</div>
							     <span class="glyphicon form-control-feedback" style="padding-top:6px" aria-hidden="true"></span>
    <div class="help-block with-errors"></div>
  </div>
  </div>
						<div class="col-xs-12 col-sm-6 col-md-6">
							<div class="form-group has-feedback">
							 <div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-user fa-fw"></i></span> <input type="text"
									name="last_name" id="last_name" class="form-control input-lg"
									placeholder="Last Name" data-error="Ne hagyd üresen!" required>
							</div>
							<span class="glyphicon form-control-feedback" style="padding-top:6px" aria-hidden="true"></span>
    <div class="help-block with-errors"></div>
							</div>
						</div>
					</div>
					
			
			<div class="form-group has-feedback">
			 <div class="input-group">
						<span class="input-group-addon"><i
							class="fa fa-user-circle-o"></i></span> <input type="text"
							name="user_name" id="user_name" class="form-control input-lg"
							placeholder="Username" data-error="Ne hagyd üresen" required>
					</div>
					
					       <span class="glyphicon form-control-feedback" style="padding-top:6px" aria-hidden="true"></span>
    <div class="help-block with-errors"></div>
  </div>
					<div class="form-group has-feedback">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope-o"></i></span>
						<input type="email" name="email" id="inputEmail"
							class="form-control input-lg" placeholder="Email Address"
							data-error="Bruh, that email address is invalid" required>
							</div>
							<span class="glyphicon form-control-feedback" style="padding-top:6px"aria-hidden="true"></span>
    <div class="help-block with-errors"></div>
  </div>
  
					
					<div class="row">
						<div class="col-xs-12 col-sm-6 col-md-6">
						  <div class="form-group has-feedback">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-key"></i></span>
								<input type="password" name="password" data-minlength="3" id="password"
									class="form-control input-lg" placeholder="Password" data-error="Minimum 3 karakter" required
									>
							</div>
							<span class="glyphicon form-control-feedback" style="padding-top:6px"aria-hidden="true"></span>
    <div class="help-block with-errors"></div>
							</div>
						</div>
						<div class="col-xs-12 col-sm-6 col-md-6">
						  <div class="form-group has-feedback">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-key"></i></span>
								<input type="password" name="password_confirmation"
									id="password_confirmation" class="form-control input-lg"
									placeholder="Confirm Password" data-minlength="3"
									data-error="Minimum 3 karakter" required
									>
							</div>
							<span class="glyphicon form-control-feedback" style="padding-top:6px"aria-hidden="true"></span>
    <div class="help-block with-errors"></div>
							</div>
						</div>
					</div>
					<div class="form-group has-feedback">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="fa fa-location-arrow"></i></span> <input type="text"
							name="address" id="address" class="form-control input-lg"
							placeholder="Address" data-error="Ne hagyd üresen" required>
					</div>
					<span class="glyphicon form-control-feedback" style="padding-top:6px"aria-hidden="true"></span>
    <div class="help-block with-errors"></div>
					</div>
					<div class="form-group has-feedback">
					<div class="input-group date" data-provide="datepicker">
						<div class="input-group-addon">
							<span class="fa fa-calendar-o"></span>
						</div>
						<input type="text" name="date" class="form-control input-lg" placeholder="Date of birth"
							id="datepicker" data-error="Ki kell választanod a dátumot" required>
						
					</div>
					<span class="glyphicon form-control-feedback" style="padding-top:6px"aria-hidden="true"></span>
    <div class="help-block with-errors"></div>
					</div>
					<div class="row form-group">
						<div class="col-xs-12">
							<legend style="color: #FAFAFA">Gender</legend>
							<div data-toggle="buttons">

								<label id="female1" class="btn btn-default btn-circle btn-lg"
									style="outline: none"> <input type="radio" id="female"
									name="sex" value="Female"><i class="fa fa-female" required></i></label>
								<label id="male1" class="btn btn-default btn-circle btn-lg"
									style="outline: none"> <input type="radio" id="male"
									name="sex" value="Male" required><i class="fa fa-male"></i></label>
							</div>
							<p></p>

						</div>
					</div>
					<div class="form-group has-feedback">
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-phone"></i></span>
						<input type="text" name="phone" id="phone"
							class="form-control input-lg" placeholder="Phone" data-error="Érvényes telefonszámot adj meg" required>
					</div>
					<span class="glyphicon form-control-feedback" style="padding-top:6px"aria-hidden="true"></span>
    <div class="help-block with-errors"></div>
					</div>
					<div class="row form-group">
						<div class="col-xs-4 col-sm-3 col-md-3">
							<span class="button-checkbox">
								<button type="button" class="btn" data-color="info"> Elfogadom
									</button> <input type="checkbox" name="t_and_c" id="t_and_c" data-error="El kell fogadnod a feltételeket" required
								class="hidden" value="1">
							</span>
							<div class="help-block with-errors"></div>
						</div>
						<div class="col-xs-8 col-sm-9 col-md-9">
							By clicking <strong class="label label-primary">Register</strong>,
							you agree to the <a href="#" data-toggle="modal"
								data-target="#t_and_c_m">Terms and Conditions</a> set out by
							this site, including our Cookie Use.
						</div>
                
					</div>

					<hr class="colorgraph">
					<div class="row">
						<div class="col-xs-12 col-md-6">
							<input type="submit" value="Register"
								class="btn btn-primary btn-block btn-lg gomb" tabindex="7">
						</div>
						<div class="col-xs-12 col-md-6">
							<a href="login.jsp" class="btn btn-success btn-block btn-lg gomb">Sign
								In</a>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>