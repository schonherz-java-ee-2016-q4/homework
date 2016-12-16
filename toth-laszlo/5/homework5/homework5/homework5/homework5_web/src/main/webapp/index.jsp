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
    <title>Off Canvas Template for Bootstrap</title>

    <!-- Latest compiled and minified CSS -->
    <link href="<c:url value="resources/css/bootstrap.min.css"/>" rel="stylesheet">
    

    <!-- Custom styles for this template -->
    <link href="<c:url value="resources/css/offcanvas.css"/>" rel="stylesheet">

    
  </head>

  <body>
<nav class="navbar navbar-fixed-top navbar-inverse col-sm-12">
        <div class="container-fluid">
            
            <div class="navbar-header">
                <a class="navbar-brand" href="<c:url value="index.jsp"/>">Blog</a>
            </div>
        
        <ul class="nav navbar-nav pull-right">
            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Menu
                    <span class="caret"></span>
                </a>
                <ul class="dropdown-menu pull-right">
                    <li><a href="<c:url value="secured/users.jsp"/>">Users</a></li>
                    <li><a href="<c:url value="secured/post.jsp"/>">Post</a></li>
                   <li>    <c:if test="${sessionScope.user ==null}">
                    <a class="blog-nav-item" href="<c:url value="login.jsp"/>">Login</a>
                </c:if>
                <c:if test="${sessionScope.user !=null}">
                    <a class="blog-nav-item" href="<c:url value="/Logout"/>">Logout(${sessionScope.user})</a>
                </c:if>
                   </li>
                </ul>
            </li>

        
        </ul>
        
        </div>
    </nav><!-- /.navbar -->    
    <div id=result>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <!-- Latest compiled and minified JavaScript -->
    <script src="resources/js/bootstrap.min.js"></script>

    <script src="resources/js/offcanvas.js"></script>
    <script src="resources/js/posts.js"></script>
  </body>
</html>
