<%@tag description="Simple Page Generator" pageEncoding="UTF-8"%>

<%@attribute name="title" fragment="true"%>
<%@attribute name="customBody" fragment="true"%>
<%@attribute name="customFooter" fragment="true"%>
<%@attribute name="customScripts" fragment="true"%>
<%@attribute name="customPageTitle" fragment="true"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">

<title><jsp:invoke fragment="title" /></title>

<link rel="icon" href="../../favicon.ico">
<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">


</head>

<body>

	<div class="blog-masthead">
		<div class="container">
			<nav class="blog-nav">
				<a class="blog-nav-item active" href="<c:url value="/index.jsp"/>">Home</a>

				<c:if test="${sessionScope.user == null}">
					<a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
				</c:if>
				<c:if test="${sessionScope.user == null}">
					<a class="blog-nav-item"
						href="<c:url value="/public/register.jsp"/>">Registration</a>
				</c:if>
				<c:if test="${sessionScope.user != null}">
					<a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout</a>
				</c:if>
				<a class="blog-nav-item"
					href="<c:url value="/secured/secured.jsp"/>">Users</a> <a
					class="blog-nav-item"
					href="<c:url value="/secured/createpost.jsp"/>">Create Post</a>

			</nav>
		</div>
	</div>

	<div class="container">
		<jsp:invoke fragment="customPageTitle" />
		<div class="row">
			<jsp:invoke fragment="customBody" />
		</div>
	</div>
	<!-- /.container -->

	<footer class="blog-footer">
		<p>
			Blog template built for <a href="http://getbootstrap.com">Bootstrap</a>
			by <a href="https://twitter.com/mdo">@mdo</a>.
		</p>
		<p>
			<a href="#">Back to top</a>
		</p>
	</footer>

	<jsp:invoke fragment="customFooter" />

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script src="/resources/js/bootstrap.min.js"></script>
	<jsp:invoke fragment="customScripts"></jsp:invoke>
</body>
</html>