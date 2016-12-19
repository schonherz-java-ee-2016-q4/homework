<%@tag description="Page template" pageEncoding="UTF-8"%>

<%@attribute name="title" fragment="true"%>
<%@attribute name="customHead" fragment="true"%>
<%@attribute name="customBody" fragment="true"%>
<%@attribute name="customFooter" fragment="true"%>
<%@attribute name="customScripts" fragment="true"%>

<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">
<link rel="stylesheet" href="<c:url value="/resources/css/font-awesome.min.css"/>">
<link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">

<title><jsp:invoke fragment="title" /></title>

<jsp:invoke fragment="customHead" />

</head>
<body>

	<div class="blog-masthead">
		<div class="container">
			<nav class="blog-nav">
				<a class="blog-nav-item" href="<c:url value="/index.jsp"/>"
					id="nav_home">Home</a> <a class="blog-nav-item"
					href="<c:url value="/secured/secured.jsp"/>" id="nav_users">Users</a>

				<div class="navbar-right">
					<c:if test="${pageContext.request.userPrincipal==null}">
						<a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
						<a class="blog-nav-item"
							href="<c:url value="/public/register.jsp"/>">Register</a>
					</c:if>
					<c:if test="${pageContext.request.userPrincipal!=null}">
						<a class="blog-nav-item"
							href="<c:url value="/secured/create_blogpost.jsp"/>" id="nav_create_post">Create
							post</a>
						<a class="blog-nav-item" href="<c:url value="/logout"/>">Logout</a>
					</c:if>
					<a href="<c:url value="/rss"/>"><i class="fa fa-rss" aria-hidden="true"></i></a>
				</div>

			</nav>
		</div>
	</div>


	<div class="container">
		<jsp:invoke fragment="customBody" />
	</div>


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

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript">
	function getContextPath() {
	   return "<c:out value="${pageContext.request.contextPath}" />";
	}
	</script>

	<jsp:invoke fragment="customScripts"></jsp:invoke>


</body>
</html>

