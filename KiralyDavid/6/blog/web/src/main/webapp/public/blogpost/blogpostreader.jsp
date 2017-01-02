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
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Example blog</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">


<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">


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
                <a class="blog-nav-item active" href="<c:url value="/index.jsp"/>">Home</a> <a class="blog-nav-item" href="<c:url value="/public/registration/register.jsp"/>">Register</a>
                <c:if test="${sessionScope.user ==null}">
                    <a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
                </c:if>
                <c:if test="${sessionScope.user !=null}">
                    <a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout</a>
                </c:if>
                <a class="blog-nav-item" href="<c:url value="/secured/secured.jsp"/>">Users</a>
                <c:if test="${sessionScope.user !=null}">
                    <div class="dropdown pull-right">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">
                            <c:out value="${sessionScope.user.username}"></c:out>
                            <span class="caret"></span>
                        </button>
                        <ul class="dropdown-menu">
                        </ul>
                    </div>

                </c:if>

            </nav>
        </div>
    </div>

    <div class="container" id="fullpost">
        
    </div>

    <footer class="blog-footer">
        <p>
            Blog template built for <a href="http://getbootstrap.com">Bootstrap</a> by <a href="https://twitter.com/mdo">@mdo</a>.
        </p>
        <p>
            <a href="#">Back to top</a>
        </p>
    </footer>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>
                    window.jQuery
                            || document
                                    .write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
                </script>
    <script src="/Blog/resources/js/bootstrap.min.js"></script>
    <script src="/Blog/resources/js/postreader.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
