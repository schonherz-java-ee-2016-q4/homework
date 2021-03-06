<!DOCTYPE html>
<%@page import="hu.schonherz.blog.service.UserServiceImpl"%>
<%@page import="hu.schonherz.blog.data.dao.UserDAO"%>
<%@page import="java.util.List"%>
<%@page import="hu.schonherz.blog.service.api.user.vo.UserVO"%>
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
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">


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

	<div class="blog-masthead">
		<div class="container">
			<nav class="blog-nav">
				<a class="blog-nav-item " href="<c:url value="/index.jsp"/>">Home</a>
				<c:if test="${sessionScope.user ==null}">
					<a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
				</c:if>
				<c:if test="${sessionScope.user !=null}">
					<a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout</a>
				</c:if>
				<a class="blog-nav-item active"
					href="<c:url value="/secured/secured.jsp"/>">Users</a> <a
					class="blog-nav-item"
					href="<c:url value="/secured/createpost.jsp"/>">Create Post</a>

			</nav>
		</div>
	</div>

	<div class="container">

		<div class="alert alert-info">
			<strong>Info!</strong> You can use filters below to get a filtered
			user list! This is optional. Of course, if you don't use filters, you
			will get all of the users!
		</div>

		<div id="flip" class="well">
			<h5 class="text-center">Click here to get the search form!</h5>
		</div>
		<div id="panel" class="well" style="display: none">
			<form id="searchform">
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group">
							<input type="text" class="form-control" id="name" name="name"
								placeholder="Type the name..."> <span
								class="input-group-btn">
								<button class="btn btn-success" type="button" id="searchbyname">Search
									by name!</button>
							</span>
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->
					<div class="col-lg-6">
						<div class="input-group">
							<input type="text" class="form-control" id="gender" name="gender"
								placeholder="Type the gender..."> <span
								class="input-group-btn">
								<button class="btn btn-default" type="button"
									id="searchbygender">Search by gender!</button>
							</span>
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->
				</div>
				<br>
				<div class="row">
					<div class="col-lg-6">
						<div class="input-group">
							<input type="text" class="form-control" id="city" name="city"
								placeholder="Type the city..."> <span
								class="input-group-btn">
								<button class="btn btn-success" type="button" id="searchbycity">Search
									by city!</button>
							</span>
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->
					<div class="col-lg-6">
						<div class="input-group">
							<input type="text" class="form-control" id="email" name="email"
								placeholder="Type the email address..."> <span
								class="input-group-btn">
								<button class="btn btn-default" type="button" id="searchbyemail">Search
									by email!</button>
							</span>
						</div>
						<!-- /input-group -->
					</div>
					<!-- /.col-lg-6 -->
				</div>
				<!-- /.row -->
			</form>
		</div>
		<div class="row" id="result"></div>
	</div>
	<!-- /.container -->
	<div class="loader col-sm-offset-6"></div>
	<div id="myModal" class="modal fade" role="dialog"></div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/user.js"/>"></script>
</body>
</html>
