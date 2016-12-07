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

<title>Blog Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
    rel="stylesheet">


<link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">

</head>

<body>

    <div class="blog-masthead">
        <div class="container">
            <nav class="blog-nav">
                <a class="blog-nav-item active" href="<c:url value="/index.jsp"/>">Home</a>
                <a class="blog-nav-item"
                    href="<c:url value="/secured/secured.jsp"/>">Users</a>

                <div class="navbar-right">
                    <c:if test="${sessionScope.user ==null}">
                        <a class="blog-nav-item" href="<c:url value="/public/login.jsp"/>">Login</a>
                        <a class="blog-nav-item" href="<c:url value="/public/register.jsp"/>">Register</a>
                    </c:if>
                    <c:if test="${sessionScope.user !=null}">
                        <a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout</a>
                    </c:if>
                </div>

            </nav>
        </div>
    </div>

    <div class="container">

        <div class="blog-header">
            <h1 class="blog-title">Register succesful</h1>
        </div>

    </div>
    <!-- /.container -->



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
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
</body>
</html>
