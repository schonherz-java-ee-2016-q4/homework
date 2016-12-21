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

        <title>Login</title>

        <!-- Bootstrap core CSS -->
        <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">
        <!-- Custom styles for this template -->
        <link href="<c:url value="/resources/css/my.css"/>" rel="stylesheet">
    </head>

    <body>
        <!-- Page header -->
        <div class="blog-masthead">
            <div class="container">
                <nav class="blog-nav">
                    <label>Welcome, ${sessionScope.user.login.username}</label>
                    <a class="blog-nav-item" href="<c:url value="/logOutServlet"/>">Logout</a>
                </nav>
            </div>
        </div>

        <!-- Container of user data -->
        <div class="container">
            <div class="row" id="result"></div>
        </div>

        <!-- Shown when clink on the view details button -->
        <div class="loader col-sm-offset-6"></div>
        <div id="myModal" class="modal fade" role="dialog"></div>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
        <script src="<c:url value="/resources/js/user.js"/>"></script>
    </body>
</html>
