<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>"
          rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/blog.css"/>" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/my.css"/>" rel="stylesheet">
    <title>Success</title>
</head>
<body>

<div class="blog-masthead">
    <div class="container">
        <nav class="blog-nav">
            <a class="blog-nav-item " href="<c:url value="/"/>">Home</a> <a
                class="blog-nav-item active" href="<c:url value="/registration/"/>">Register</a>
            <c:if test="${sessionScope.user ==null}">
                <a class="blog-nav-item" href="<c:url value="/login/"/>">Login</a>
            </c:if>
            <c:if test="${sessionScope.user !=null}">
                <a class="blog-nav-item" href="<c:url value="/logout/"/>">Logout</a>
            </c:if>
            <a class="blog-nav-item" href="<c:url value="/users"/>">Users</a>
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
<div class="panel panel-success">
    <div class="panel-heading">
        <strong>Registration succes</strong>
    </div>
    <div class="panel-body">Now, you can log in the site</div>
</div>
</body>
</html>