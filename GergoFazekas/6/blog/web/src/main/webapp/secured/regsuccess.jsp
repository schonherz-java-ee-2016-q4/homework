<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register succesfully</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
    rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/my.css"/>" rel="stylesheet">

</head>
<body>

	<div class="blog-masthead">
		<div class="container">
			<nav class="blog-nav"> <a class="blog-nav-item "
				href="<c:url value="/index.jsp"/>">Home</a> <c:if
				test="${sessionScope.user ==null}">
				<a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
			</c:if> <c:if test="${sessionScope.user !=null}">
				<a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout</a>
			</c:if> <a class="blog-nav-item active"
				href="<c:url value="/secured/secured.jsp"/>">Users</a> </nav>
		</div>
	</div>

	<div class="container">

		<div class="alert alert-info">
			<strong>Info!</strong> You're registered successfully!
		</div>


	</div>
	<!-- /.container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>