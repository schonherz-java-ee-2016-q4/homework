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
					href="<c:url value="/secured/secured.jsp"/>">Users</a>

			</nav>
		</div>
	</div>

	<div class="container">

		<div class="alert alert-info">
			<strong>Info!</strong> You can create a post using the form!
		</div>

		<div class="well">
			<h3 class="text-center">Creating a post</h3>
			<hr>
			<form id="createpost" action="/Blog/Post" method="post">
				<div class="form-group">
					<label for="title">Title:</label> <input type="text"
						class="form-control" id="title" name="title"
						placeholder="The title of the post..." required>
				</div>
				<div class="form-group">
					<label for="content">Content:</label>
					<textarea class="form-control" rows="10" id="content" name="content" placeholder="Content of the post..." required></textarea>
				</div>
				<input class="btn btn-info"type="submit" value="Create a post!">
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
	<%--     <script src="<c:url value="/resources/js/blog.js"/>"></script> --%>
</body>
</html>
