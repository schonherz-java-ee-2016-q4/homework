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
	<nav class="navbar navbar-default">
	  <div class="container">
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="<c:url value="/index.jsp"/>">Blog</a>
	    </div>
	
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li id="nav_home"><a class="blog-nav-item" href="<c:url value="/index.jsp"/>">Home</a></li>
	        <c:if test="${pageContext.request.userPrincipal!=null}">
	        <li id="nav_users"><a class="blog-nav-item" href="<c:url value="/secured/secured.jsp"/>">Users</a></li>
	        </c:if>
	      </ul>
	      <ul class="nav navbar-nav navbar-right">
	        <c:if test="${pageContext.request.userPrincipal==null}">
	        <li id="nav_login"><a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a></li>
	        <li id="nav_register"><a class="blog-nav-item" href="<c:url value="/public/register.jsp"/>">Register</a></li>
	        </c:if>
	        
	        <c:if test="${pageContext.request.userPrincipal!=null}">
	        <li class="dropdown">
                 <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">${pageContext.request.userPrincipal.name} <span class="caret"></span></a>
                 <ul class="dropdown-menu" role="menu">
                   <li><a class="blog-nav-item" href="<c:url value="/secured/create_blogpost.jsp"/>">Create post</a></li>
                   <li class="divider"></li>
                   <li><a class="blog-nav-item" href="<c:url value="/logout"/>">Logout</a></li>
                 </ul>
               </li>
               </c:if>
               
               <li><a href="<c:url value="/rss"/>"><i class="fa fa-rss" aria-hidden="true"></i></a></li>
	      </ul>
	    </div>
	  </div>
   </nav>
	
	
	<div class="container">
        <div class="row">
          <div class="col-md-10 col-md-offset-1">
		<jsp:invoke fragment="customBody" />
		  </div>
		</div>
	</div>


	<footer class="blog-footer">
		<p>
			Thanks to visit the site!
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

