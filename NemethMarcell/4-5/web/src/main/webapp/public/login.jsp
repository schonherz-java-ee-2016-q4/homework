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
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">


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

<body style="background-color: white">
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
		<div class="col-sm-6 col-sm-offset-3">
			<c:if test="${requestScope.error != null}">
				<div class="alert alert-danger" role="alert">
					<span class="glyphicon glyphicon-exclamation-sign"
						aria-hidden="true"></span> ${requestScope.error}
				</div>

			</c:if>
			</div>
		</div>
		<div class="row">
			<form class="form-signin" style="border-radius:10px" action="<c:url value="/Login" ></c:url>" method="post">

				<h1 class="form-signin-heading legend text-center" style="color: #FAFAFA">Please sign in</h1>
				<div id="inputemail">
				<label for="inputEmail" class="sr-only">Username</label> <input
					type="text" name="username" id="inputEmail" class="form-control"
					placeholder="Username" required autofocus> 
				</div>
					<div>
					<label
					for="inputPassword" class="sr-only">Password</label> <input
					type="password" name="password" id="inputPassword"
					class="form-control" placeholder="Password" required>
					 </div>
				<div class="checkbox">
					<label style="color:#FAFAFA"> <input type="checkbox" value="remember-me">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
					in</button>

			</form>
		</div>

	</div>
	<!-- /container -->



</body>
</html>
