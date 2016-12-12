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
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Starter Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/my.css"/>" rel="stylesheet">



<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="blog-masthead navbar-fixed-top" class="container" data-spy="affix" data-offset-top="0">
		<div class="container">
			<nav class="nav blog-nav ">
				<a class="blog-nav-item" href="<c:url value="/index.jsp"/>">Home</a> <a class="blog-nav-item " href="<c:url value="/public/registration/register.jsp"/>">Register</a>
				<c:if test="${sessionScope.user ==null}">
					<a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
				</c:if>
				<c:if test="${sessionScope.user !=null}">
					<a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout</a>
				</c:if>
				<a class="blog-nav-item active" href="<c:url value="/secured/secured.jsp"/>">Users</a>
				<c:if test="${sessionScope.user !=null}">
					<div class="dropdown pull-right">
						<button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
							<c:out value="${sessionScope.user}"></c:out>
							<span class="caret"></span>
						</button>
						<ul class="dropdown-menu">

						</ul>
					</div>

				</c:if>
			</nav>
			<div class="panel panel-primary">
				<div class="panel-heading mypanel " id="filter_heading" onclick="on_header_clocked()">
						<h3>User filter</h3>

				</div>
				<div class="panel-body" id="filter_body">
					<form class="form-horizontal" id="filter_form" action="" method="get">
						<div class="form-group">
							<label for="age" class="col-sm-3 control-label">Age:</label>
							<div class="col-sm-9">
								<div>
									<input type="text" name="age" id="age" placeholder="Age" class="form-control">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="email" class="col-sm-3 control-label">E-mail:</label>
							<div class="col-sm-9">
								<div>
									<input type="text" name="email" id="email" placeholder="E-mail" class="form-control">
								</div>
							</div>
						</div>
						<div class="form-group">
							<label for="city" class="col-sm-3 control-label">City:</label>
							<div class="col-sm-9">
								<div>
									<input type="text" name="city" id="city" placeholder="city" class="form-control">
								</div>
							</div>
						</div>
						<button class="btn btn-default" type="submit" id="get_user">Filter</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="col-xs-12"></div>



	<div class="container" id="result">
		<div class="row" id="result"></div>
	</div>
	<!-- /.container -->
	<div class="loader col-sm-offset-6"></div>
	<div id="myModal" class="modal fade" role="dialog"></div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/user.js"/>"></script>
</body>
</html>
